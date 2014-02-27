/**
 * 
 */
package com.hervedarritchon.kata;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hervedarritchon.math.MathExpression;

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
			final String formulaBody = StringUtils.removeStart(value, "=");
			final MathExpression formula = new MathExpression();
			result = formula.computeMathInfixExpression(formulaBody);

			// final List<String> blocks = splitFormula(formulaBody);
			// for (final String block : blocks) {
			// if (StringUtils.contains(block, "*")) {
			// result = computeMultiply(block);
			// } else if (StringUtils.contains(block, "+")) {
			// result = computeAdd(block);
			// } else {
			// result = block;
			// }
			// }
		}
		return result;
	}

	/**
	 * Split the formula in several block depending on the parentheses
	 * 
	 * @param formulaBody
	 * @return
	 */
	private List<String> splitFormula(final String formulaBody) {
		final List<String> result = new ArrayList<String>();
		result.add(cleanParentheses(formulaBody));
		return result;
	}

	/**
	 * Check if parentheses are open and close and delete them or return "".
	 * 
	 * @param formulaBody
	 * @return
	 */
	private String cleanParentheses(final String formulaBody) {
		int open = 0;
		for (int x = 0; x < open; x++) {
			if (formulaBody.charAt(x) == '(') {
				open++;
			} else if (formulaBody.charAt(x) == ')') {
				open--;
			}
		}
		if (open != 0) {
			return "";
		}
		return StringUtils.remove(StringUtils.remove(formulaBody, ")"), "(");
	}

	/**
	 * 
	 * Compute the value from a formula. Operator : *
	 * 
	 * @param formula
	 * @return
	 */
	private String computeMultiply(final String formula) {
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
	 * Compute the value from a formula. Operator : +
	 * 
	 * @param formula
	 * @return
	 */
	private String computeAdd(final String formula) {
		final String[] members = StringUtils
				.splitByWholeSeparator(formula, "+");
		int result = 0;
		for (final String member : members) {
			result += Integer.parseInt(member);
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
