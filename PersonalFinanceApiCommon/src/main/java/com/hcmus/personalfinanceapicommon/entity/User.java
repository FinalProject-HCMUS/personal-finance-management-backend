package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarFrameUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.BadgeUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.TitleUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the User database table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends IdBasedEntity implements UserDetails {

    /** The name of the user. */
    private String name;

    /** The email of the user. */
    private String email;

    /** The password of the user. */
    private String password;

    /** The phone number of the user. */
    private String phone;

    /** The date of birth of the user. */
    private Date dob;

    /** The avatar of the user. */
    private String avatar;

    /** The total score of the user. */
    @Column(name = "total_score")
    private Long totalScore;

    /** The total experience points (XP) of the user. */
    @Column(name = "total_XP")
    private Long totalXP;

    /** The level of the user. */
    private int level;

    /** The list of XPUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<XPUser> xpUsers;

    /** The list of AchievementUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<AchievementUser> achievementUsers;

    /** The list of AvatarUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<AvatarUser> avatarUsers;

    /** The list of Transaction entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    /** The list of AvatarFrameUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<AvatarFrameUser> avatarFrameUsers;

    /** The list of BadgeUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<BadgeUser> badgeUsers;

    /** The list of TitleUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<TitleUser> titleUsers;

    /** The list of NotificationUser entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<NotificationUser> notificationUser;

    /** The list of Budget entities associated with the user. */
    @OneToMany(mappedBy = "user")
    private List<Budget> budget;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }
}