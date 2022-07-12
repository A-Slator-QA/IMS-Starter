package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customer_id;
	private Long item_id_1;

	public Order(Long customer_id, Long item_id_1) {
		this.setCustomer_id(customer_id);
		this.setItem_id_1(item_id_1);
	}

	public Order(Long id, Long customer_id, Long item_id_1) {
		this.setId(id);
		this.setCustomer_id(customer_id);
		this.setItem_id_1(item_id_1);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getItem_id_1() {
		return item_id_1;
	}

	public void setItem_id_1(Long item_id_1) {
		this.item_id_1 = item_id_1;
	}

	@Override
	public String toString() {
		return "Order ID: " + id + ", Customer ID: " + customer_id + ", Item ID: " + item_id_1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_id_1 == null) ? 0 : item_id_1.hashCode());
		return result;
	}
}
