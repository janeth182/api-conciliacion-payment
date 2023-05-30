package com.conciliacion.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conciliacion.payment.entity.PaymentEffectiveHeader;
import com.conciliacion.payment.service.PaymentEffectiveHeaderService;


@RestController
@RequestMapping("/v1/payment-header")
public class PaymentEffectiveHeaderController {
	@Autowired
	private PaymentEffectiveHeaderService service;
	
	@GetMapping
	public ResponseEntity<List<PaymentEffectiveHeader>> findByCustomerRuc(
			@RequestParam(value="clientNumber", required = false, defaultValue = "") String clientNumber,
			@RequestParam(value="offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit",required = false,defaultValue = "5") int pageSize) {
		Pageable page=PageRequest.of(pageNumber,pageSize);
		List<PaymentEffectiveHeader> paymentEffectiveHeader;
		paymentEffectiveHeader = service.findByCustomerRuc(clientNumber, page);
		if(paymentEffectiveHeader.size() > 0) {
			return ResponseEntity.ok(paymentEffectiveHeader);	
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
}
