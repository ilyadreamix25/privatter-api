package com.privatter.api.user;

import com.privatter.api.user.dto.communication.UserSignUpRequestDto;
import com.privatter.api.user.etc.UserSignUpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    public UserRepository repository;

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    @Value("${privatter.auth.methods}")
    private String[] authMethods;

    public UserSignUpResult createUser(UserSignUpRequestDto body, String method) {
        if (!Arrays.stream(authMethods).toList().contains(method))
            return UserSignUpResult.INVALID_METHOD;

        // TODO: Лень пока что
    }
}
