package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long orderId;
	private Long customerId;
	private Long itemId;
	private Long quantity;
	private Double price;
	private Double totalPrice;

	List<Order> orderItems = new ArrayList<>();

	public Order(Long orderId2, Long customerId2, Long itemId2, Long quantity2, Double price2, Double totalPrice2) {
		// TODO Auto-generated constructor stub
	}

	public Order(Long customerId) {
		this.customerId = customerId;
	}

	public Order(Long orderId2, Long customer_id) {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void addItemToOrder(Long orderId1, Long customerId1, Long itemId1, Long quantity1, Double price2,
			Double totalPrice2) {

	}

}
