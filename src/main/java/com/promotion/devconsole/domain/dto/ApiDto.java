package com.promotion.devconsole.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class ApiDto {
    private String name;
    private String url;
}
