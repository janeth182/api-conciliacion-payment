package com.conciliacion.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.conciliacion.payment.entity.PaymentEffectiveHeader;
import com.conciliacion.payment.repository.PaymentEffectiveHeaderRepository;
import com.conciliacion.payment.service.PaymentEffectiveHeaderService;

@Service
public class PaymentEffectiveHeaderServiceImpl implements PaymentEffectiveHeaderService {

	@Autowired
	private PaymentEffectiveHeaderRepository repository;
	
	@Override
	public List<PaymentEffectiveHeader> findByCustomerRuc(String clientDocNumber, Pageable page) {
		try {
			return repository.findByCustomerRuc(clientDocNumber, page);
		} catch (Exception e) {
			return null;
		}
	}

}
