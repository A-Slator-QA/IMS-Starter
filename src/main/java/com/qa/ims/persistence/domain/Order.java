package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long orderId;
	private Long fk_customerId;
	private Long fk_itemId;
	private Long quantity;
	private Double price;
	private Double totalPrice;

	List<Order> orderItems = new ArrayList<>();

	public Order(Long fk_customerId) {
		this.setFk_customerId(fk_customerId);

	}

	public Order(Long orderId, Long fk_customerId) {
		this.setOrderId(orderId);
		this.setFk_customerId(fk_customerId);

	}

	public Order(Long orderId, Long fk_customerId, Long fk_itemId, Long quantity, Double price, Double totalPrice) {
		this.setOrderId(orderId);
		this.setFk_customerId(fk_customerId);
		this.setFk_itemId(fk_itemId);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setTotalPrice(totalPrice);
	}

	// ArrayList of items w/ tables from MySql

	public void addItemToOrder(Long orderId, Long fk_customerId, Long fk_itemId, Long quantity, Double price,
			Double totalPrice) {

		orderItems.add(new Order(orderId, fk_customerId, fk_itemId, quantity, price, totalPrice));
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getFk_customerId() {
		return fk_customerId;
	}

	public void setFk_customerId(Long fk_customerId) {
		this.fk_customerId = fk_customerId;
	}

	public Long getFk_itemId() {
		return fk_itemId;
	}

	public void setFk_itemId(Long fk_itemId) {
		this.fk_itemId = fk_itemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + ", Customer ID: " + fk_customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customerId == null) ? 0 : fk_customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

}
