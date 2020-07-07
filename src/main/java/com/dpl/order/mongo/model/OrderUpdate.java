package com.dpl.order.mongo.model;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ObjectUtils;

import com.dpl.order.model.Order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderUpdate {
	private OrderUpdate() {
	}

	public static Update updateOrder(Order order) {
		Update update = new Update();
		if (!ObjectUtils.isEmpty(order.getBillingAddress().getCity()))
			update.set("billingAddress.city", order.getBillingAddress().getCity());
		if (!ObjectUtils.isEmpty(order.getBillingAddress().getCountry()))
			update.set("billingAddress.firstName", order.getBillingAddress().getFirstName());
		if (!ObjectUtils.isEmpty(order.getBillingAddress().getLine1()))
			update.set("billingAddress.line1", order.getBillingAddress().getLine1());
		if (!ObjectUtils.isEmpty(order.getBillingAddress().getMobile()))
			update.set("billingAddress.mobile", order.getBillingAddress().getMobile());
		if (!ObjectUtils.isEmpty(order.getBillingAddress().getLastName()))
			update.set("billingAddress.line2", order.getBillingAddress().getLine2());

		return update;
	}

}
