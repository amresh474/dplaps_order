package com.dpl.order.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderItem implements Serializable {
	private static final long serialVersionUID = -210995560977194764L;
	private String orderItemId;
	private String pid;
	private String skuid;
	private String discountType;
	private String orderId;
	private double discount;
	private double totalPrice;
	private double perItemPrice;
	private int qty;
	private String status;
	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private String createdAt = LocalDateTime.now().toString();
	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private String updatedAt = LocalDateTime.now().toString();

}
