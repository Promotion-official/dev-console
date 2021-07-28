package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.DeveloperDto;
import com.promotion.devconsole.domain.dto.ProductDto;
import com.promotion.devconsole.domain.entity.Developer;
import com.promotion.devconsole.domain.entity.Product;
import com.promotion.devconsole.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductDtoConverter implements DtoConverter<Product, ProductDto> {
    private final DeveloperRepository developerRepository;
    private final DeveloperDtoConverter developerDtoConverter;

    @Override
    public Product convertToEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .developer(dto.getDeveloper().getId())
                .build();
    }

    @Override
    public ProductDto convertToDto(Product entity) {
        String developerId = entity.getDeveloper();
        Developer developer = developerRepository.getById(developerId);
        DeveloperDto developerDto = developerDtoConverter.convertToDto(developer);
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                developerDto
        );
    }
}
