/**
 * 
 */
package com.hervedarritchon.kata;

/**
 * @author ahdi7503
 *
 */
public class Sheet {

	private String cellValue = "";

	/**
	 * @return the cellValue
	 */
	public String getCellValue() {
		return cellValue;
	}

	/**
	 * @param cellValue the cellValue to set
	 */
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	public String get(String string) {
		return this.cellValue;
	}
	
	public void put(String theCell, String value) {
		this.setCellValue(value);
	}
	
}
