package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.XPType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "xp_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XPUser extends IdBasedEntity {
    private int XP;
    private Date date;

    @Enumerated(EnumType.STRING)
    private XPType xpType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
}
