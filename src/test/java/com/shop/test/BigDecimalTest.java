package com.shop.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by admin on 2020/5/9.
 */
public class BigDecimalTest {

    @Test
    public void test1(){
        //精度缺失
        System.out.print(0.01+0.1+"\n");
        System.out.print(0.11-0.1+"\n");
        System.out.print(0.01*0.1+"\n");
        System.out.print(0.01/0.1+"\n");
    }

    @Test
    public void test2(){
        //精度缺失
        BigDecimal b1 = new BigDecimal(0.01);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.print(b1.add(b2)+"\n");
    }

    @Test
    public void test3(){
        //正确
        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.print(b1.add(b2)+"\n");
    }
}
