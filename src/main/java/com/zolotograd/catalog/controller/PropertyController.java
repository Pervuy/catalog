package com.zolotograd.catalog.controller;

import com.zolotograd.catalog.dto.property.PropertyValueCreateDto;
import com.zolotograd.catalog.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class PropertyController {

  private final PropertyService propertyService;

  /*{"data" :[
{
    "id": "74ac3564-797a-4327-ae8a-52faf6694f58",
    "value": "testValue1",
    "property": {
        "id": "77ac3564-797a-4327-ae8a-52faf6694f58",
        "nameProperty": "test1"
    }
},
{
    "id": "75ac3564-797a-4327-ae8a-52faf6694f58",
    "value": "testValue2",
    "property": {
        "id": "77ac3564-797a-4327-ae8a-52faf6694f58",
        "nameProperty": "test1"
    }
},
{
    "id": "76ac3564-797a-4327-ae8a-52faf6694f58",
    "value": "testValue1",
    "property": {
        "id": "78ac3564-797a-4327-ae8a-52faf6694f58",
        "nameProperty": "test2"
    }
}
]
}*/
  @PostMapping("property")
  public ResponseEntity<?> createProperty(@RequestBody PropertyValueCreateDto propertyValueCreateDto) {

    propertyService.createPropertyValue(propertyValueCreateDto);

    return ResponseEntity.ok("OK");
  }
}
