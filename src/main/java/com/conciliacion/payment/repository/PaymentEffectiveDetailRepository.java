package com.conciliacion.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conciliacion.payment.entity.PaymentEffectiveDetail;

@Repository
public interface PaymentEffectiveDetailRepository  extends JpaRepository<PaymentEffectiveDetail, Integer>{
	PaymentEffectiveDetail findByIdPaymentOrder(int idPaymentOrder);	
}
