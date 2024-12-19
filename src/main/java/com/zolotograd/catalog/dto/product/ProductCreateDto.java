package com.zolotograd.catalog.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
//@Builder(toBuilder = true) // используя билдер нельзя передать значения по умолчанию description = ""; оно будет description = null;
public class ProductCreateDto {

  @NotNull
  private UUID id;
  @NotNull
  private String article;

  private int weight;

  private String description = "";

}
