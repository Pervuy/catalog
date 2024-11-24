package com.zolotograd.catalog.service;

import com.zolotograd.catalog.dto.product.ProductCreateDTO;
import com.zolotograd.catalog.dto.product.ProductResponseDTO;
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

  public List<ProductResponseDTO> getAllPosts(Integer page, Integer size) {

    Pageable pageRequest = getPageRequest(page, size);

    return productRepository.findAll(pageRequest)
            .stream()
            .map(product -> mapper.map(product, ProductResponseDTO.class))
            .toList();
  }

  public ProductResponseDTO createProduct(ProductCreateDTO productCreateDTO) {

    Product product = productRepository.save(mapper.map(productCreateDTO, Product.class));

    return mapper.map(product, ProductResponseDTO.class);

  }

  private PageRequest getPageRequest(Integer page, Integer size) {
    return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));
  }
}
