package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import com.hcmus.personalfinanceapicommon.entity.rewards.Title;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the LevelConfiguration database table.
 */
@Entity
@Table(name = "level_configuration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelConfiguration extends IdBasedEntity {

    /** The level number. */
    private int level;

    /** The XP threshold required to reach this level. */
    @Column(name = "xp_threshold")
    private long XPThreshold;

    /** The badge associated with this level. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id")
    private Badge badge;

    /** The title associated with this level. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    private Title title;
}