/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author edwinmwaniki
 *
 */
public class VendingMachineItemTest {
	/**
	 * Declaring the objects for Vending Machine Item class
	 */
	VendingMachineItem v1;
	VendingMachineItem v2;
	
	/**
	 *setUp method
	 *Initialize the objects for the Vending Machine Item
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		 v1 = new VendingMachineItem("Cookies",5.00);
		 v2 = new VendingMachineItem("Chips",20.00);
		 try{
			 v2 = new VendingMachineItem("Chips",-1);
				fail();
			}catch(Exception e){
				String except = "Price cannot be less than zero";
				assertEquals(except,e.getMessage());
			}
		 
		 try{
			 v2 = new VendingMachineItem("Chips",50.234);
				fail();
			}catch(Exception e){
				String except = "Price cannot be contain more than two decimal places";
				assertEquals(except,e.getMessage());
			}
		 
		
	}

	/**
	 * tearDown() method
	 * Tears down the Vending Machine Item object 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
	}

	/**
	 * Test for the the constructors of the {@link Vending Machine Item} class..
	 */
	@Test
	public void testVendingMachineItem() {
		VendingMachineItem v3 = new VendingMachineItem("Ribs",40.00);
		VendingMachineItem v4 = new VendingMachineItem("Steak",90.00);
		assertEquals("Ribs",v3.getName());
		assertEquals("Steak",v4.getName());
		assertEquals(40.00,v3.getPrice(),0.0001);
		assertEquals(90.00,v4.getPrice(),0.0001);
	}

	/**
	 * Test for the get Name method for  the {@link Vending Machine Item} class..
	 */
	@Test
	public void testGetName() {
		assertEquals("Cookies",v1.getName());
		assertEquals("Chips",v2.getName());
	}

	/**
	 * Test for the the get Price method for the {@link Vending Machine Item} class..
	 */
	@Test
	public void testGetPrice() {
		assertEquals(5.00,v1.getPrice(),0.001);
		assertEquals(20.00,v2.getPrice(),0.001);
	}

}
