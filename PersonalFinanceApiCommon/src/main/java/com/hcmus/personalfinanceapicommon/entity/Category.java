package com.hcmus.personalfinanceapicommon.entity;

import com.hcmus.personalfinanceapicommon.enums.TransactionType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

/**
 * The persistent class for the Category database table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends IdBasedEntity {

    /** The name of the category. */
    @Column(name = "category_name")
    private String categoryName;

    /** The image associated with the category. */
    private String image;

    /** The type of transaction associated with the category. */
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    /** The list of transactions associated with the category. */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}