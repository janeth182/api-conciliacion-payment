package com.conciliacion.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_effective_header")
@EntityListeners(AuditingEntityListener.class)
public class PaymentEffectiveHeader {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_payment_order")
    private int idPaymentOrder;

    @Column(name = "customer_ruc")
    private String customerRuc;

    @Column(name = "cip_number")
    private String cipNumber;

    @Column(name = "cip_status")
    private int cipStatus;

    @Column(name = "currency")
    private String currency;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "payment_concept")
    private String paymentConcept;

    @Column(name = "service_code")
    private String serviceCode;

    @Column(name = "commerce_email")
    private String commerceEmail;

    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_email")
    private String userEmail;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cip_generation_date")
    private Date cipGenerationDate;

    @Column(name = "cip_payment_date")
    private Date cipPaymentDate;

    @Column(name = "cip_expiration_date")
    private Date cipExpirationDate;

    @Column(name = "reconciliation_date")
    private Date reconciliationDate;

    @Column(name = "settlement_date")
    private Date settlementDate; 
    
    @PrePersist
    protected void prePersist() {
    	cipGenerationDate = new Date(); 
    }
}
