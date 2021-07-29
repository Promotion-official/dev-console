package com.promotion.devconsole.domain.converter;

public interface DtoConverter<E, D> {
    E toEntity(D dto);
    D toDto(E entity);
}
