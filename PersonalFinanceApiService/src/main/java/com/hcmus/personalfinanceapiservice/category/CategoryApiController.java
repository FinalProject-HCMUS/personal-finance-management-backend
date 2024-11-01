package com.hcmus.personalfinanceapiservice.category;

import com.hcmus.personalfinanceapiservice.category.DTO.CategoryRequestDTO;
import com.hcmus.personalfinanceapiservice.category.DTO.CategoryResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing categories.
 *
 * @author <a href="mailto:21120439@student.hcmus">Bùi Minh Duy</a>
 */
@RestController
@RequestMapping("/categories")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Adds a new category.
     *
     * @param categoryRequestDTO the DTO containing category details
     * @param result the binding result for validation
     * @return the response entity with the saved category details
     */
    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        try {
            CategoryResponseDTO responseDTO = categoryService.addCategory(categoryRequestDTO);
            return ResponseEntity.status(201).body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Updates an existing category.
     *
     * @param id the UUID of the category to update
     * @param categoryRequestDTO the DTO containing updated category details
     * @param result the binding result for validation
     * @return the response entity with the updated category details, or not found status if the category is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO categoryRequestDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        CategoryResponseDTO responseDTO = categoryService.updateCategory(id, categoryRequestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    /**
     * Deletes a category.
     *
     * @param id the UUID of the category to delete
     * @return the response entity with no content status if the category was deleted, or not found status if the category is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}