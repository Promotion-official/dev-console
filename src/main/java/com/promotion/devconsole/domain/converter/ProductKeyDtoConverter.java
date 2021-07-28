package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.domain.dto.ProductDto;
import com.promotion.devconsole.domain.dto.ProductKeyDto;
import com.promotion.devconsole.domain.entity.AuthorizeKey;
import com.promotion.devconsole.domain.entity.Product;
import com.promotion.devconsole.domain.entity.ProductKey;
import com.promotion.devconsole.repository.AuthorizeKeyRepository;
import com.promotion.devconsole.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductKeyDtoConverter implements DtoConverter<ProductKey, ProductKeyDto>{
    private ProductRepository productRepository;
    private AuthorizeKeyRepository authorizeKeyRepository;

    private ProductDtoConverter productDtoConverter;
    private AuthorizeKeyDtoConverter authorizeKeyDtoConverter;

    @Override
    public ProductKey convertToEntity(ProductKeyDto dto) {
        return ProductKey.builder()
                .product(dto.getProduct().getId())
                .authorizeKey(dto.getAuthorizeKey().getAuthorizeKey())
                .build();
    }

    @Override
    public ProductKeyDto convertToDto(ProductKey entity) {
        Product product = productRepository.getById(entity.getProduct());
        ProductDto productDto = productDtoConverter.convertToDto(product);

        AuthorizeKey authorizeKey = authorizeKeyRepository.getById(entity.getAuthorizeKey());
        AuthorizeKeyDto authorizeKeyDto = authorizeKeyDtoConverter.convertToDto(authorizeKey);
        return new ProductKeyDto(productDto, authorizeKeyDto);
    }
}
