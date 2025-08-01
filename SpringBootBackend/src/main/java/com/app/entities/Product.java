package com.app.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(length=30)
	@NotBlank(message="name must be supplied")
	private String pname;
	
	@Column(length=30)
	@NotBlank(message="name must be supplied")
	private String brand;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	private double price;
	
	private String photo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp", insertable = true, updatable = false)
	private Date createdTimestamp=new Date();    //date generated here not mapped in Dto
	
	@ManyToOne
	@JoinColumn(name="sellerId")
	private Seller seller;
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", pname=" + pname + ", pcategory=" + category.getCategoryName() + ", price="
				+ price + ", photo=" + photo + ", createdTimestamp=" + createdTimestamp + "]";
	}
}
