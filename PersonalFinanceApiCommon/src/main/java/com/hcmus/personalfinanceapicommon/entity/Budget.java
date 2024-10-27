package com.hcmus.personalfinanceapicommon.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends IdBasedEntity {

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private double amount;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private double spendAmount;

    @Column(name = "start_date", nullable = false)
    @NotNull
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull
    private Date endDate;

    @Column(length = 255)
    @Size(max = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;
}
