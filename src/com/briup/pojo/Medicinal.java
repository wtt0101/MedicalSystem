package com.briup.pojo;

public class Medicinal {
	private int id;//ҩƷ���
	private String name;//ҩƷ����
	private String type;//ҩƷ����
	private String description;//ҩƷ����
	private double price;//ҩƷ�۸�
	
	public Medicinal() {}
	
	public Medicinal(int id,String name,String type,String description,double price) {
		super();
		this.id=id;
		this.name=name;
		this.type=type;
		this.description=description;
		this.price=price;
	}
	
	public Medicinal(String name,String type,String description,double price) {
		super();
		this.name=name;
		this.type=type;
		this.description=description;
		this.price=price;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
