package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 3:26 PM
 * Description: No Description
 *  输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 */
public class Print1ToMaxOfNDigits {


    public static boolean flag =true;
    public static void main( String[] args ) {
//        printToMaxOfNDigits(2);
//        printnew(2);
        printToMaxOfDigits2(3);
    }
    /***
     * 位数
     * @param digits
     */
    public static void print(int digits){
        char c[][]= new char[10][digits];
        for(int i=9;i>=0;i--){
            for(int j=0;j<digits;j++){
                c[i][j]=(char)i;
            }
        }

        System.out.println(c);
//        for(int i=digits-1;i>=0;i--){
//
//            for(int j=0;j<9;j++){
//                c[i]=(char)j;
//                System.out.println(new String(c));
//            }
//        }
    }

    /***
     *
     * @param n
     */
    public static void printToMaxOfNDigits(int n){
        if(n <= 0){
            System.out.println("输入的n没有意义");
            return;
        }
        //声明字符数组,用来存放一个大数
        char number[] = new char[n];
        for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
            number[i] = '0';
        }
        while(!incrementNumber(number)){ //如果大数自加，直到自溢退出
            printNumber(number); //打印大数
        }

    }

    //自加
    private static boolean incrementNumber(char[] number) {
        boolean isOverflow = false; //判断是否溢出
        int nTakeOver = 0; //判断是否进位
        int nLength = number.length;//最大位数
        //遍历数组number中的每一位
        for (int i = nLength - 1; i >= 0; --i) {
            //获得当前位的值。nTakeOver表示前一位是否进位，如果是的话，要加进来
            int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
            if (i == nLength - 1) { //判断是否是个位，如果是个位的话，进行个位+1
                ++nSum;
            }
            if (nSum >= 10) {//表示要进1
                if (i == 0) {//最后一位的话，则溢出
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);//恢复到0
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;//跳出当前循环，保证下次还是对各位进行累加
            }
        }
        return isOverflow;
    }

    //打印数字
    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /***
     * 打印1到最大的n位数的主方法
     * @param n
     */
    public static void printToMaxOfDigits2(int n) {
        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        //最高位，从0到9
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    /***
     * 利用递归实现1到最大的n位数的全排列
     * @param number char数组
     * @param n char的长度
     * @param index char中的下标索引
     */
    public static void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if(index == n - 1){//如果已经递归到个位了，则输出当前的值
            printNumber2(number);
            return;
        }
        //如果不是个位，则先遍历比当前位低1位的
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    //输出
    private  static void printNumber2(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }


    public static void printnew(int n){
        char number[] = new char[n];
        for (int j = 0; j < n; j++) {
            number[j] = 0+'0';
        }
        while(flag){
            inner:
            for(int i=1;i<=10;i++){
                if(i==10){//如果个位进一位，则可能会触发连锁递归，所以先递归，再打印
                    number[n-1]= (char) (0 + '0');;
                    tt(number,n-2);
                    if(flag){
                        System.out.println(new String(number));
                    }
                    break inner;
                }else{//如果个位没有进一位，则直接打印
                    number[n-1]=(char) (i + '0');
                    System.out.println(new String(number));
                }
            }
        }
    }
    public static void tt(char number[],int index){
        String oldstr = new String(new char[]{number[index]});
        int oldval = Integer.parseInt(oldstr);
        int newval = oldval+1;
        if(newval==10&&Integer.parseInt(new String(new char[]{number[0]}))==9){
            flag=false;
            return;
        }
        if(newval==10){
            number[index]=(char) (0 + '0');;
            tt(number,index+1);
        }else{
            number[index]=(char)(newval+'0');
        }
    }
}
