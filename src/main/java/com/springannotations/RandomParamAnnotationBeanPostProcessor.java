package com.springannotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RandomParamAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("postProcessBeforeInitialization");
       if (beanName.equals("RandomParam"))
       {
           System.out.println("postProcessBeforeInitialization in");
           Class randomParamClass = bean.getClass();

           for (Field field:randomParamClass.getDeclaredFields()) {
               if (field.isAnnotationPresent(RandomParam.class)){
                   RandomParam randomParam = field.getAnnotation(RandomParam.class);
                   String methodName = "set" +
                           field.getName().substring(0, 1).toUpperCase() +
                           field.getName().substring(1);
                   Method method = null;
                   try {
                       method = randomParamClass.getMethod(methodName);
                   } catch (NoSuchMethodException e) {
                       e.printStackTrace();
                   }
                   field.setAccessible(true);
                  // ReflectionUtils.invokeMethod(method,field, getRandom(randomParam.min(), randomParam.max()));
                   ReflectionUtils.setField(field, bean, getRandom(randomParam.min(), randomParam.max()));
               }

           }
           }
       return bean;
       }

       private int getRandom(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
       }


    }



