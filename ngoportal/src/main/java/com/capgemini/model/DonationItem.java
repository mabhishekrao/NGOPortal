package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class DonationItem {
	@Id
	@GeneratedValue
	private int itemId;
	private DonationType item;
	private String itemDescription;

	public DonationItem(DonationType item, String itemDescription) {
		super();
		this.item = item;
		this.itemDescription = itemDescription;
	}

	public DonationItem() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public DonationType getItem() {
		return item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
