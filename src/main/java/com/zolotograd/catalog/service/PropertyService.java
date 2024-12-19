package com.zolotograd.catalog.service;

import com.zolotograd.catalog.dto.property.PropertyValueCreateDto;
import com.zolotograd.catalog.dto.property.ValueDto;
import com.zolotograd.catalog.entity.Property;
import com.zolotograd.catalog.entity.PropertyValue;
import com.zolotograd.catalog.repository.PropertyRepository;
import com.zolotograd.catalog.repository.ValueRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService {

  private final ModelMapper mapper;
  private final PropertyRepository propertyRepository;
  private final ValueRepository valueRepository;

  public void createPropertyValue(PropertyValueCreateDto propertyValueCreateDto) {

    Set<Property> propertySet = propertyValueCreateDto
            .getData()
            .stream()
            .map(ValueDto::getProperty)
            .map(propertyDto -> mapper.map(propertyDto, Property.class))

            .collect(Collectors.toSet())
            .stream()
            .map(this::saveOrUpdate)
            .collect(Collectors.toSet());

    Set<PropertyValue> propertyValueSet = propertyValueCreateDto
            .getData()
            .stream()
            .map(valueDto -> mapper.map(valueDto, PropertyValue.class))
            .peek(propertyValue -> propertyValue.setProperty(findByIdOuter(propertyValue.getProperty()).get()))
            .collect(Collectors.toSet())
            .stream()
            .map(this::saveOrUpdate)
            .collect(Collectors.toSet());

  }

  private Optional<Property> findByIdOuter(Property property){
    return propertyRepository.findByIdOuter(property.getIdOuter());
  }
  private Property saveOrUpdate(Property property){
    return findByIdOuter(property)
            .orElseGet(() -> propertyRepository.save(property));
  }
  private Optional<PropertyValue> findByIdOuter(PropertyValue propertyValue){
    return valueRepository.findByIdOuter(propertyValue.getIdOuter());
  }
  private PropertyValue saveOrUpdate(PropertyValue propertyValue){
    return findByIdOuter(propertyValue)
            .orElseGet(() -> valueRepository.save(propertyValue));
  }
}
