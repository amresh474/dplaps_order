package com.dpl.order.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dpl.order.config.Response;
import com.dpl.order.dao.OrderDao;
import com.dpl.order.exception.BadReqException;
import com.dpl.order.exception.ErrorCodes;
import com.dpl.order.model.Order;
import com.dpl.order.properties.Codes;
import com.dpl.order.service.OrderService;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private Codes codes;

	@Override
	public Order createOrder(Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		return orderDao.createOrder(order);
	}

	@Override
	public List<Order> findOrder(String orderId, Map<String, String> queryMap) {
		List<Order> orders = orderDao.findOrder(orderId, queryMap);
		if (ObjectUtils.isEmpty(orders)) {
			throw new BadReqException(ErrorCodes.Sso_Unauthorized);
		}
		return orders;
	}

	@Override
	public Order updateOrder(String orderId, Order order) {
		
		return null;

	}

	@Override
	public void deleteOrder(String orderId, String orderStatus) {

		orderDao.deleteOrder(orderId, orderStatus);
	}

	@Override
	public Order modifyOrder(String orderId, Order order) {
		Order o = orderDao.modifyOrder(orderId, order);
		if (ObjectUtils.isEmpty(o)) {
			throw new BadReqException(ErrorCodes.Sso_UserNotExist);
		}
		return o;

	}

}
