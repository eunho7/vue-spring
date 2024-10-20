package org.gallery.backend.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.gallery.backend.dto.MemberDTO;
import org.gallery.backend.entity.Member;
import org.gallery.backend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO findByEmailAndPassword(String email, String password){
        Optional<Member> byEmailAndPassword = memberRepository.findByEmailAndPassword(email, password);
        if(byEmailAndPassword.isPresent()){
            MemberDTO memberDTO = MemberDTO.toMemberDTO(byEmailAndPassword.get());
            return memberDTO;
        } else {
            return null;
        }
    }
}
