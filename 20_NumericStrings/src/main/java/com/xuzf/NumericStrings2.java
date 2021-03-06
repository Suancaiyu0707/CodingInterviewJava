package com.xuzf;

import com.sun.tools.corba.se.idl.constExpr.BooleanOr;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 11:46 PM
 * Description: No Description
 *
 * // 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * // 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * // “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
public class NumericStrings2 {
    /*
     *  数字的基本格式为：(A.B E/e A) ,按顺序进行判断
     *  //A代表带符号整数，B代表不带符号整数
     *  小心：时刻要注意数组越界问题！
     *
     *
     *  1、判断整数部分A,并记录A的范围索引
     *  2、判断A后，判断下一个字符是小数点或者E
     *      如果下一位是小数点，则份两种情况：
     *          小数点后面跟着数字，则小数点前面的A可以是数值，也可以为空
     *          小数点后面没跟着数字，则小数点前面的A必须是数值
     *  3、判断完小数点，判断E或者e,
     *      如果下一位是e的话，则前面是可以A.B或者A或者.B,但是必须有值，且是数值
     *      然后判断e之后必须全是数字
     */

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int[] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
        // 先判断A
        boolean isNumeric; //用于记录是否满足条件
        //判断整数部分是否以数值开头(带正负号的也可以)，比记录整数部份数字到哪个索引位置了
        isNumeric = isInteger(str, index);
        // 判断B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index)
                    || isNumeric; // .B和A.和A.B形式均可以
        }
        // 判断e后面的A，也就是整数的下一位是否不是e
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            //判断e后面是不是包含整数，如果出现e的话，前面必须有数值，不管是AeB还是.AeB
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }


    /**
     * 判断这个数值是不是Integer整型开头(判断整数部分的)
     * @param str 目标字符串
     * @param index 当前检查字符串的索引位的字符，从0开始
     * @return
     */
    private boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }

    /***
     * 无符号的检查整型部分，每一位必须是0-9之间的字符
     * 如果从index位置开始包含连续的数字，则返回true,否则返回false
     * @param str
     * @param index
     * @return
     */
    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start) {//如果只要有一位不是0-9的话（.和e也不算），则肯定不是普通的整型
            return true;
        }else {
            return false;
        }
    }


    // =======测试代码=========
    void test(String testName, char[] str, boolean expected) {
        System.out.print(testName + "：");
        if (isNumeric(str) == expected)
            System.out.println(" passed!");
        else
            System.out.println(" failed!");
    }

    void test1() {
        char[] str = null;
        test("test1", str, false);
    }

    void test2() {
        char[] str = {};
        test("test2", str, false);
    }

    void test3() {
        String string ="e3";
        char[] str=string.toCharArray();
        test("test3", str, false);
    }

    void test4() {
        String string ="3e1.2";
        char[] str=string.toCharArray();
        test("test4", str, false);
    }

    void test5() {
        String string ="e3";
        char[] str=string.toCharArray();
        test("test5", str, false);
    }

    void test6() {
        String string ="1.2e3";
        char[] str=string.toCharArray();
        test("test6", str, true);
    }

    void test7() {
        String string ="-.2e3";
        char[] str=string.toCharArray();
        test("test7", str, true);
    }

    void test8() {
        String string ="-.2e-3";
        char[] str=string.toCharArray();
        test("test8", str, true);
    }

    void test9() {
        String string ="1.e-3";
        char[] str=string.toCharArray();
        test("test9", str, true);
    }

    void test10() {
        String string ="1.";
        char[] str=string.toCharArray();
        test("test10", str, true);
    }

    void test11() {
        String string =".2";
        char[] str=string.toCharArray();
        test("test11", str, true);
    }

    void test12() {
        String string ="12e3";
        char[] str=string.toCharArray();
        test("test12", str, true);
    }

    public static void main(String[] args) {
        NumericStrings2 demo = new NumericStrings2();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
        demo.test10();
        demo.test11();
        demo.test12();
    }
}
