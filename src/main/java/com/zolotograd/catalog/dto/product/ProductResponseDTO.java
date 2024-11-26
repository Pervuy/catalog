package com.zolotograd.catalog.dto.product;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductResponseDTO {

  private String article;
  private UUID id;
}
