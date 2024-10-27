package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date date;
}
