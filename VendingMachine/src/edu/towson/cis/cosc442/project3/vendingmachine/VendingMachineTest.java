package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.towson.cis.cosc442.project2.rectangle.Rectangle;
/**
 * Unit Test For Vending Machine
 * @author edwinmwaniki
 *
 */
public class VendingMachineTest {
	/**
	 * Declaring the Vending Machine and the Vending Machine Item Objects
	 */
	VendingMachine vm;
	VendingMachineItem vi;
	/**
	 * setUp Method
	 * Initializes the Vending Machine Object
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
	}
	
	/**
	 * tearDown Method
	 *Tears down the Vending Machine object 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		vm = null;
	}
	/**
	 * Test for the addItem() method of the {@link Vending Machine} class.
	 */
	@Test
	public void testAddItem() {
		vi = new VendingMachineItem("Cookies",.01);
		vm.addItem(vi, "A");
		assertEquals("Cookies",vm.getItem("A").getName());
		assertEquals(.01,vm.getItem("A").getPrice(),0.001);
		
		vi = new VendingMachineItem("Kit Kat",100);
		vm.addItem(vi, "B");
		assertEquals("Kit Kat",vm.getItem("B").getName());
		assertEquals(100,vm.getItem("B").getPrice(),0.001);
		
		try{
			vi = new VendingMachineItem("Cake",.01);
			vm.addItem(vi, "A");
		}catch(Exception e){
			String except  = "Slot A already occupied";
			assertEquals(except,e.getMessage());
		}
		try{
			vi = new VendingMachineItem("Cake",.01);
			vm.addItem(vi, "F");
		}catch(Exception e){
			String except  = "Invalid code for vending machine item";
			assertEquals(except,e.getMessage());
		}
	}
	/**
	 * Test for the removeItem() method of the {@link Vending Machine} class.
	 */
	@Test
	public void testRemoveItem() {
		vi = new VendingMachineItem("Hummus",50);
		vm.addItem(vi, "C");
		assertEquals(vi,vm.removeItem("C"));
		
		try{
			vm.removeItem("B");
		}catch(Exception e){
			String except  = "Slot B is empty -- cannot remove item";
			assertEquals(except,e.getMessage());
		}
		
		
		
	}
	
	/**
	 *Test for the insertMoney() method of the {@link Vending Machine} class.
	 */
	@Test
	public void testInsertMoney() {
		vm.insertMoney(20.00);
		vm.insertMoney(20.00);
		assertEquals(40.00,vm.getBalance(),0.001);
		try{
			vm.insertMoney(-1);
			fail();
		}catch(Exception e){
			String except = "Invalid amount.  Amount must be >= 0";
			assertEquals(except,e.getMessage());
		}
		
		try{
			vm.insertMoney(56.789);
			fail();
		}catch(Exception e){
			String except = "Price cannot be contain more than two decimal places";
			assertEquals(except,e.getMessage());
		}
		
		
	}
	/**
	 * Test for the getBalance() method of the {@link Vending Machine} class.
	 */
	@Test
	public void testGetBalance() {
		vm.insertMoney(2.75);
		assertEquals(2.75,vm.getBalance(),0.0001);
	}

	/**
	 * Test for the makePurchase() method of the {@link Vending Machine} class.
	 */
	@Test
	public void testMakePurchase() {
		vi = new VendingMachineItem("Hummus",50);
		vm.addItem(vi, "D");
		vm.insertMoney(50.00);
		assertEquals(true,vm.makePurchase("D"));
		try{
			vm.makePurchase("A");
		}catch(Exception e){
			String except  = " is empty -- cannot remove item";
			assertEquals(except,e.getMessage());
		}
	}

	@Test
	public void testReturnChange() {
		vm.insertMoney(10.00);
		assertEquals(10.00,vm.returnChange(),0.0001);
		vi = new VendingMachineItem("Hummus",50);
		vm.insertMoney(50.00);
		vm.addItem(vi, "B");
		vm.makePurchase("B");
		assertEquals(0.00,vm.returnChange(),0.0001);
	}

}
