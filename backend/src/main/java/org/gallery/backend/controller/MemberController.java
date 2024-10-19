package org.gallery.backend.controller;

import lombok.RequiredArgsConstructor;
import org.gallery.backend.dto.MemberDTO;
import org.gallery.backend.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/account/login")
    public ResponseEntity<Long> login(@RequestBody Map<String, String> params) {
        MemberDTO memberDTO = memberService.findByEmailAndPassword(params.get("email"), params.get("password"));
        return ResponseEntity.ok()
                .body(memberDTO.getId());
    }
}
