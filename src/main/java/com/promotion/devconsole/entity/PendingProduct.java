package com.promotion.devconsole.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pending_product")
public class PendingProduct implements Serializable {

 private static final long serialVersionUID = 5450189189498800446L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Integer id;

 @Column(name = "is_pend_success")
 private Boolean isPendSuccess;

 @Column(name = "pending_date")
 private LocalDateTime pendingDate;

}
