package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the NotificationUser database table.
 */
@Entity
@Table(name = "notification_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationUser extends IdBasedEntity {

    /** The notification associated with the user. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id")
    private Notification notification;

    /** The user associated with the notification. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /** The date when the notification was sent to the user. */
    private Date date;
}