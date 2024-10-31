package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the Budget database table.
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends IdBasedEntity {

    /** The total amount allocated for the budget. */
    @Column()
    private double amount;

    /** The amount already spent from the budget. */
    @Column(name = "spend_amount")
    private double spendAmount;

    /** The start date of the budget period. */
    @Column(name = "start_date")
    private Date startDate;

    /** The end date of the budget period. */
    @Column(name = "end_date")
    private Date endDate;

    /** The description of the budget. */
    @Column()
    private String description;

    /** The category associated with the budget. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /** The user associated with the budget. */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}