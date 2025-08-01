package com.app.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Length(max=16,min=16)
//	@NotBlank(message="Card Number must be supplied")
	private long cardNo;
	
	//@NotBlank(message="Name must be supplied")
	private String nameOnCard;
	
	//@NotBlank(message="Amount must be supplied")
	private double amount;
	
	//@NotBlank(message="Date must be supplied")
	private Date paymentDate;
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardno=" + cardNo + ", nameOnCard=" + nameOnCard + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}
}
