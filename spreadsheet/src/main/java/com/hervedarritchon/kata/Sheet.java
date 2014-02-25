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

	private Map<String,String> cells = new HashMap<String,String>();
	
	/**
	 * @return the cells
	 */
	public Map<String,String> getCells() {
		return cells;
	}

	/**
	 * @param cells the cells to set
	 */
	public void setCells(Map<String,String> cells) {
		this.cells = cells;
	}
	
	public String get(String theCell) {
		return this.cells.containsKey(theCell) ? this.cells.get(theCell) : "";
	}
	
	public void put(String theCell, String value) {
		if (this.cells.containsKey(theCell)) {
			this.cells.remove(theCell);
		}
		this.cells.put(theCell, value);			
	}
}
