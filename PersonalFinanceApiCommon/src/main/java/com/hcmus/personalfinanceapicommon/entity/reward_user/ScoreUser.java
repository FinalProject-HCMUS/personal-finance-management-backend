package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Score;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the ScoreUser database table.
 */
@Entity
@Table(name = "score_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreUser extends IdBasedEntity {

    /** The score. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "score_id")
    private Score score;

    /** The user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** The date when the score was assigned to the user. */
    @Column(name = "date")
    private Date date;
}