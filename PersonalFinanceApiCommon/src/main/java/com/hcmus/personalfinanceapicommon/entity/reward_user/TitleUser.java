package com.hcmus.personalfinanceapicommon.entity.reward_user;

import com.hcmus.personalfinanceapicommon.entity.IdBasedEntity;
import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapicommon.entity.rewards.Title;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the TitleUser database table.
 */
@Entity
@Table(name = "title_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TitleUser extends IdBasedEntity {

    /** The title. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    private Title title;

    /** The user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** Indicates if this title is the default for the user. */
    @Column(name = "is_default")
    private boolean isDefault;

    /** The date when the title was assigned to the user. */
    @Column(name = "date")
    private Date date;
}