package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.NotificationType;
import com.hcmus.personalfinanceapicommon.enums.ReactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

/**
 * The persistent class for the Notification database table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification extends IdBasedEntity {

    /** The message content of the notification. */
    private String message;

    /** The type of the notification. */
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type")
    private NotificationType notificationType;

    /** The reaction type associated with the notification. */
    @Enumerated(EnumType.STRING)
    @Column(name = "reaction_type")
    private ReactionType reactionType;
}
