package com.myannotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Class cTest = TestClass.class;
       TestClass testClass = new TestClass();
        for (Field field: cTest.getDeclaredFields()) {
              MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
            {
                String methodName = "get" +
                        field.getName().substring(0, 1).toUpperCase() +
                        field.getName().substring(1);
                Method method = cTest.getMethod(methodName);
                if (myAnnotation.rounded2()) {
                   // System.out.println((double) ((int)((double)method.invoke(testClass)*100))/100);
                    System.out.printf("%.2f%n",(double)method.invoke(testClass));

                }
                else System.out.println(method.invoke(testClass));
            }

        }
    }
}
