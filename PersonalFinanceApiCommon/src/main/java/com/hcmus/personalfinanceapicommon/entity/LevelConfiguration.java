package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.entity.rewards.Badge;
import com.hcmus.personalfinanceapicommon.entity.rewards.Title;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @OneToOne
    @JoinColumn(name = "title_id")
    private Title title;

}
