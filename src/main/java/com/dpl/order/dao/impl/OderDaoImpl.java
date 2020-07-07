package com.dpl.order.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.dpl.order.dao.OrderDao;
import com.dpl.order.model.Order;
import com.dpl.order.mongo.model.OrderUpdate;
import com.dpl.order.properties.Codes;

@Repository("OderDaoImpl")
public class OderDaoImpl implements OrderDao {
	private static final Logger LOGGER = LogManager.getLogger(OderDaoImpl.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private Codes codes;

	@Override
	public Order createOrder(Order order) {
		Order orderRes = mongoTemplate.save(order);
		return orderRes;
	}

	@Override
	public List<Order> findOrder(String orderId, Map<String, String> queryMap) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderId").is(orderId));
		if (!ObjectUtils.isEmpty(queryMap.get("orderStatus"))) {
			query.addCriteria(Criteria.where("orderStatus").is(queryMap.get("orderStatus")));
		}
		return mongoTemplate.find(query, Order.class);
	}

	@Override
	public Order update(String orderId, Order order) {
		Query query = new Query();

		return null;
	}

	@Override
	public void deleteOrder(String orderId, String orderStatus) {
		Query query = new Query();
		String upDate = "Succ";
		query.addCriteria(Criteria.where("orderId").is(orderId));

		Update update = new Update();
		if (!ObjectUtils.isEmpty(orderStatus)) {
			update.set("orderStatus", orderStatus);
		}

	}

	@Override
	public Order modifyOrder(String orderId, Order order) {

		Query query = new Query();
		query.addCriteria(Criteria.where("orderId").is(orderId));

		Update update = OrderUpdate.updateOrder(order);
		return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Order.class);

	}

}
