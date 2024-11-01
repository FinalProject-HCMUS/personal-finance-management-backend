package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The persistent class for the Transaction database table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends IdBasedEntity {

    /** The amount of the transaction. */
    private double amount;

    /** The date of the transaction. */
    private Date date;

    /** The description of the transaction. */
    private String description;

    /** The category associated with the transaction. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /** The user associated with the transaction. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}