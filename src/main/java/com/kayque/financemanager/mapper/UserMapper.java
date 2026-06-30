package com.kayque.financemanager.mapper;

import com.kayque.financemanager.dto.CreateUserRequest;
import com.kayque.financemanager.dto.UserResponse;
import com.kayque.financemanager.entity.User;
import com.kayque.financemanager.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request, String encodedPassword) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(encodedPassword)
                .role(UserRole.USER)
                .build();
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}