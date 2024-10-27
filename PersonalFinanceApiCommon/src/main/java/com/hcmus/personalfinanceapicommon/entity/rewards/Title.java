package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.reward_user.TitleUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class Title extends Reward {
    private String title;
    private String description;

    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TitleUser> titleUsers;
}
