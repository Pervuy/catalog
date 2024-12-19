package com.zolotograd.catalog.repository;

import com.zolotograd.catalog.entity.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ValueRepository extends JpaRepository<PropertyValue, UUID> {

  Optional<PropertyValue> findByIdOuter(UUID id);


}
