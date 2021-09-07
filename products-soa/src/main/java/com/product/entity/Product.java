package com.product.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(generator="PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="PRODUCT_SEQ",sequenceName="PRODUCT_SEQ", allocationSize = 1)
	@Column(name = "PRODUCT_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "QUANTITY")
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}