/**
 * 
 */
package com.hervedarritchon.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ahdi7503
 * 
 */
public class DefaultSheetTest {

	@Test
	public void testThatCellsAreEmptyByDefault() {
		Sheet sheet = new Sheet();
		assertEquals("", sheet.get("A3"));
		assertEquals("", sheet.get("ZX347"));
	}

}
