package com.aws.gallery.dto;

import com.aws.gallery.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUserDTO {
    private String email;
    private String password;

    @Builder
    public RequestUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static RequestUserDTO toUserDTO(User user) {
        return RequestUserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
