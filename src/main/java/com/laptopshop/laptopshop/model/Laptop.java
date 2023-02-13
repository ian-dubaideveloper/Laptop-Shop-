package com.laptopshop.laptopshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
// @Table(name = "laptops")
public class Laptop {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Column(name = "lapName")
	private String lapName;

	// @Column(name = "brand")
	private String brand;

	private String display;

	private String processor;

	private String lapMem;

	private String harddrive;

	private String graphics;

	private String numUsb;

	private String picture;

	private String price;

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public String getNumUsb() {
		return numUsb;
	}

	public void setNumUsb(String numUsb) {
		this.numUsb = numUsb;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getLapMem() {
		return lapMem;
	}

	public void setLapMem(String lapMem) {
		this.lapMem = lapMem;
	}

	public String getHarddrive() {
		return harddrive;
	}

	public void setHarddrive(String harddrive) {
		this.harddrive = harddrive;
	}

	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	public String getNumUsbs() {
		return numUsb;
	}

	public void setNumUsbs(String numUsbs) {
		this.numUsb = numUsbs;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
