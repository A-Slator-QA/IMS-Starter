package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {

		Long orderId = resultSet.getLong("orderId");
		Long customerId = resultSet.getLong("customerId");
		Long itemId = resultSet.getLong("itemId");
		Long quantity = resultSet.getLong("quantity");
		Double price = resultSet.getDouble("price");
		Double totalPrice = resultSet.getDouble("totalPrice");
		return new Order(orderId, customerId, itemId, quantity, price, totalPrice);

	}

	@Override // Reads all orders from the database
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(
						"Select o.`orderId`, o.`fk_customerId` as customerId, p.`fk_itemId` as ItemId, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i join `orderItems` p join `orders` o on o.`orderId` = p.`fk_orderId` on i.`itemId` = p.`fk_itemId` order by o.`orderId`");) {

			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(
						"Select o.`orderId`, o.`fk_customerId` as customerId, p.`fk_itemId` as ItemId, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i join `orderItems` p join `orders` o on o.`orderId` = p.`fk_orderId` on i.`itemId` = p.`fk_itemId` order by o.`orderId`  DESC LIMIT 1");) {

			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection.prepareStatement(
						"Select o.`orderId`, o.`fk_customerId` as customerId, p.`fk_itemId` as ItemId, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i join `orderItems` p join `orders` o on o.`orderId` = p.`fk_orderId` on i.`itemId` = p.`fk_itemId` order by o.`orderId` WHERE orderId = ?;");) {
			statement.setLong(1, orderId);

			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order addItemToOrder(Long orderId, Long itemId, Long quantity) {

		Order order = read(orderId);
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO orderItems(fk_orderId, fk_itemId, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getOrderId());
			statement.setLong(2, itemId);
			statement.setLong(3, quantity);
			statement.executeUpdate();

			PreparedStatement chungus = connection.prepareStatement(
					"Select o.`orderId`, o.`fk_customerId` as customerId, p.`fk_itemId` as ItemId, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i join `orderItems` p join `orders` o on o.`orderId` = p.`fk_orderId` on i.`itemId` = p.`fk_itemId` where o.`orderId` = ?;");

			chungus.setLong(1, order.getOrderId());
			ResultSet resultSet = chungus.executeQuery();
			while (resultSet.next()) {
				Long orderId1 = resultSet.getLong("orderId");
				Long customerId1 = resultSet.getLong("customerId");
				Long itemId1 = resultSet.getLong("itemId1");
				Long quantity1 = resultSet.getLong("quantity");
				Double price = resultSet.getDouble("price");
				Double totalPrice = resultSet.getDouble("totalPrice");

				order.addItemToOrder(orderId1, customerId1, itemId1, quantity1, price, totalPrice);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return order;
	}

	@Override // Creates an order in the database
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fk_customerId) VALUES (?)");) {
			statement.setLong(1, order.getCustomerId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override // Updates order details
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET fk_customerId = ? WHERE orderId = ?");) {
			statement.setLong(1, order.getCustomerId());
			statement.setLong(2, order.getOrderId());
			statement.executeUpdate();
			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override // Deletes an order from the database
	public int delete(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE orderId = ?");) {
			statement.setLong(1, orderId);
			PreparedStatement statement1 = connection.prepareStatement("DELETE FROM orderItems WHERE fk_orderId = >");
			{
				statement1.setLong(1, orderId);
			}
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
