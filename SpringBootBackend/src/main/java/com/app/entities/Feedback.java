package com.app.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	@Column(name = "name")
	private String name;
	
	@Column(name="email")
	@NotBlank(message = "Email is required")
	@Length(min = 5,max=50,message = "Invalid Email length")
	@Email(message = "Invalid email format")
	private String email;
	
	@Column(length = 60, name="message")
	private String message;
	
	@Min(value=1)
	@Max(value=5)
	@Column(name="rating")
	private int rating;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
}
	