package com.myannotations;

public class TestClass {
    @MyAnnotation
    private double field1 = 1.1111;
    @MyAnnotation (rounded2 = false)
    private float field2 = 2.2222f;
    @MyAnnotation
    private double field3 = 3.3333;

    public double getField1() {
        return field1;
    }

    public double getField3() {
        return field3;
    }

    public float getField2() {
        return field2;
    }
}
