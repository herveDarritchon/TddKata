/**
 * 
 */
package com.hervedarritchon.kata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ahdi7503
 * 
 */
public class Sheet {

	private Map<String, Cell> cells = new HashMap<String, Cell>();

	/**
	 * @return the cells
	 */

	public String get(final String theCell) {
		return this.getCells().containsKey(theCell) ? this.getCells()
				.get(theCell).getCellValue() : "";
	}

	/**
	 * @return the cells
	 */
	public Map<String, Cell> getCells() {
		return cells;
	}

	public Object getLiteral(final String theCell) {
		return this.getCells().containsKey(theCell) ? this.getCells()
				.get(theCell).getCellLiteral() : "";
	}

	public void put(final String theCell, final String value) {
		if (this.getCells().containsKey(theCell)) {
			this.getCells().remove(theCell);
		}
		this.getCells().put(theCell, new Cell(value));
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(final Map<String, Cell> cells) {
		this.cells = cells;
	}
}
