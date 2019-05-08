package com.qhit.beans;

public class Goods {
	
	private int id;
	private String name;
	private double blance;
	
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBlance() {
		return blance;
	}
	public void setBlance(double blance) {
		this.blance = blance;
	}
	public Goods(int id, String name, double blance) {
		super();
		this.id = id;
		this.name = name;
		this.blance = blance;
	}
	public Goods() {
		super();
	}
	

}
