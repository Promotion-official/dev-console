package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.PendingProductDto;
import com.promotion.devconsole.entity.PendingProduct;

public class PendingProductDtoConverter implements DtoConverter<PendingProduct, PendingProductDto> {
    @Override
    public PendingProduct convertToEntity(PendingProductDto dto) {
        return PendingProduct.builder()
                .id(dto.getId())
                .isPendSuccess(dto.getIsPendSuccess())
                .pendingDate(dto.getPendingDate())
                .build();
    }

    @Override
    public PendingProductDto convertToDto(PendingProduct entity) {
        return new PendingProductDto(
                entity.getId(),
                entity.getIsPendSuccess(),
                entity.getPendingDate()
        );
    }
}
