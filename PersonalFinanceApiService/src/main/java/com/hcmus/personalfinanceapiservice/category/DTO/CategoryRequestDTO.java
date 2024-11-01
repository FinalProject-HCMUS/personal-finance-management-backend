package com.hcmus.personalfinanceapiservice.category.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcmus.personalfinanceapicommon.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Data Transfer Object (DTO) for creating or updating a category.
 *
 * @author <a href="mailto:21120439@student.hcmus">Bùi Minh Duy</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDTO {

    /** The name of the category. */
    @NotBlank(message = "Category name is required")
    @JsonProperty("categoryName")
    private String categoryName;

    /** The image associated with the category, specified as an image name or URL. */
    @NotBlank(message = "Image is required")
    @JsonProperty("image")
    private String image;

    /** The type of transaction associated with the category (INCOME or EXPENSE). */
    @NotNull(message = "Transaction type is required")
    @JsonProperty("transactionType")
    private TransactionType transactionType;
}