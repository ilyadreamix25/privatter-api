package com.privatter.api.verification.token;

import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TokenRepository extends JpaRepository<TokenEntity, String> {
    @Nullable
    @Query(value = "SELECT * FROM tokens x WHERE x.user_id = ?1", nativeQuery = true)
    List<TokenEntity> findByUserId(String userId);

    @Nullable
    @Query(value = "SELECT * FROM tokens x WHERE x.id = ?1", nativeQuery = true)
    TokenEntity findByTokenId(String tokenId);

    @Nullable
    @Query(value = "SELECT * FROM tokens x WHERE x.user_id = ?1 AND x.action = ?2", nativeQuery = true)
    TokenEntity findByUserIdAndAction(String userId, String action);

    @Modifying
    @Query(
        value = "UPDATE tokens x SET x.activated = ?3 WHERE x.user_id = ?1 AND x.action = ?2",
        nativeQuery = true
    )
    void updateActivatedByUserIdAndAction(String userId, String action, boolean activated);

    @Query(
        value = "UPDATE tokens x SET x.activated = ?2 WHERE x.id = ?1",
        nativeQuery = true
    )
    @Modifying
    void updateActivatedByTokenId(String tokenId, boolean activated);
}
