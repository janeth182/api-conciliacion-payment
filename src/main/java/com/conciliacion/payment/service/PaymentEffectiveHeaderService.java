package com.conciliacion.payment.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.conciliacion.payment.entity.PaymentEffectiveHeader;

public interface PaymentEffectiveHeaderService {
	public List<PaymentEffectiveHeader>findByCustomerRuc(String clientDocNumber, Pageable page);
}
