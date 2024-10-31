package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.AvatarFrame;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the AvatarFrameUser database table.
 */
@Entity
@Table(name = "score_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarFrameUser extends IdBasedEntity {
    /** The avatar frame. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_frame_id")
    private AvatarFrame avatarFrame;

    /** The user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** Indicates if this avatar frame is the default for the user. */
    @Column(name = "is_default")
    private boolean isDefault;

    /** The date when the avatar frame was assigned to the user. */
    @Column(name = "date")
    private Date date;
}
