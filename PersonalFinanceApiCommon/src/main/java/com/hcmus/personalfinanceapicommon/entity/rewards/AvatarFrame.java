package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarFrameUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the AvatarFrame database table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvatarFrame extends Reward {

    /** The name of the avatar frame. */
    private String name;

    /** The description of the avatar frame. */
    private String description;

    /** The image URL or path of the avatar frame. */
    private String image;

    /** The list of AvatarFrameUser entities associated with this avatar frame. */
    @OneToMany(mappedBy = "avatarFrame", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvatarFrameUser> avatarFrameUsers;
}