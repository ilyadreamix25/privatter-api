package com.privatter.api.user;

import com.privatter.api.user.model.UserSignUpBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("sign-up")
    public void signUp(@Valid @RequestBody UserSignUpBody body, @Param("method") String method) {
        var user = service.repository.findById("UUID");
    }
}
