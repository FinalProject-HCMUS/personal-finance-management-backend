package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the BadgeUser database table.
 */
@Entity
@Table(name = "badge_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadgeUser extends IdBasedEntity {

    /** The badge. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id")
    private Badge badge;

    /** The user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** Indicates if this badge is the default for the user. */
    @Column(name = "is_default")
    private boolean isDefault;

    /** The date when the badge was assigned to the user. */
    @Column(name = "date")
    private Date date;
}