package com.zolotograd.catalog.controller;

import com.zolotograd.catalog.dto.product.ProductCreateDTO;
import com.zolotograd.catalog.dto.product.ProductResponseDTO;
import com.zolotograd.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products/")
public class ProductController {

  private final ProductService productService;

  @GetMapping("all")
  public ResponseEntity<List<ProductResponseDTO>> getAllPosts(
          @RequestParam(value = "page", defaultValue = "0") Integer page,
          @RequestParam(value = "size", defaultValue = "10") Integer size) {

    List<ProductResponseDTO> allPosts = productService.getAllPosts(page, size);

    return ResponseEntity.ok(allPosts);
  }

  @PostMapping("create")
  public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO) {

    ProductResponseDTO product = productService.createProduct(productCreateDTO);

    return ResponseEntity.ok(product);
  }
}
