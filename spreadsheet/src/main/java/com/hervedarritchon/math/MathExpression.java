/**
 * Implement the shunting-yard algorithm to parse mathematical expressions specified in infix notation.
 * Produce output in Reverse Polish notation (RPN).
 * The algorithm was invented by Edsger Dijkstra and named the "shunting yard" algorithm because its operation resembles that of a railroad shunting yard.
 * Dijkstra first described the Shunting Yard Algorithm in the Mathematisch Centrum report MR 34/61.
 * Source Wikipedia : http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 * 
 */
package com.hervedarritchon.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ahdi7503
 * 
 */
public class MathExpression {
	static final String operator = "+-*/";
	static final String separator = "()[]";

	private String mathExpression = "";
	private String rpnExpression = "";
	private final LinkedList<String> outputQueue = new LinkedList<String>();
	private final Stack<String> operatorStack = new Stack<String>();

	/**
	 * Transform a String in an ArrayList of String. Each element of the array
	 * is a member of the math expression (number, parentheses, operator, ...).
	 * 
	 * @return
	 */
	private ArrayList<String> parseInfixNotation() {
		final ArrayList<String> parsedExpression = new ArrayList<String>();
		final String formula = this.mathExpression;
		String currentNumber = "";

		for (int index = 0; index < formula.length(); index++) {
			final Character currentChar = formula.charAt(index);
			if (Character.isDigit(currentChar)) {
				currentNumber = currentNumber + Character.toString(currentChar);
			} else if (MathExpression.operator.contains(Character
					.toString(currentChar))) {
				parsedExpression.add(currentNumber);
				currentNumber = "";
				parsedExpression.add(Character.toString(currentChar));
			} else if (Character.isWhitespace(currentChar)) {
				parsedExpression.add(currentNumber);
				currentNumber = "";
			}
		}

		if (currentNumber != "") {
			parsedExpression.add(currentNumber);
			currentNumber = "";
		}

		return parsedExpression;
	}

	/**
	 * Compute the RPN expression
	 * 
	 * @return
	 */
	private String evaluateRPN() {
		final Stack<Integer> values = new Stack<Integer>();

		for (final String token : StringUtils.split(rpnExpression, " ")) {
			int result = 0;
			if (StringUtils.isNumeric(token)) {
				values.push(Integer.parseInt(token));
			} else {
				if (token.contains("+")) {
					result = values.pop() + values.pop();
				} else if (token.contains("*")) {
					result = values.pop() * values.pop();
				}
				values.push(result);
			}
		}

		return Integer.toString(values.pop());
	}

	/**
	 * Transform the infix mathematical expression in a RPN expression
	 * 
	 * @param mathExpression
	 * @return
	 */
	public String computeMathInfixExpression(final String mathExpression) {
		this.mathExpression = mathExpression;
		final ArrayList<String> elements = parseInfixNotation();

		/**
		 * Construct the number queue and the operator stack
		 */
		for (final String element : elements) {
			if (StringUtils.isNumeric(element)) {
				this.outputQueue.add(element);
			} else if (isOperator(element)) {
				if (!this.operatorStack.isEmpty()) {
					if (hasPriority(element, this.operatorStack.peek())) {
						this.operatorStack.push(element);
					} else {
						this.outputQueue.add(this.operatorStack.pop());
						this.operatorStack.push(element);
					}
				} else {
					this.operatorStack.push(element);
				}
			} else if (MathExpression.separator.contains(element)) {
				// TODO add the process of separator to this algorithm
			}
		}

		while (!this.operatorStack.empty()) {
			this.outputQueue.add(this.operatorStack.pop());
		}

		for (final String token : this.outputQueue) {
			this.rpnExpression += token + " ";
		}

		return evaluateRPN();
	}

	/**
	 * 
	 * @param newOperator
	 * @param currentOperator
	 * @return
	 */
	private boolean hasPriority(final String newOperator,
			final String currentOperator) {
		return Math.checkPrecedence(newOperator, currentOperator);
	}

	/**
	 * Return true if the element is a mathematical operator (+*-/)
	 * 
	 * @param element
	 * @return
	 */
	private boolean isOperator(final String element) {
		return MathExpression.operator.contains(element);
	}
}
