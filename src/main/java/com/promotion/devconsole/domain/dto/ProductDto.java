package com.promotion.devconsole.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private DeveloperDto developer;
}
