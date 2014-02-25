/**
 * 
 */
package com.hervedarritchon.kata;

import static org.junit.Assert.assertEquals;
import static org.fest.assertions.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ahdi7503
 * 
 */
public class SheetTest {

	private Sheet sheet;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sheet = new Sheet();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test1 : Test that new Cells are empty
	 */
	@Test
	public void testThatCellsAreEmptyByDefault() {

		/* Non fluent syntaxe using JUnit */
		assertEquals("", sheet.get("A1"));
		assertEquals("", sheet.get("ZX1347"));

		/* Fluent syntaxe using Fest Assert from EasyTesting */
		assertThat(sheet.get("A2")).isEmpty();
		assertThat(sheet.get("ZX347")).isEmpty();
	}

	/**
	 * Test2 : Test that Cells are storing data
	 */
	@Test
	public void testThatTextCellsAreStored() {
		String theCell = "A20";

		sheet.put(theCell, "A string");
		assertEquals("A string", sheet.get(theCell));

		sheet.put(theCell, "A different string");
		assertEquals("A different string", sheet.get(theCell));

		sheet.put(theCell, "");
		assertEquals("", sheet.get(theCell));
	}

}
