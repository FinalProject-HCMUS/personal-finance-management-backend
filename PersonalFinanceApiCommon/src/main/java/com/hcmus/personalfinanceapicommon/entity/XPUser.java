package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.XPType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the XPUser database table.
 */
@Entity
@Table(name = "xp_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XPUser extends IdBasedEntity {

    /** The amount of experience points (XP). */
    @Column(name = "xp")
    private int XP;

    /** The date when the XP was earned. */
    private Date date;

    /** The type of XP. */
    @Enumerated(EnumType.STRING)
    @Column(name = "xp_type")
    private XPType xpType;

    /** The user associated with the XP. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}