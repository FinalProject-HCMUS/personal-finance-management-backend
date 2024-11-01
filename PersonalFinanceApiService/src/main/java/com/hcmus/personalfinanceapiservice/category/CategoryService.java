package com.hcmus.personalfinanceapiservice.category;

import com.hcmus.personalfinanceapicommon.entity.Category;
import com.hcmus.personalfinanceapiservice.category.DTO.CategoryRequestDTO;
import com.hcmus.personalfinanceapiservice.category.DTO.CategoryResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing categories.
 *
 * @author <a href="mailto:21120439@student.hcmus">Bùi Minh Duy</a>
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Adds a new category.
     *
     *
     * @param categoryRequestDTO the DTO containing category details
     * @return the response DTO with the saved category details
     */
    public CategoryResponseDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setCategoryName(categoryRequestDTO.getCategoryName());
        category.setImage(categoryRequestDTO.getImage());
        category.setTransactionType(categoryRequestDTO.getTransactionType());
        Category savedCategory = categoryRepository.save(category);
        return mapToResponseDTO(savedCategory);
    }

    /**
     * Updates an existing category.
     *
     * @param id the UUID of the category to update
     * @param categoryRequestDTO the DTO containing updated category details
     * @return the response DTO with the updated category details, or null if the category is not found
     */
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(categoryRequestDTO.getCategoryName());
            category.setImage(categoryRequestDTO.getImage());
            category.setTransactionType(categoryRequestDTO.getTransactionType());
            Category updatedCategory = categoryRepository.save(category);
            return mapToResponseDTO(updatedCategory);
        } else {
            return null;
        }
    }

    /**
     * Deletes a category.
     *
     * @param id the UUID of the category to delete
     * @return true if the category was deleted, false otherwise
     */
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Maps a Category entity to a CategoryResponseDTO.
     *
     * @param category the category entity
     * @return the response DTO with category details
     */
    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setId(category.getId());
        responseDTO.setName(category.getCategoryName());
        responseDTO.setImageUrl(category.getImage());
        return responseDTO;
    }
}