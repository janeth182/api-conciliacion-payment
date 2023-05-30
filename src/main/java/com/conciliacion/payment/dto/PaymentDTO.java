package com.conciliacion.payment.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class PaymentDTO {

	 @NotBlank(message = "El campo customerRuc es obligatorio")
	 private String customerRuc;
	 
	 @NotBlank(message = "El campo currency es obligatorio")
	 private String currency;
	 
	 @DecimalMin("1")
	 private BigDecimal totalAmount;
	 
	 @NotBlank(message = "El campo paymentConcept es obligatorio")
	 private String paymentConcept;
	 
	 @NotBlank(message = "El campo userFirstName es obligatorio")
	 private String userFirstName;	 	
	 
	 @NotBlank(message = "El campo userEmail es obligatorio")
	 @Pattern(regexp=".+@.+\\.[a-z]+", message = "Error de formato email")
	 private String userEmail;
	 	 	 
	 @Valid
	 private List<PaymentDetailDTO> details;
}
