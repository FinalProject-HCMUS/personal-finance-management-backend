package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends IdBasedEntity {

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Column(length = 15)
    @Size(max = 15)
    private String phone;

    @Column(nullable = false)
    @NotNull
    private Date dob;

    @Column(length = 255)
    @Size(max = 255)
    private String avatar;

    @Column(name = "total_score", nullable = false)
    @NotNull
    private Long totalScore;

    @Column(name = "total_XP", nullable = false)
    @NotNull
    private Long totalXP;

    private int level;
}
