package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.AvatarFrame;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "score_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarFrameUser extends IdBasedEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "avatar_frame_id")
    private AvatarFrame avatarFrame;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isDefault;
    private Date date;
}
