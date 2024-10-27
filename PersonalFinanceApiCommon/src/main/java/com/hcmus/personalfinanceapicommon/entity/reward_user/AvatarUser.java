package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Avatar;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "avatar_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarUser extends IdBasedEntity {
    @ManyToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isDefault;
    private Date date;
}
