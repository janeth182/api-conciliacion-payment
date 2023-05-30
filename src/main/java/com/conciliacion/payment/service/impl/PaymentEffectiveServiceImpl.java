package com.conciliacion.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.conciliacion.payment.entity.PaymentEffectiveDetail;
import com.conciliacion.payment.entity.PaymentEffectiveHeader;
import com.conciliacion.payment.repository.PaymentEffectiveDetailRepository;
import com.conciliacion.payment.repository.PaymentEffectiveHeaderRepository;
import com.conciliacion.payment.service.PaymentEffectiveService;
import com.conciliacion.payment.entity.MessageResponse;
import com.conciliacion.payment.entity.PaymentDataRequest;
import com.conciliacion.payment.entity.PaymentDataResponse;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpEntity;

@Service
public class PaymentEffectiveServiceImpl implements PaymentEffectiveService{
	@Autowired
	private PaymentEffectiveHeaderRepository headerRepository;
	@Autowired
	private PaymentEffectiveDetailRepository detailRepository;
	
	private static final String API_URL_BASE = "https://d0udn39i53.execute-api.us-west-2.amazonaws.com";
	
	@Override
	@Transactional()
	public MessageResponse generatePaymentOrder(PaymentEffectiveHeader paymenHeader, List<PaymentEffectiveDetail> details) {
		try {				
			
			paymenHeader.setCommerceEmail("conciliacion@gmail.com");
			paymenHeader.setServiceCode("CON002");
			
			PaymentDataResponse respondeData = sendDataApi(paymenHeader);
			paymenHeader.setCipNumber(respondeData.getCip());
			paymenHeader.setCipStatus(respondeData.getStatusId());
			paymenHeader.setCipExpirationDate(respondeData.getExpirationDate());
			
			PaymentEffectiveHeader order = headerRepository.save(paymenHeader);
			
			for(PaymentEffectiveDetail detail: details) {	
				detail.setIdPaymentOrder(order.getIdPaymentOrder());
				detailRepository.save(detail);
			}
			
			MessageResponse response = new MessageResponse();
			
			response.setAmount(order.getTotalAmount());
			response.setCip(order.getCipNumber());
			response.setCurrency(order.getCurrency());
			response.setExpirationDate(order.getCipExpirationDate());
			response.setGenerationDate(order.getCipGenerationDate());
			response.setMessage("Se genero el CIP:" + order.getCipNumber());			
			
			return response;
		} catch (Exception e) {
			return null;
		}		
	}
		
	public PaymentDataResponse sendDataApi(PaymentEffectiveHeader paymenHeader) {
		PaymentDataRequest requestData = new PaymentDataRequest();
		requestData.setDescription(paymenHeader.getPaymentConcept());
		requestData.setCurrency(paymenHeader.getCurrency());
		requestData.setAmount(paymenHeader.getTotalAmount());
		requestData.setMerchantId(paymenHeader.getServiceCode());
		requestData.setMerchantEmail(paymenHeader.getCommerceEmail());
		requestData.setUserName(paymenHeader.getUserFirstName());
		requestData.setUserEmail(paymenHeader.getUserEmail());
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<PaymentDataRequest> request = new HttpEntity<>(requestData, headers);             
        
       return restTemplate.postForObject(API_URL_BASE + "/pago-efectivo/create-order", request, PaymentDataResponse.class);
	}
}
