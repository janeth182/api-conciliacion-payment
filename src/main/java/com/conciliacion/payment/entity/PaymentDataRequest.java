package com.conciliacion.payment.entity;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaymentDataRequest {
	private String description;
    private String currency;
    private BigDecimal amount;
    private String merchantId;
    private String merchantEmail;
    private String userName;
    private String userEmail;
}
