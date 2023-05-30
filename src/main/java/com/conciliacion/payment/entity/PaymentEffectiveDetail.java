package com.conciliacion.payment.entity;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_effective_detail")
@EntityListeners(AuditingEntityListener.class)
public class PaymentEffectiveDetail {
		@Id	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_detail")
	    private int idDetail;

	    @Column(name = "id_payment_order")
	    private int idPaymentOrder;

	    @Column(name = "cu")
	    private String cu;

	    @Column(name = "doc_type")
	    private String docType;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "customer_doc_type")
	    private String customerDocType;

	    @Column(name = "issue_date")
	    private String issueDate;

	    @Column(name = "reason")
	    private String reason;

	    @Column(name = "reference_number")
	    private String referenceNumber;

	    @Column(name = "currency")
	    private String currency;

	    @Column(name = "sub_total")
	    private BigDecimal subTotal;

	    @Column(name = "igv")
	    private BigDecimal igv;

	    @Column(name = "delay")
	    private BigDecimal delay;

	    @Column(name = "total")
	    private BigDecimal total;

	    @Column(name = "detail_code")
	    private String detailCode;

}
