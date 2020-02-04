package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 11:32 PM
 * Description: No Description
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 */
public class RegularExpressionsMatching {
    /***
     *
     * @param str 字符数组
     * @param pattern 模式
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    /**
     *
     * @param str 字符串
     * @param indexOfStr 字符串上匹配的索引
     * @param pattern 模式
     * @param indexOfPattern 模式上字符的索引
     * @return
     */
    private boolean matchCore(char[] str, int indexOfStr,
                              char[] pattern, int indexOfPattern) {
        //遍历到最后了
        if (indexOfStr == str.length && indexOfPattern == pattern.length) {
            return true;
        }
        if (indexOfStr < str.length && indexOfPattern == pattern.length) {
            return false;
        }

        /****
         * 如果某个index的下一位是*
         *      a、
         *          如果模式中当前的indexOfPattern上的字符和indexOfStr上的字符不匹配，则 *可以代表0，因此则向后indexOfPattern移动两位继续匹配：
         *          return matchCore(str, indexOfStr, pattern, indexOfPattern + 2)
         *      b、如果如果模式中当前的indexOfPattern上的字符和indexOfStr上的字符匹配，则有两种情况，比如：
         *              假如pattern：a*b ，那么无论是aa或者a都匹配a*
         *          aab或者ab
         *          1)检查字符串的下一个字符是否也匹配了*前面的那个字符，这个时候*可以代表>1。因为可能字符串是aab
         *              所以indexOfStr+1，indexOfPattern不变，继续用第二个字符'a'去匹配模式中的a*
         *              matchCore(str, indexOfStr + 1, pattern, indexOfPattern)
         *          2) 检查字符串的下一个字符是否也匹配了*后面的的那个字符，这个时候*代表1，因为可能字符串是ab
         *              所以indexOfStr+1，indexOfPattern+2，继续用第二个字符'b'去匹配模式中的第三个字符b
         *
         *
         */
        //当前要检查的字符的后一位是*
        if (indexOfPattern < pattern.length-1 //可以保证indexOfPattern不是最后一位，这样indexOfPattern + 1就不会数组越界
                && pattern[indexOfPattern + 1] == '*') {
            if ((indexOfStr < str.length && pattern[indexOfPattern] == '.')
                    || (indexOfStr < str.length && pattern[indexOfPattern] == str[indexOfStr])) {
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2)//*代表0
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern)//*代表>1
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2);//*代表1
            } else {
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2);
            }
        }
        if (indexOfStr < str.length
                && (
                        pattern[indexOfPattern] == str[indexOfStr]
                                || pattern[indexOfPattern] == '.'
                    )
        ) {
            return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 1);
        }
        return false;
    }

    // ==========测试代码=========
    void test(String testName, char[] str, char[] pattern, boolean expected) {
        System.out.print(testName + ":");
        if (match(str, pattern) == expected)
            System.out.println("passed!");
        else
            System.out.println("failed!");
    }

    void test1() {
        char[] str = {};
        char[] pattern = { '.' };
        test("test1", str, pattern, false);
    }

    void test2() {
        char[] str = {};
        char[] pattern = { '.', '*' };
        test("test2", str, pattern, true);
    }

    void test3() {
        char[] str = { 'a','b', 'b' };
        char[] pattern = { '.', '*' };
        test("test3", str, pattern, true);
    }

    void test4() {
        char[] str = {};
        char[] pattern = {};
        test("test4", str, pattern, true);
    }

    void test5() {
        char[] str = null;
        char[] pattern = null;
        test("test5", str, pattern, false);
    }

    void test6() {
        char[] str = { 'a', 'b', 'b' };
        char[] pattern = { 'a', 'b', 'b', '*', 'b' };
        test("test6", str, pattern, true);
    }

    void test7() {
        char[] str = { 'a' };
        char[] pattern = { 'a', 'a', '*' };
        test("test7", str, pattern, true);
    }

    public static void main(String[] args) {
        RegularExpressionsMatching demo = new RegularExpressionsMatching();
//        demo.test1();
//        demo.test2();
        demo.test3();
//        demo.test4();
//        demo.test5();
//        demo.test6();
//        demo.test7();
    }
}
