package com.base.repository;

import com.base.dto.HelloDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing the database.
 */
@Repository
public interface MyDatabaseRepository extends JpaRepository<HelloDto, Long> {
}
