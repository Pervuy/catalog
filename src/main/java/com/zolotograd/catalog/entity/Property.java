package com.zolotograd.catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Objects;

@Entity
@Table(name = "properties",uniqueConstraints = @UniqueConstraint(columnNames = "id_outer"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property extends AbstractEntity{
  private String nameProperty;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Property property = (Property) obj;
    return Objects.equals(this.getIdOuter(), property.getIdOuter());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getIdOuter());
  }
}
