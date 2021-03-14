package com.mendes.repository;

import com.mendes.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mendesmustafa on 13.03.2021.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
