/**
 * 
 */
package com.hervedarritchon.math;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.Lists;

/**
 * @author ahdi7503
 * 
 */
public class Math {

	static private HashMap<String, MathOperator> operatorMap = new HashMap<String, MathOperator>();

	// Parentheses, Exponents, Multiplication, Division, Addition, Subtraction
	static private ArrayList<String> precedenceList = Lists.newArrayList("(",
			"^", "*", "/", "+", "-");

	/**
	 * @return the operatorMap
	 */
	public static HashMap<String, MathOperator> getOperatorMap() {
		return operatorMap;
	}

	/**
	 * @param operatorMap
	 *            the operatorMap to set
	 */
	public static void setOperatorMap(
			final HashMap<String, MathOperator> operatorMap) {
		Math.operatorMap = operatorMap;
	}

	/**
	 * @return the precedenceList
	 */
	public static ArrayList<String> getPrecedenceList() {
		return precedenceList;
	}

	/**
	 * @param precedenceList
	 *            the precedenceList to set
	 */
	public static void setPrecedenceList(final ArrayList<String> precedenceList) {
		Math.precedenceList = precedenceList;
	}

	/**
	 * 
	 * @param operator1
	 *            the operator to test
	 * @param operator2
	 *            the operator reference
	 * @return
	 */
	public static boolean checkPrecedence(final String operator1,
			final String operator2) {
		int precedence = 0;

		if (operatorMap.isEmpty()) {
			Math.fillOperatorMap();
		}

		precedence = (Math.precedenceList.indexOf(operator2) - Math.precedenceList
				.indexOf(operator1));
		return (precedence > 0);
	}

	private static void fillOperatorMap() {
		Math.operatorMap.put("^", new MathOperator("multiply",
				OperatorAssociative.RIGHTASSOCIATIVE));
		Math.operatorMap.put("*", new MathOperator("multiply",
				OperatorAssociative.LEFTASSOCIATIVE));
		Math.operatorMap.put("/", new MathOperator("multiply",
				OperatorAssociative.LEFTASSOCIATIVE));
		Math.operatorMap.put("+", new MathOperator("multiply",
				OperatorAssociative.LEFTASSOCIATIVE));
		Math.operatorMap.put("-", new MathOperator("multiply",
				OperatorAssociative.LEFTASSOCIATIVE));
	}
}
