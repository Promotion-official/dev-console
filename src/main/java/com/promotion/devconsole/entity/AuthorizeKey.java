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
@Table(name = "authorize_key")
public class AuthorizeKey implements Serializable {

 private static final long serialVersionUID = 3601472106969795194L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "authorize_key")
 private String authorizeKey;

 @Column(name = "api")
 private String api;

 @Column(name = "permission")
 private String permission;

}
