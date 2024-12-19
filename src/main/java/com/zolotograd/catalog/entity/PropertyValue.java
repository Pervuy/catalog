package com.zolotograd.catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.Objects;

@Entity
@Table(name = "property_values")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue extends AbstractEntity{

  @ManyToOne
  @JoinColumn(name = "property_id", nullable = false)
  private Property property;
  private String value;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    PropertyValue propertyValue = (PropertyValue) obj;
    return Objects.equals(this.getIdOuter(), propertyValue.getIdOuter());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getIdOuter());
  }

}
