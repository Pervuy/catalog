package com.zolotograd.catalog.controller;

import com.zolotograd.catalog.dto.product.ProductCreateDto;
import com.zolotograd.catalog.dto.product.ProductResponseDto;
import com.zolotograd.catalog.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products/")
public class ProductController {

  private final ProductService productService;

  @GetMapping("all")
  public ResponseEntity<List<ProductResponseDto>> getAllPosts(
          @RequestParam(value = "page", defaultValue = "0") Integer page,
          @RequestParam(value = "size", defaultValue = "10") Integer size) {

    List<ProductResponseDto> allPosts = productService.getAllPosts(page, size);

    return ResponseEntity.ok(allPosts);
  }

  @PostMapping("create")
  public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {

    ProductResponseDto product = productService.createProduct(productCreateDto);

    return ResponseEntity.ok(product);
  }
}
