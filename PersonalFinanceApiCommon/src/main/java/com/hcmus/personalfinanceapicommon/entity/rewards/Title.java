package com.hcmus.personalfinanceapicommon.entity.rewards;

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
public class Title extends Reward {
    private String title;
    private String description;
}
