package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "notification_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationUser extends IdBasedEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    private Date date;
}
