package com.aws.gallery.controller;

import com.aws.gallery.dto.RequestUserDTO;
import com.aws.gallery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final UserService userService;

    @PostMapping("/api/account/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> params
    ) {
        System.out.println(params.get("password"));
        RequestUserDTO userDTO = userService.findByEmailAndPassword(params.get("email"), params.get("password"));

        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("이메일 또는 비밀번호가 올바르지 않습니다");
        }

        return ResponseEntity.ok()
                .body("로그인 되었습니다.");
    }
}
