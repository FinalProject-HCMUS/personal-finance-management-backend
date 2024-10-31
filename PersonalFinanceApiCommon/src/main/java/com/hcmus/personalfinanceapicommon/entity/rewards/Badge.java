package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.reward_user.BadgeUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the Badge database table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Badge extends Reward {

    /** The name of the badge. */
    private String name;

    /** The description of the badge. */
    private String description;

    /** The image URL or path of the badge. */
    private String image;

    /** The list of BadgeUser entities associated with this badge. */
    @OneToMany(mappedBy = "badge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BadgeUser> badgeUsers;
}