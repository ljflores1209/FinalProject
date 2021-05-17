package com.criCoinWeb;

public class ApiPojo {
	private String name;
	private String symbol;
	private double current_price;
	
	public ApiPojo(String name, String symbol, double current_price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.current_price = current_price;
	}
	
	public ApiPojo() {
		super();
		this.name = name;
		this.symbol = symbol;
		this.current_price = current_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	@Override
	public String toString() {
		return "ApiPojo [name=" + name + ", symbol=" + symbol + ", current_price=" + current_price + "]";
	}
	
	
}
