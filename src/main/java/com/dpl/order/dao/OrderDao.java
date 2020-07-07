package com.dpl.order.dao;

import java.util.List;
import java.util.Map;

import com.dpl.order.model.Order;

public interface OrderDao {

	public Order createOrder(Order order);

	public List<Order> findOrder(String orderId, Map<String, String> queryMap);

	public Order update(String orderId, Order order);

	public void deleteOrder(String orderId, String orderStatus);

	public Order modifyOrder(String orderId, Order order);

}
