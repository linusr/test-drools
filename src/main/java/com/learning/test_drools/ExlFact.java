package com.learning.test_drools;

public class ExlFact {
    private String iden;
    private int quan1;
    private int rs1;

    @Override
    public String toString() {
        return "ExlFact{" +
                "quan1=" + quan1 +
                ", rs1=" + rs1 +
                '}';
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public int getQuan1() {
        return quan1;
    }

    public void setQuan1(int quan1) {
        this.quan1 = quan1;
    }

    public int getRs1() {
        return rs1;
    }

    public void setRs1(int rs1) {
        this.rs1 = rs1;
    }
}
