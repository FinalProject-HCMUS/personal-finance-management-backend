package com.hcmus.personalfinanceapicommon.entity.rewards;

import com.hcmus.personalfinanceapicommon.entity.Achievement;
import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The abstract base class for all reward entities.
 */
@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Reward extends IdBasedEntity {

   /** The achievement associated with this reward. */
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "achievement_id", nullable = false)
   protected Achievement achievement;
}