package com.qa.ims.persistence.domain;

public class Order {

<<<<<<< Updated upstream
	private Long id;
	private Long customer_id;
	private Long item_id_1;

	public Order(Long customer_id, Long item_id_1) {
		this.setCustomer_id(customer_id);
		this.setItem_id_1(item_id_1);
=======
	private Long orderId;
	private Long customerId;
	private Long itemId;
	private Long quantity;
	private Double price;
	private Double totalPrice;

	List<Order> orderItems = new ArrayList<>();

	public Order(Long customerId) {
		this.setFk_customerId(customerId);

	}

	public Order(Long orderId, Long customerId) {
		this.setOrderId(orderId);
		this.setFk_customerId(customerId);

	}

	public Order(Long orderId, Long customerId, Long itemId, Long quantity, Double price, Double totalPrice) {
		this.setOrderId(orderId);
		this.setFk_customerId(customerId);
		this.setFk_itemId(itemId);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setTotalPrice(totalPrice);
	}

	// ArrayList of items w/ tables from MySql

	public void addItemToOrder(Long orderId, Long customerId, Long itemId, Long quantity, Double price,
			Double totalPrice) {

		orderItems.add(new Order(orderId, customerId, itemId, quantity, price, totalPrice));
>>>>>>> Stashed changes
	}

	public Order(Long id, Long customer_id, Long item_id_1) {
		this.setId(id);
		this.setCustomer_id(customer_id);
		this.setItem_id_1(item_id_1);
	}

	public Long getId() {
		return id;
	}

<<<<<<< Updated upstream
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
=======
	public Long getFk_customerId() {
		return customerId;
	}

	public void setFk_customerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getFk_itemId() {
		return itemId;
	}

	public void setFk_itemId(Long itemId) {
		this.itemId = itemId;
>>>>>>> Stashed changes
	}

	public void setItem_id_1(Long item_id_1) {
		this.item_id_1 = item_id_1;
	}

	@Override
	public String toString() {
<<<<<<< Updated upstream
		return "Order ID: " + id + ", Customer ID: " + customer_id + ", Item ID: " + item_id_1;
=======
		return "Order ID: " + orderId + ", Customer ID: " + customerId;
>>>>>>> Stashed changes
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
<<<<<<< Updated upstream
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_id_1 == null) ? 0 : item_id_1.hashCode());
=======
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
>>>>>>> Stashed changes
		return result;
	}
}
