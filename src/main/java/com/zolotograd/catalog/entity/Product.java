package com.zolotograd.catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products",
        uniqueConstraints = @UniqueConstraint(columnNames = "article"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity{
  private String article;
}
