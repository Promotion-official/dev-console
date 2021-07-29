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
@Table(name = "api")
public class Api implements Serializable {

 private static final long serialVersionUID = 3063649780956971972L;

 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "name")
 private String name;

 @Column(name = "url")
 private String url;

}
