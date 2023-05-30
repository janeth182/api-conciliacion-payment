package com.conciliacion.payment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conciliacion.payment.dto.PaymentDTO;
import com.conciliacion.payment.entity.MessageResponse;
import com.conciliacion.payment.entity.PaymentEffectiveDetail;
import com.conciliacion.payment.entity.PaymentEffectiveHeader;
import com.conciliacion.payment.service.PaymentEffectiveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/payment")
public class PaymentEffectiveController {
	@Autowired
	private PaymentEffectiveService service;
	
	@PostMapping()
	public ResponseEntity<MessageResponse> generatePaymentOrder(@Valid @RequestBody PaymentDTO payment) {		
		PaymentEffectiveHeader header = new PaymentEffectiveHeader();
		header.setCustomerRuc(payment.getCustomerRuc());
		header.setCurrency(payment.getCurrency());
		header.setTotalAmount(payment.getTotalAmount());
		header.setPaymentConcept(payment.getPaymentConcept());
		header.setUserFirstName(payment.getUserFirstName());
		header.setUserEmail(payment.getUserEmail());
		
		List<PaymentEffectiveDetail> details = new ArrayList<>();
		
		payment.getDetails().forEach((item)->{
			PaymentEffectiveDetail ob = new PaymentEffectiveDetail();				 
		     BeanUtils.copyProperties(item, ob);		    
		     details.add(ob);
		});
		
		MessageResponse response = service.generatePaymentOrder(header, details);
		return new ResponseEntity<>(response, HttpStatus.CREATED);	
	}
	
	
}
