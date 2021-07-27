package com.promotion.devconsole.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class DeveloperDto {
    private String id;
    private String pw;
    private String authToken;
    private AuthorizeKeyDto authorizeKey;
}
