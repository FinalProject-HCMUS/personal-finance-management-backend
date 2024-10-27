package com.hcmus.personalfinanceapicommon.entity.rewards;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Badge extends  Reward {
    private String name;
    private String description;
    private String image;
}
