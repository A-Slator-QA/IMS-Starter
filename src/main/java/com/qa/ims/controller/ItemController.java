package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override // Reads items to the logger
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override // Creates items from user input
	public Item create() {
		LOGGER.info("Please enter a title");
		String title = utils.getString();
		LOGGER.info("Please enter the price");
		double price = utils.getDouble();
		Item item = itemDAO.create(new Item(title, price));
		LOGGER.info("Item created");
		return item;
	}

	@Override // Allows user to update items
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a title");
		String title = utils.getString();
		LOGGER.info("Please enter a price");
		double price = utils.getDouble();
		Item item = itemDAO.update(new Item(id, title, price));
		LOGGER.info("Item updated");
		return item;
	}

	@Override // Allows the user to delete an item by id
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}

}
