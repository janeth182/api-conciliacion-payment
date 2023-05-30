package com.conciliacion.payment.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conciliacion.payment.entity.PaymentEffectiveHeader;
@Repository
public interface PaymentEffectiveHeaderRepository  extends JpaRepository<PaymentEffectiveHeader, Integer> {
	List<PaymentEffectiveHeader>findByCustomerRuc(String customerRuc, Pageable page);
}
