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

	@Override
	public Order addItemToOrder() {
		LOGGER.info("Please enter the order ID you would like to add items to:");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the item ID you would like to add to the order:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity of the item to add to the order:");
		Long quantity = utils.getLong();
		Order order = orderDAO.addItemToOrder(orderId, itemId, quantity);
		return order;

	}

	@Override // Creates an order via user input
	public Order create() {
		LOGGER.info("Please enter the Customer ID:");
		Long customerID = utils.getLong();
		Order order = orderDAO.create(new Order(customerID));
		LOGGER.info("Order created");
		return order;
	}

	@Override // Updates an existing order
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a Customer ID");
		Long customerID = utils.getLong();
		Order order = orderDAO.update(new Order(orderId, customerID));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override // Deletes an existing order
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long orderId = utils.getLong();
		return orderDAO.delete(orderId);
	}

}
