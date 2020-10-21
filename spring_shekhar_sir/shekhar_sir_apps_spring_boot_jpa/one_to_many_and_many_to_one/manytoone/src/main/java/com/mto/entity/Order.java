package com.mto.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDERS")
@Data
@NoArgsConstructor
public class Order {
	
	@Id
	private Integer  id;
	
	@Column(length=15)
	private String itemName;
	
	private  LocalDate  orderDate;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTID_FK")
	private  Customer  customer;
	
	
}
