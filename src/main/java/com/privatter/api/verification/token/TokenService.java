package com.privatter.api.verification.token;

import com.privatter.api.utility.Pair;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    private TokenRepository repository;

    @Autowired
    private TokenConfiguration configuration;

    public TokenVerificationResult verifyByTokenId(String tokenId, String hash) {
        var tokenInfo = repository.findByTokenId(tokenId);

        if (tokenInfo == null)
            return TokenVerificationResult.NOT_FOUND;

        String generatedHash;

        try {
            generatedHash = generateHash(tokenInfo);
        } catch (Exception exception) {
            LoggerFactory
                .getLogger(TokenService.class)
                .error("Cannot generate hash", exception);
            return TokenVerificationResult.ERROR;
        }

        if (!hash.equals(generatedHash))
            return TokenVerificationResult.INVALID_HASH;

        if (tokenInfo.isActivated())
            return TokenVerificationResult.ACTIVATED;

        if (System.currentTimeMillis() >= tokenInfo.getExpiresAt())
            return TokenVerificationResult.EXPIRED;

        return TokenVerificationResult.OK;
    }

    public Pair<TokenEntity, String> createOrUpdate(TokenEntity tokenInfo) throws NoSuchAlgorithmException, InvalidKeyException {
        var existingToken = repository.findByUserIdAndAction(tokenInfo.getUserId(), tokenInfo.getAction());

        if (existingToken == null) {
            repository.save(tokenInfo);
            return new Pair<>(tokenInfo, generateHash(tokenInfo));
        }

        existingToken.setId(UUID.randomUUID().toString());
        existingToken.setCreatedAt(System.currentTimeMillis());
        existingToken.setExpiresAt(tokenInfo.getExpiresAt());
        existingToken.setActivated(false);

        repository.save(existingToken);

        return new Pair<>(existingToken, generateHash(existingToken));
    }

    public TokenRepository getRepository() {
        return repository;
    }

    private String generateHash(TokenEntity tokenInfo) throws NoSuchAlgorithmException, InvalidKeyException {
        var shortTokenInfo = tokenInfo.getId() + "|" +
            tokenInfo.getAction() + "|" +
            tokenInfo.getUserId() + "|" +
            tokenInfo.getExpiresAt() + "|";

        var secretKeySpec = new SecretKeySpec(configuration.getSecret().getBytes(), configuration.getAlgorithm());
        var mac = Mac.getInstance(configuration.getAlgorithm());

        mac.init(secretKeySpec);
        return HexFormat.of().formatHex(mac.doFinal(shortTokenInfo.getBytes()));
    }
}
