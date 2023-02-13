package com.laptopshop.laptopshop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.laptopshop.laptopshop.data.LaptopDAO;
import com.laptopshop.laptopshop.model.Laptop;
import com.laptopshop.laptopshop.rest.JaxRsActivator;
import com.laptopshop.laptopshop.rest.LaptopWS;
import com.laptopshop.laptopshop.test.utils.UtilsDAO;

//	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class TestIntegration {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "Test.jar")
				.addClasses(LaptopDAO.class, Laptop.class, JaxRsActivator.class, LaptopWS.class, UtilsDAO.class)
				// .addPackage(EventCause.class.getPackage())
				// .addPackage(EventCauseDAO.class.getPackage())
				// this line will pick up the production db
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	private static boolean setUpIsDone = false;

	@EJB
	private LaptopWS laptopWS;

	@EJB
	private LaptopDAO laptopDAO;

	@EJB
	private UtilsDAO utilsDAO;

	@Before
	public void setUp() {
		utilsDAO.deleteTable();
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setLapName("Arquillian");
		laptop.setBrand("test");
		laptop.setDisplay("20");
		laptop.setProcessor("Athlone");
		laptop.setLapMem("2000");
		laptop.setHarddrive("Big");
		laptop.setGraphics("1234");
		laptop.setNumUsbs("99");
		laptop.setPrice("9999.99");

		laptopDAO.save(laptop);
	}

	@Test
	public void testGetAllLaptops() {
		// Given
		// When
		List<Laptop> laptopList = laptopDAO.findAllLaptops();
		// Then
		assertEquals("GetAll Laptops() Failed.....", laptopList.size(), 1);
	}

	@Test
	public void testGetLaptopByName() {
		// Given
		// When
		List<Laptop> laptopList = laptopDAO.findLaptopsByName("Arquillian");
		// Then
		assertEquals("Laptop getName() failed...", laptopList.get(0).getLapName(), "Arquillian");
	}

	@Test
	public void testGetLaptopById() {
		// Given
		// When
		Laptop laptop = laptopDAO.findLaptopById(1);
		// Then
		assertEquals("Laptop getId() failed...", laptop.getId(), 1);
	}

	@Test
	public void testSaveMethod() {
		// Given
		Laptop laptop2 = new Laptop();

		// When
		laptop2.setId(2);
		laptop2.setLapName("Richie");
		laptop2.setBrand("test");
		laptop2.setDisplay("30");
		laptop2.setProcessor("Longford");
		laptop2.setLapMem("4000");
		laptop2.setHarddrive("Small");
		laptop2.setGraphics("4321");
		laptop2.setNumUsbs("9");
		laptop2.setPrice("8888.99");

		laptopDAO.save(laptop2);
		List<Laptop> laptopList = laptopDAO.findAllLaptops();
		// Then
		assertEquals("Laptop did not persist properly in Database...", laptopList.size(), 2);

	}

	@Test
	public void testUpdate() {
		// Given
		Laptop laptop3 = new Laptop();
		// When
		laptop3.setId(3);
		laptop3.setLapName("Richie");
		laptop3.setBrand("test");
		laptop3.setDisplay("30");
		laptop3.setProcessor("Longford");
		laptop3.setLapMem("4000");
		laptop3.setHarddrive("Small");
		laptop3.setGraphics("4321");
		laptop3.setNumUsbs("9");
		laptop3.setPrice("8888.99");

		laptopDAO.save(laptop3);

		laptop3.setLapName("Peter Andre");
		laptopDAO.update(laptop3);
		// Then
		assertEquals("Laptop Update failed...", laptop3.getLapName(), "Peter Andre");

	}

	@Test
	public void testDelete() {
		// Given...in before
		// When
		laptopDAO.delete(1);
		Laptop laptopID = laptopDAO.findLaptopById(1);
		// Then
		assertNull("Laptop Deleted failed...", laptopID);
	}
}
