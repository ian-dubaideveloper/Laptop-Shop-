package com.laptopshop.laptopshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.laptopshop.laptopshop.model.Laptop;

public class TestLaptop {
	private Laptop laptop;

	@Before
	public void setup() {
		laptop = new Laptop();
	}

	@Test
	public void testSetAndGetID() {
		laptop.setId(1);
		assertEquals(1, laptop.getId());
	}

	@Test
	public void testSetAndGetName() {
		laptop.setLapName("Richie");
		assertEquals("Richie", laptop.getLapName());
	}

	@Test
	public void testSetAndGetBrand() {
		laptop.setBrand("Apple");
		assertEquals("Apple", laptop.getBrand());
	}

	@Test
	public void testSetAndGetDisplay() {
		laptop.setDisplay("13-Inch");
		assertEquals("13-Inch", laptop.getDisplay());
	}

	@Test
	public void testSetAndGetProcessor() {
		laptop.setProcessor("2.4Ghz i7");
		assertEquals("2.4Ghz i7", laptop.getProcessor());
	}

	@Test
	public void testSetAndGetLapMem() {
		laptop.setLapMem("8Gb");
		assertEquals("8Gb", laptop.getLapMem());
	}

	@Test
	public void testSetAndGetHarddrive() {
		laptop.setHarddrive("1TB");
		assertEquals("1TB", laptop.getHarddrive());
	}

	@Test
	public void testSetAndGetGraphics() {
		laptop.setGraphics("Nvidia 1080m");
		assertEquals("Nvidia 1080m", laptop.getGraphics());
	}

	@Test
	public void testSetAndGetNumUsbs() {
		laptop.setNumUsbs("2");
		assertEquals("2", laptop.getNumUsbs());
	}

	@Test
	public void testSetAndGetPrice() {
		laptop.setPrice("1099.89");
		assertEquals("1099.89", laptop.getPrice());
	}

}
