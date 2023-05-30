package com.conciliacion.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conciliacion.payment.entity.PaymentEffectiveDetail;
import com.conciliacion.payment.service.PaymentEffectiveDetailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/payment-detail")
public class PaymentEffectiveDetailController {
	@Autowired
	private PaymentEffectiveDetailService service;
	
	@GetMapping
	public ResponseEntity<PaymentEffectiveDetail> findByIdPaymentOrder(@Valid
			@RequestParam(value="idPaymentOrder", required = true) int idPaymentOrder) {

		PaymentEffectiveDetail detail = service.findByIdPaymentOrder(idPaymentOrder);
		
		if(detail != null) {
			return ResponseEntity.ok(detail);	
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
}
