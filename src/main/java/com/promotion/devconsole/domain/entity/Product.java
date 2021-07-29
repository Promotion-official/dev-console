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
@Table(name = "product")
public class Product implements Serializable {

 private static final long serialVersionUID = -6092160964469198095L;

 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long id;

 @Column(name = "name")
 private String name;

 @Column(name = "description")
 private String description;

 @Column(name = "developer")
 private String developer;

}
