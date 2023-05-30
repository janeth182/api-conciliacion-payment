package com.conciliacion.payment.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class PaymentDetailDTO {		
	    @NotBlank(message = "El campo cu es obligatorio")
	    private String cu;
	    
	    @NotBlank(message = "El campo docType es obligatorio")
	    private String docType;
	    
	    @NotBlank(message = "El campo description es obligatorio")
	    private String description;
	    
	    @NotBlank(message = "El campo customerDocType es obligatorio")
	    private String customerDocType;
	    
	    @NotBlank(message = "El campo issueDate es obligatorio")
	    private String issueDate;
	    
	    @NotBlank(message = "El referenceNumber es obligatorio")
	    private String referenceNumber;
	    
	    @NotBlank(message = "El currency es obligatorio")
	    private String currency;
	    	    
	    @DecimalMin("0")
	    private BigDecimal subTotal;
	    
	    @DecimalMin("0")
	    private BigDecimal igv;
	    
	    @DecimalMin("0")
	    private BigDecimal delay;
	    
	    @DecimalMin("1")
	    private BigDecimal total;
	    
	    @NotBlank(message = "El detailCode es obligatorio")
	    private String detailCode;
}
