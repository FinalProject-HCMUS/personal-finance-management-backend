package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarFrameUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.BadgeUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.TitleUser;
import com.hcmus.personalfinanceapicommon.entity.rewards.AvatarFrame;
import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends IdBasedEntity {

    private String name;

    private String email;

    private String password;

    private String phone;

    private Date dob;

    private String avatar;

    @Column(name = "total_score")
    private Long totalScore;

    @Column(name = "total_XP")
    private Long totalXP;

    private int level;

    @OneToMany(mappedBy = "user")
    private List<XPUser> xpUsers;

    @OneToMany(mappedBy = "user")
    private List<AchievementUser> achievementUsers;

    @OneToMany(mappedBy = "user")
    private List<AvatarUser> avatarUsers;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<AvatarFrameUser> avatarFrameUsers;

    @OneToMany(mappedBy = "user")
    private List<BadgeUser> badgeUsers;

    @OneToMany(mappedBy = "user")
    private List<TitleUser> titleUsers;

    @OneToMany(mappedBy = "user")
    private List<NotificationUser> notificationUser;

    @OneToMany(mappedBy = "user")
    private List<Budget> budget;

}
