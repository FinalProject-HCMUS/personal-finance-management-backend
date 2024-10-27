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

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String password;

    @Column()
    private String phone;

    @Column()
    private Date dob;

    @Column()
    private String avatar;

    @Column(name = "total_score")
    private Long totalScore;

    @Column(name = "total_XP")
    private Long totalXP;

    private int level;
}
