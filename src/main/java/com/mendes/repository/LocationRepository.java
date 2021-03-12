package com.mendes.repository;

import com.mendes.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mendesmustafa on 12.03.2021.
 */

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
