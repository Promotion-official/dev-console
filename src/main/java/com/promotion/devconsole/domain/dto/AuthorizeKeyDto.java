package com.promotion.devconsole.domain.dto;

import com.promotion.devconsole.domain.Permission;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class AuthorizeKeyDto {
    private String authorizeKey;
    private ApiDto api;
    private Permission permission;
}
