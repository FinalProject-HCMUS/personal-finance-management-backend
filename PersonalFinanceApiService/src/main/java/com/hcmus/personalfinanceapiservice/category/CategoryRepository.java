package com.hcmus.personalfinanceapiservice.category;

import com.hcmus.personalfinanceapicommon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Category entities.
 *
 * This interface extends JpaRepository, providing CRUD operations for Category entities.
 * The JpaRepository interface includes methods for saving, deleting, and finding Category entities.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
