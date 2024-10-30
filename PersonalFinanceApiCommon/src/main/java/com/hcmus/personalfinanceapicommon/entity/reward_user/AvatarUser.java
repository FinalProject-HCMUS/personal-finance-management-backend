package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Avatar;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the AvatarUser database table.
 */
@Entity
@Table(name = "avatar_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarUser extends IdBasedEntity {
    /** The avatar. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    /** The user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** Indicates if this avatar is the default for the user. */
    @Column(name = "is_default")
    private boolean isDefault;

    /** The date when the avatar was assigned to the user. */
    @Column(name = "date")
    private Date date;
}