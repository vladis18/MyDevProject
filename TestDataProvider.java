package com.hrms.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestDataProvider {
    SoftAssert softAssert = new SoftAssert();
    String[][] array = new String[1][1];

    @Test(dataProvider = "myDataProvider")
    public void datatProvider(String var, String var2) {
        System.out.println("Hello");
        //System.out.println(something);
        System.out.println(" var 1 " + var + " var 2 " + var2);
        System.out.println(" Hello we are doing Jenkins");
        System.out.println(" Another commit5");
    }

    @DataProvider
    public Object[][] myDataProvider() {
        Object var[][] = new Object[2][2];
        var[0][0] = "Hello1";
        var[0][1] = "Hello2";
        var[1][0] = "Hello3";
        var[1][1] = "Hello4";
//        var [0][4] = "Hello5";
//        var [0][5] = "Hello6";
        System.out.println("I am here");
        return var;
    }

    @Test(dataProvider = "myDataProvider2")
    public void datatProvider2(String var) {
        System.out.println("Hello");
        //System.out.println(something);
        System.out.println(" var 1 " + var);

    }


    @DataProvider
    public Object[] myDataProvider2() {
        Object var[] = new Object[2];
        var[0] = "Hello1";
        var[1] = "Hello2";
//        var [1][0] = "Hello3";
//        var [1][1] = "Hello4";
////        var [0][4] = "Hello5";
//        var [0][5] = "Hello6";
        System.out.println("I am here");
        return var;
    }

    @Test(dataProvider = "myDataProvider3")
    public void datatProvider3Caller(String var, String var2, String var3) {
        System.out.println("Hello");
        //System.out.println(something);
        System.out.println(" var 1 " + var + " var 2 " + var2+   " var 3"  + var3);

    }

    @DataProvider
    public Object[][]myDataProvider3() {
        Object var[][] = new Object[4][3];
        var[0][0]= "Hello1";
        var[0][1] = "Hello2";
        var[0][2] =" Iam the 3rd element ";
        var[1][0] = "Hello3";
        var[1][1] = "Hello4";
        var[1][2] =" Iam the 3rd element in the second row ";
        var[2][0] = "Hello5";
        var[2][1] = "Hello6";
        var[2][2] =" Iam the 3rd element in the 3rd row ";
        var[3] [0] = "Hello 3rd array 1";
        var[3][1]=" Hello 3rd array 2";
        var[3][2] =" Iam the 3rd element  int the 4th row ";
        return var;
    }
}