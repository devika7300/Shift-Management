package com.syr.zen.shift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syr.zen.shift_service.repositories.entities.ShiftEntity;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Integer> {

	
}
