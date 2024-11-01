package com.hcmus.personalfinanceapiservice.category.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for the response after creating or updating a category.
 *
 * @author <a href="mailto:21120439@student.hcmus">Bùi Minh Duy</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDTO {

    /** The unique identifier of the category. */
    @JsonProperty("id")
    private Long id;

    /** The name of the category. */
    @JsonProperty("name")
    private String name;

    /** The URL of the image associated with the category. */
    @JsonProperty("imageUrl")
    private String imageUrl;
}
