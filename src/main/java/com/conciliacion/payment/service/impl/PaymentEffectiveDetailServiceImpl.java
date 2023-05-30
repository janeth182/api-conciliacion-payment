package com.conciliacion.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conciliacion.payment.entity.PaymentEffectiveDetail;
import com.conciliacion.payment.repository.PaymentEffectiveDetailRepository;
import com.conciliacion.payment.service.PaymentEffectiveDetailService;

@Service
public class PaymentEffectiveDetailServiceImpl implements PaymentEffectiveDetailService {

	@Autowired
	private PaymentEffectiveDetailRepository repository;
	
	@Override
	public PaymentEffectiveDetail findByIdPaymentOrder(int idPaymentOrder) {
		try {
			return repository.findByIdPaymentOrder(idPaymentOrder);
		} catch (Exception e) {
			return null;
		}
	}

}
