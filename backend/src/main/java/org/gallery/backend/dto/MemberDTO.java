package org.gallery.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gallery.backend.entity.Member;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String email;
    private String password;

    public static MemberDTO toMemberDTO(Member member) {
        return MemberDTO.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
