package com.learning.test_drools;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Fact1 implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.Integer iden;
	private java.lang.Integer quantifier1;
	private java.lang.String description;

	public Fact1() {
	}

	public java.lang.Integer getIden() {
		return this.iden;
	}

	public void setIden(java.lang.Integer iden) {
		this.iden = iden;
	}

	public java.lang.Integer getQuantifier1() {
		return this.quantifier1;
	}

	public void setQuantifier1(java.lang.Integer quantifier1) {
		this.quantifier1 = quantifier1;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public Fact1(java.lang.Integer iden, java.lang.Integer quantifier1,
			java.lang.String description) {
		this.iden = iden;
		this.quantifier1 = quantifier1;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Fact1{" +
				"iden=" + iden +
				", quantifier1=" + quantifier1 +
				", description='" + description + '\'' +
				'}';
	}
}