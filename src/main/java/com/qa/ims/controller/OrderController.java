package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override // Reads all orders to the logger
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override // Creates an order via user input
	public Order create() {
		LOGGER.info("Please enter the Customer ID:");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter the Item ID:");
		Long items_id = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id, items_id));
		LOGGER.info("Order created");
		return order;
	}

	@Override // Updates an existing order
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a Customer ID");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter an Item ID");
		Long items_id = utils.getLong();
		Order order = orderDAO.update(new Order(id, customer_id, items_id));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override // Deletes an existing order
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
