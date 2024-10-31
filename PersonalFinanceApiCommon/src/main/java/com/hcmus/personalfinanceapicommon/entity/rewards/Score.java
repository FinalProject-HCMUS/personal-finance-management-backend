package com.hcmus.personalfinanceapicommon.entity.rewards;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the Score database table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Score extends Reward {

    /** The points associated with the score. */
    private double point;
}