package com.conciliacion.payment.service;

import com.conciliacion.payment.entity.PaymentEffectiveDetail;

public interface PaymentEffectiveDetailService {
	public PaymentEffectiveDetail findByIdPaymentOrder(int idPaymentOrder);
}
