package com.promotion.devconsole.entity;

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
@Table(name = "permission")
public class Permission implements Serializable {

 private static final long serialVersionUID = 4281117701460378816L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private String id;

 @Column(name = "request_limit_permission")
 private Integer requestLimitPermission;

}
