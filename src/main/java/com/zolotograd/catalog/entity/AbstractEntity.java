package com.zolotograd.catalog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Getter
  @Setter
  private UUID id;

  @Getter
  @Setter
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Getter
  @Setter
  @UpdateTimestamp
  private LocalDateTime lastModifiedDate;

}