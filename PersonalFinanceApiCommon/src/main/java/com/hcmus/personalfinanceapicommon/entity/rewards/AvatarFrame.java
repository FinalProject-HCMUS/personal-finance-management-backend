package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvatarFrame extends Reward {
    private String name;
    private String description;
    private String image;
}
