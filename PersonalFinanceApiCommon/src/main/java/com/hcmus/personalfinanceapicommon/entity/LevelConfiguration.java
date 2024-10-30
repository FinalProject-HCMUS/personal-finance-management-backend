package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import com.hcmus.personalfinanceapicommon.entity.rewards.Title;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "level_configuration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelConfiguration extends  IdBasedEntity{
    private int level;
    private long XPThreshold;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    private Title title;

}
