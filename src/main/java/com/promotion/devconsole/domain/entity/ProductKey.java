package com.promotion.devconsole.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_key")
public class ProductKey implements Serializable {
    private static final long serialVersionUID = 9012044905671845878L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product")
    private Long product;


    @Column(name = "authorize_key")
    private String authorizeKey;
}
