/**
 * 
 */
package com.hervedarritchon.kata;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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

	private Sheet sheet;

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
	 * *** TDD PART 1 ***
	 */

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
	 * Test3 : Test that several value can be stored, one value in each cell
	 */
	@Test
	public void testThatManyCellsExist() {
		sheet.put("A1", "First");
		sheet.put("X27", "Second");
		sheet.put("ZX901", "Third");

		assertEquals("A1", "First", sheet.get("A1"));
		assertEquals("X27", "Second", sheet.get("X27"));
		assertEquals("ZX901", "Third", sheet.get("ZX901"));

		sheet.put("A1", "Fourth");
		assertEquals("A1 after", "Fourth", sheet.get("A1"));
		assertEquals("X27 same", "Second", sheet.get("X27"));
		assertEquals("ZX901 same", "Third", sheet.get("ZX901"));
	}

	/**
	 * Test4 : Numerical cell are identified and stored differently than string
	 * cell
	 */
	@Test
	public void testThatNumericCellsAreIdentifiedAndStored() {
		final String theCell = "A21";

		sheet.put(theCell, "X99"); // "Obvious" string
		assertEquals("X99", sheet.get(theCell));

		sheet.put(theCell, "14"); // "Obvious" number
		assertEquals("14", sheet.get(theCell));

		sheet.put(theCell, " 99 X"); // Whole string must be numeric
		assertEquals(" 99 X", sheet.get(theCell));

		sheet.put(theCell, " 1234 "); // Blanks ignored
		assertEquals("1234", sheet.get(theCell));

		sheet.put(theCell, " "); // Just a blank
		assertEquals(" ", sheet.get(theCell));
	}

	/**
	 * Test2 : Test that Cells are storing data
	 */
	@Test
	public void testThatTextCellsAreStored() {
		final String theCell = "A20";

		sheet.put(theCell, "A string");
		assertEquals("A string", sheet.get(theCell));

		sheet.put(theCell, "A different string");
		assertEquals("A different string", sheet.get(theCell));

		sheet.put(theCell, "");
		assertEquals("", sheet.get(theCell));
	}

	/**
	 * Test5 : You can retrieve from the Sheet the literal value for editing
	 */
	@Test
	public void testThatWeHaveAccessToCellLiteralValuesForEditing() {
		final String theCell = "A21";

		sheet.put(theCell, "Some string");
		assertEquals("Some string", sheet.getLiteral(theCell));
		assertEquals("Some string", sheet.get(theCell));

		sheet.put(theCell, " 1234 ");
		assertEquals(" 1234 ", sheet.getLiteral(theCell));
		assertEquals("1234", sheet.get(theCell));

		sheet.put(theCell, "=7"); // Foreshadowing formulas:)
		assertEquals("=7", sheet.getLiteral(theCell));
	}

	/**
	 * *** TDD PART 2 ***
	 */

	/**
	 * Test1 : Not a formula spec but a string because of space in front
	 */
	@Test
	public void testFormulaSpec() {
		sheet.put("B1", " =7"); // note leading space
		assertEquals("Not a formula", " =7", sheet.get("B1"));
		assertEquals("Unchanged", " =7", sheet.getLiteral("B1"));
	}

	/**
	 * Test2 : Formula, differentiate the value from the literal in a formula
	 */
	@Test
	public void testConstantFormula() {
		sheet.put("A1", "=7");
		assertEquals("Formula", "=7", sheet.getLiteral("A1"));
		assertEquals("Value", "7", sheet.get("A1"));
	}

	/**
	 * Test3.1 : Test a new feature - Formula multiply
	 */
	@Test
	public void testMultiply() {
		sheet.put("A1", "=2*3");
		assertEquals("Times", "6", sheet.get("A1"));
	}

	/**
	 * Test3.1 : Test a new feature - Formula add
	 */
	@Test
	public void testAdd() {
		sheet.put("A1", "=2+3");
		assertEquals("Plus", "5", sheet.get("A1"));
	}

	/**
	 * Test4 : Test if the parentheses are open/close (one layer)
	 */
	@Test
	public void testParentheses() {
		sheet.put("A1", "=(7)");
		assertEquals("Parends", "7", sheet.get("A1"));
		assertEquals("Parends", "=(7)", sheet.getLiteral("A1"));
	}

	/**
	 * Test5 : Test if parentheses are open and close in several layer.
	 */
	@Test
	public void testDeepParentheses() {
		sheet.put("A1", "=((((10))))");
		assertEquals("Parends", "10", sheet.get("A1"));
		assertEquals("Parends", "=((((10))))", sheet.getLiteral("A1"));
	}

	/**
	 * Test6 : Test if you can multiply several times in a formula
	 */
	@Test
	public void testMultiplyMultiple() {
		final Sheet sheet = new Sheet();
		sheet.put("A1", "=2*3*4");
		assertEquals("Times", "24", sheet.get("A1"));
	}

}
