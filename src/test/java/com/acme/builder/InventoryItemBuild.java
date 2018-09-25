package com.acme.builder;

import java.util.ArrayList;
import java.util.List;

import com.acme.entity.InventoryItem;
import com.acme.entity.TshirtSize;

public class InventoryItemBuild {

	private InventoryItemBuild() {
	}

	public static List<InventoryItem> buildInventoryItems() {
		List<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();

		inventoryItems.add(buildInventoryItem1());
		inventoryItems.add(buildInventoryItem2());

		return inventoryItems;
	}

	public static InventoryItem buildInventoryItem1() {
		InventoryItem inventoryItem = new InventoryItem();		
		inventoryItem.setDescription("T-shirt with medium logo");
		inventoryItem.setProductCode(9001);
		inventoryItem.setSize(TshirtSize.M);
		inventoryItem.setCount(10);

		return inventoryItem;
	}

	public static InventoryItem buildInventoryItem2() {
		InventoryItem inventoryItem = new InventoryItem();		
		inventoryItem.setDescription("T-shirt with medium logo");
		inventoryItem.setProductCode(9002);
		inventoryItem.setSize(TshirtSize.L);
		inventoryItem.setCount(8);

		return inventoryItem;
	}
	
	public static InventoryItem buildInventoryItemUnavailable() {
		InventoryItem inventoryItem = new InventoryItem();		
		inventoryItem.setProductCode(9001);
		inventoryItem.setSize(TshirtSize.M);
		inventoryItem.setCount(0);

		return inventoryItem;
	}
}
