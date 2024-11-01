package com.aws.gallery.service;

import com.aws.gallery.dto.RequestUserDTO;
import com.aws.gallery.entity.User;
import com.aws.gallery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public RequestUserDTO findByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if(user.isPresent()) {
            return RequestUserDTO.toUserDTO(user.get());
        }else{
            return null;
        }
    }
}
