package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the AchievementUser database table.
 */
@Entity
@Table(name = "achievement_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AchievementUser extends IdBasedEntity {

    /** The achievement associated with the user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    /** The user associated with the achievement. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** The date when the achievement was assigned to the user. */
    private Date date;
}