package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.AchievementType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievement extends IdBasedEntity {
    @Column(nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(length = 255)
    @Size(max = 255)
    private String description;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private double threshold;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private AchievementType achievementType;
}
