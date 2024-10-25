package org.gallery.backend.controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.gallery.backend.dto.MemberDTO;
import org.gallery.backend.jwt.JwtService;
import org.gallery.backend.jwt.JwtServiceImpl;
import org.gallery.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    private final JwtService jwtService;

    @PostMapping("/api/account/login")
    public ResponseEntity login(@RequestBody Map<String, String> params,
                                        HttpServletResponse response) {
        MemberDTO memberDTO = memberService.findByEmailAndPassword(params.get("email"), params.get("password"));
        if(memberDTO!=null) {
            // Jwt로 토근 만들기
            Long id = memberDTO.getId();
            String token = jwtService.getToken("id", id);

            // 만든 토큰 쿠키에 넣기
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true); // 자바스크립트 접근 금지
            cookie.setPath("/");

            response.addCookie(cookie);

            return ResponseEntity.ok().
                    body(memberDTO.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/account/check")
    public ResponseEntity check(@CookieValue( value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        if(claims!=null) {
            int id = Integer.parseInt(claims.get("id").toString());
            return ResponseEntity.ok()
                    .body(id);
        }

        return ResponseEntity.ok()
                .body(null);
    }
}
