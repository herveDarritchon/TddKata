/**
 * 
 */
package com.hervedarritchon.math;

/**
 * @author ahdi7503
 * 
 */
public class MathOperator {

	private String name = "";
	private OperatorAssociative associative = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the associative
	 */
	public OperatorAssociative getAssociative() {
		return associative;
	}

	/**
	 * @param associative
	 *            the associative to set
	 */
	public void setAssociative(final OperatorAssociative associative) {
		this.associative = associative;
	}

	/**
	 * @param name
	 * @param associative
	 */
	public MathOperator(final String name, final OperatorAssociative associative) {
		super();
		this.name = name;
		this.associative = associative;
	}

}
