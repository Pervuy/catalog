package com.zolotograd.catalog.config;

import com.zolotograd.catalog.dto.product.ProductCreateDTO;
import com.zolotograd.catalog.dto.product.ProductResponseDTO;
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

    modelMapper.createTypeMap(Product.class, ProductResponseDTO.class);
    modelMapper.createTypeMap(ProductCreateDTO.class, Product.class);

    return modelMapper;
  }

}
