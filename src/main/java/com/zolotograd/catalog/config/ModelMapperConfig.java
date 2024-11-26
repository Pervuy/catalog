package com.zolotograd.catalog.config;

import com.zolotograd.catalog.dto.product.ProductCreateDto;
import com.zolotograd.catalog.dto.product.ProductResponseDto;
import com.zolotograd.catalog.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    modelMapper.createTypeMap(Product.class, ProductResponseDto.class);
    modelMapper.createTypeMap(ProductCreateDto.class, Product.class);

    return modelMapper;
  }

}
