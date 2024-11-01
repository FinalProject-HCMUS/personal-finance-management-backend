package com.hcmus.personalfinanceapiservice.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcmus.personalfinanceapicommon.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("imageUrl")
    private String avatar;
    public static  UserResponseDTO fromUser(User user)
    {
        return UserResponseDTO.builder().name(user.getName())
                .userId(user.getId())
                .avatar(user.getAvatar())
                .build();
    }
}
