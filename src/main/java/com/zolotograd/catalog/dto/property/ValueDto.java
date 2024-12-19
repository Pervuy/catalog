package com.zolotograd.catalog.dto.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValueDto {
  private UUID id;
  private String value;
  private PropertyDto property;

}
