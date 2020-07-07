package com.dpl.order.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpl.order.model.Order;
import com.dpl.order.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
	private static Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping("")
	public ResponseEntity<Order> createOder(@RequestBody Order order,
			@RequestHeader(value = "mobile", required = false) String mobile) {
		order = orderService.createOrder(order);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{orderId}")
	public ResponseEntity<List<Order>> findOrder(@PathVariable String orderId,
			@RequestParam Map<String, String> queryMap,
			@RequestHeader(value = "mobile", required = false) String mobile){
		List<Order> orders = orderService.findOrder(orderId, queryMap);
			return  ResponseEntity.ok(orders);

	
	}

	@PutMapping(value = "/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
		Order orders= orderService.updateOrder(orderId, order);
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}

	@PatchMapping(value = "/{orderId}")
	public ResponseEntity<Order> modifyOrder(@PathVariable String orderId, @RequestBody Order order) {
		Order orderRes = orderService.modifyOrder(orderId, order);
		return new ResponseEntity<>(orderRes, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable String orderId,
			@RequestHeader(value = "mobile", required = false) String mobile, @RequestParam String orderStatus) {
		orderService.deleteOrder(orderId, orderStatus);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
