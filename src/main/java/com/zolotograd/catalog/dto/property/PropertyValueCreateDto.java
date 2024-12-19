package com.zolotograd.catalog.dto.property;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValueCreateDto {

  private List<ValueDto> data;

}
