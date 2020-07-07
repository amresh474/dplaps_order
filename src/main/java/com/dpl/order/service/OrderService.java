package com.dpl.order.service;

import java.util.List;
import java.util.Map;

import com.dpl.order.model.Order;

public interface OrderService {

	public Order createOrder(Order order);

	public List<Order> findOrder(String orderId, Map<String, String> map);

	public Order updateOrder(String orderId, Order order);

	public void deleteOrder(String orderId, String orderStatus);

	public Order modifyOrder(String orderId, Order order);

}
