package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long fk_customerId;
	private Long fk_itemId;

	public Order(Long fk_customerId, Long fk_itemId) {
		this.setFk_customerId(fk_customerId);
		this.setFk_itemId(fk_itemId);
	}

	public Order(Long orderId, Long fk_customerId, Long fk_itemId) {
		this.setOrderId(orderId);
		this.setFk_customerId(fk_customerId);
		this.setFk_itemId(fk_itemId);
	}

	// ArrayList of items w/ tables from MySql

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

	@Override
	public String toString() {
		return "Order ID: " + orderId + ", Customer ID: " + fk_customerId + ", Item Order ID: " + fk_itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customerId == null) ? 0 : fk_customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((fk_itemId == null) ? 0 : fk_itemId.hashCode());
		return result;
	}
}
