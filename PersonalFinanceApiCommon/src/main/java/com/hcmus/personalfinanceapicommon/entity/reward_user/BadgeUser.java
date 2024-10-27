package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "badge_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadgeUser extends IdBasedEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isDefault;
    private Date date;
}
