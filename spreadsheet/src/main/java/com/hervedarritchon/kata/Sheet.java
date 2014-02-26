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

	private Map<String,Cell> cells = new HashMap<String,Cell>();
	
	/**
	 * @return the cells
	 */
	public Map<String,Cell> getCells() {
		return cells;
	}

	/**
	 * @param cells the cells to set
	 */
	public void setCells(Map<String,Cell> cells) {
		this.cells = cells;
	}

	/**
	 * @return the cells
	 */

	
	public String get(String theCell) {
		return this.getCells().containsKey(theCell) ? this.getCells().get(theCell).getCellValue() : "";
	}
	
	public void put(String theCell, String value) {
		if (this.getCells().containsKey(theCell)) {
			this.getCells().remove(theCell);
		}
		this.getCells().put(theCell, new Cell(value));			
	}
}
