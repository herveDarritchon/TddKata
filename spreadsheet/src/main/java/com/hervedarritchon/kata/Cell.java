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
	 * @param cellLiteral
	 *            the cellLiteral to set
	 */
	public void setCellLiteral(final String cellLiteral) {
		this.cellLiteral = cellLiteral;
	}

	/**
	 * @param cellValue
	 *            the cellValue to set
	 */
	public void setCellValue(final String cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * @param cellValue
	 * @param cellLiteral
	 */
	public Cell(final String cellValue) {
		super();
		this.cellValue = formatValue(cellValue);
		this.cellLiteral = cellValue;
	}

	/**
	 * 
	 * @param value
	 */
	private String formatValue(final String value) {
		String result = value;

		if (isCellNumeric(value)) {
			result = StringUtils.deleteWhitespace(value);
		} else if (isCellFormula(value)) {
			result = compute(StringUtils.removeStart(value, "="));

		}
		return result;
	}

	/**
	 * 
	 * Compute the value from a formula. Operator : *
	 * 
	 * @param formula
	 * @return
	 */
	private String compute(final String formula) {
		final String[] members = StringUtils
				.splitByWholeSeparator(formula, "*");
		int result = 1;
		for (final String member : members) {
			result *= Integer.parseInt(member);
		}
		return Integer.toString(result);
	}

	/**
	 * 
	 * Test if a Cell is a formula.
	 * 
	 * @param value
	 * @return
	 */
	private boolean isCellFormula(final String value) {
		return StringUtils.startsWith(value, "=");
	}

	/**
	 * 
	 * Test if a Cell is a numeric.
	 * 
	 * @param value
	 * @return
	 */
	private boolean isCellNumeric(final String value) {
		return StringUtils.isNumeric(StringUtils.deleteWhitespace(value));
	}

	/**
	 * @return the cellLiteral
	 */
	public String getCellLiteral() {
		return cellLiteral;
	}

}
