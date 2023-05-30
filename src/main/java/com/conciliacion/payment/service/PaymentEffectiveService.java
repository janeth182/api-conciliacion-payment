package com.conciliacion.payment.service;

import java.util.List;

import com.conciliacion.payment.entity.MessageResponse;
import com.conciliacion.payment.entity.PaymentEffectiveDetail;
import com.conciliacion.payment.entity.PaymentEffectiveHeader;

public interface PaymentEffectiveService {	
	public MessageResponse generatePaymentOrder(PaymentEffectiveHeader header, List<PaymentEffectiveDetail> details);
}
