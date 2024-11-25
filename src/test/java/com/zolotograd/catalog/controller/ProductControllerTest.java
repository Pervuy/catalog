package com.zolotograd.catalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zolotograd.catalog.dto.product.ProductCreateDTO;
import com.zolotograd.catalog.dto.product.ProductResponseDTO;
import com.zolotograd.catalog.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ProductService productService;

  private ProductResponseDTO productResponseDTO1;
  private ProductCreateDTO productCreateDTO1;

  @BeforeEach
  public void setUp() {
    productResponseDTO1 = ProductResponseDTO
            .builder()
            .article("110333")
            .build();

    productCreateDTO1 = ProductCreateDTO.builder()
            .article("110333")
            .build();
  }

  @Test
  public void testCreateProduct() throws Exception {


    Mockito.when(productService.createProduct(any(ProductCreateDTO.class))).thenReturn(productResponseDTO1);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .post("/api/v1/products/create")
                    .content(objectMapper.writeValueAsString(productCreateDTO1))
                    .contentType(MediaType.APPLICATION_JSON))

            .andExpect(status().isOk())
            .andReturn();

    String responseJson = mvcResult.getResponse().getContentAsString();
    ProductResponseDTO productResponseDTO = objectMapper.readValue(responseJson, ProductResponseDTO.class);

    assertEquals("110333", productResponseDTO.getArticle());

  }
}
