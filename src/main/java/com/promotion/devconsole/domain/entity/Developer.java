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
@Table(name = "developer")
public class Developer implements Serializable {

 private static final long serialVersionUID = -474714203978955440L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private String id;

 @Column(name = "pw")
 private String pw;

 @Column(name = "auth_token")
 private String authToken;

 @Column(name = "authorize_key")
 private String authorizeKey;

}
