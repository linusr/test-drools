package com.learning.test_drools;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Fact2 implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String iden;
	private java.lang.String label;
	private int quantifier1;
	private int quantifier2;
	private java.lang.String quantifier3;
	private java.lang.String idenAlt;

	public Fact2() {
	}

	public java.lang.String getIden() {
		return this.iden;
	}

	public void setIden(java.lang.String iden) {
		this.iden = iden;
	}

	public java.lang.String getLabel() {
		return this.label;
	}

	public void setLabel(java.lang.String label) {
		this.label = label;
	}

	public int getQuantifier1() {
		return this.quantifier1;
	}

	public void setQuantifier1(int quantifier1) {
		this.quantifier1 = quantifier1;
	}

	public int getQuantifier2() {
		return this.quantifier2;
	}

	public void setQuantifier2(int quantifier2) {
		this.quantifier2 = quantifier2;
	}

	public java.lang.String getQuantifier3() {
		return this.quantifier3;
	}

	public void setQuantifier3(java.lang.String quantifier3) {
		this.quantifier3 = quantifier3;
	}

	public java.lang.String getIdenAlt() {
		return this.idenAlt;
	}

	public void setIdenAlt(java.lang.String idenAlt) {
		this.idenAlt = idenAlt;
	}

	public Fact2(java.lang.String iden, java.lang.String label,
			int quantifier1, int quantifier2, java.lang.String quantifier3,
			java.lang.String idenAlt) {
		this.iden = iden;
		this.label = label;
		this.quantifier1 = quantifier1;
		this.quantifier2 = quantifier2;
		this.quantifier3 = quantifier3;
		this.idenAlt = idenAlt;
	}

}