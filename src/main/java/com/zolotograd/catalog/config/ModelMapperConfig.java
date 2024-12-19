package com.zolotograd.catalog.config;

import com.zolotograd.catalog.dto.product.ProductCreateDto;
import com.zolotograd.catalog.dto.product.ProductResponseDto;
import com.zolotograd.catalog.dto.property.PropertyDto;
import com.zolotograd.catalog.dto.property.ValueDto;
import com.zolotograd.catalog.entity.Product;
import com.zolotograd.catalog.entity.Property;
import com.zolotograd.catalog.entity.PropertyValue;
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

    modelMapper.createTypeMap(Product.class, ProductResponseDto.class)
            .addMappings(mapper-> mapper.map(Product::getIdOuter, ProductResponseDto::setId));

    modelMapper.createTypeMap(ProductCreateDto.class, Product.class)
            .addMappings(mapper-> mapper.map(ProductCreateDto::getId, Product::setIdOuter))
            .addMappings(mapper -> mapper.skip(Product::setId));

    modelMapper.createTypeMap(PropertyDto.class, Property.class)
            .addMappings(mapper-> mapper.map(PropertyDto::getId, Property::setIdOuter))
            .addMappings(mapper -> mapper.skip(Property::setId));

    modelMapper.createTypeMap(ValueDto.class, PropertyValue.class)
            .addMappings(mapper-> mapper.map(ValueDto::getId, PropertyValue::setIdOuter))
            .addMappings(mapper -> mapper.skip(PropertyValue::setId));

    return modelMapper;
  }

}
