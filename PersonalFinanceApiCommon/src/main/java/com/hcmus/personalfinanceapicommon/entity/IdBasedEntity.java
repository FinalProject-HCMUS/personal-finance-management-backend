package com.hcmus.personalfinanceapicommon.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The base class for entities with an ID field.
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdBasedEntity {

    /** The unique identifier for the entity. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}