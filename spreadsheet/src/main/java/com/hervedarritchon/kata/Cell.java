/**
 * 
 */
package com.hervedarritchon.kata;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ahdi7503
 * 
 */
public class Cell {

	private String cellValue;
	private String cellLiteral;

	/**
	 * @return the cellValue
	 */
	public String getCellValue() {
		return cellValue;
	}

	/**
	 * @param cellValue
	 *            the cellValue to set
	 */
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * @return the cellLiteral
	 */
	public String getCellLiteral() {
		return cellLiteral;
	}

	/**
	 * @param cellLiteral
	 *            the cellLiteral to set
	 */
	public void setCellLiteral(String cellLiteral) {
		this.cellLiteral = cellLiteral;
	}

	/**
	 * @param cellValue
	 * @param cellLiteral
	 */
	public Cell(String cellValue) {
		super();
		this.cellValue = formatValue(cellValue);
		this.cellLiteral = cellValue;
	}

	/**
	 * 
	 * @param value
	 */
	private String formatValue(String value) {
		if (StringUtils.isNumeric(StringUtils.deleteWhitespace(value))) {
			value=StringUtils.deleteWhitespace(value);
		}
		return value;
	}
	
}
