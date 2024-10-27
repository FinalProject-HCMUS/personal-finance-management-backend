package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "achievement_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AchievementUser extends IdBasedEntity{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Date date;
}
