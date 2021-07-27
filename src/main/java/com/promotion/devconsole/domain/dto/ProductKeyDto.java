package com.promotion.devconsole.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class ProductKeyDto {
    private ProductDto product;
    private AuthorizeKeyDto authorizeKey;
}
