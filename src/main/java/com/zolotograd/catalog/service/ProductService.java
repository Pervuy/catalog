package com.zolotograd.catalog.service;

import com.zolotograd.catalog.dto.product.ProductCreateDto;
import com.zolotograd.catalog.dto.product.ProductResponseDto;
import com.zolotograd.catalog.entity.Product;
import com.zolotograd.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ModelMapper mapper;
  private final ProductRepository productRepository;

  public List<ProductResponseDto> getAllPosts(Integer page, Integer size) {

    Pageable pageRequest = getPageRequest(page, size);

    return productRepository.findAll(pageRequest)
            .stream()
            .map(product -> mapper.map(product, ProductResponseDto.class))
            .toList();
  }

  public ProductResponseDto createProduct(ProductCreateDto productCreateDto) {

    Product product = productRepository.save(mapper.map(productCreateDto, Product.class));

    return mapper.map(product, ProductResponseDto.class);

  }

  private PageRequest getPageRequest(Integer page, Integer size) {
    return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));
  }
}
