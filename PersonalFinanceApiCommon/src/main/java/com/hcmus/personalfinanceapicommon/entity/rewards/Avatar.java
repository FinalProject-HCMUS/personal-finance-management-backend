package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the Avatar database table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avatar extends Reward {

    /** The name of the avatar. */
    private String name;

    /** The description of the avatar. */
    private String description;

    /** The image URL or path of the avatar. */
    private String image;

    /** The list of AvatarUser entities associated with this avatar. */
    @OneToMany(mappedBy = "avatar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvatarUser> avatarUsers;
}