package com.hcmus.personalfinanceapiservice.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {
    @NotBlank(message = "Name is required")
    @JsonProperty("name")
    private String name;
    @NotBlank(message = "Phone is required")
    private String phone;
    @JsonProperty("dob")
    private String dateOfBirth;
    @JsonProperty("avatar")
    private String avatar;

}
