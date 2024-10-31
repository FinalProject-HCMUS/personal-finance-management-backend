package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.AchievementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the Achievement database table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievement extends IdBasedEntity {

    /** The name of the achievement. */
    private String name;

    /** The description of the achievement. */
    private String description;

    /** The threshold value for the achievement. */
    private double threshold;

    /** The type of the achievement. */
    @Enumerated(EnumType.STRING)
    @Column(name = "achievement_type")
    private AchievementType achievementType;

    /** The list of AchievementUser entities associated with this achievement. */
    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AchievementUser> achievementUser;
}