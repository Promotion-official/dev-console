package com.promotion.devconsole.domain.dto;

import com.promotion.devconsole.domain.Permission;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class AuthorizeKeyDto {
    private String authorizeKey;
    private ApiDto api;
    private Permission permission;
}
