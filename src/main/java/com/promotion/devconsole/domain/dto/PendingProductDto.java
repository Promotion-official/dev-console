package com.promotion.devconsole.domain.dto;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class PendingProductDto {
    private Integer id;
    private Boolean isPendSuccess;
    private LocalDateTime pendingDate;
}
