package com.privatter.api.user;

import com.privatter.api.user.dto.communication.UserSignUpRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("sign-up")
    public void signUp(@Valid @RequestBody UserSignUpRequestDto body, @Param("method") String method) {}
}
