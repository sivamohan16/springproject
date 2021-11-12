package com.test.springmvcex;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruit {
	
	@Id
	private int id;
	private String fruitname;
	private double fruitprice;
	private int quantity;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFruitname() {
		return fruitname;
	}
	public void setFruitname(String fruitname) {
		this.fruitname = fruitname;
	}
	public double getFruitprice() {
		return fruitprice;
	}
	public void setFruitprice(double fruitprice) {
		this.fruitprice = fruitprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
