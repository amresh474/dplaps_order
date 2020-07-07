package com.dpl.order.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document("dpl_order")
public class Order implements Serializable {
	private static final long serialVersionUID = -2108494147704578605L;
	@Id
	private String id;
	private String orderId;
	private String mobile;
	private String paymentMode;
	private double totalOrderPrice;
	private double totalOrderDiscount;
	private String promoCode;
	private Address shippingAddress;
	private Address billingAddress;
	private Map<String, OrderItem> orderItems;
	private String orderStatus="ORDER_PLACED";
	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private String createdAt = LocalDateTime.now().toString();
	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private String updatedAt = LocalDateTime.now().toString();
}
