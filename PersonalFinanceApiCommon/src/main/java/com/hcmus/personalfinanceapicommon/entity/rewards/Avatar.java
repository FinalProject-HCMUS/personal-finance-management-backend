package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarFrameUser;
import com.hcmus.personalfinanceapicommon.entity.reward_user.AvatarUser;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avatar extends Reward{
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "avatar")
    private List<AvatarUser> avatarUsers;
}
