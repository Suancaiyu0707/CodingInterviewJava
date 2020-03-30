package com.xuzf;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 */
public class ArraySortByZ {

    public static String convert(String sources, int numRows){

            if(sources==null||"".equals(sources)){
                return sources;
            }

            if (numRows == 1) return sources;

            int len = sources.length();
            boolean flag = false;

            String [][] strings = new String[numRows][len/2+1];
            int row=0;
            int col=0;
            for(int i=0;i<len;i++){
                char current = sources.charAt(i);
                if(!flag){
                    strings[row][col]=new String(new char[]{current});
                    if(row==numRows-1){
                        flag=true;
                        row--;
                        col++;
                        continue;
                    }
                    row++;
                }else{
                    strings[row][col]=new String(new char[]{current});
                    if(row==0){
                       flag=false;
                       row++;
                       continue;
                    }
                    row--;
                    col++;
                }
            }
            String result = "";
            for(String[] line:strings){
                for(String s:line){
                    if(s==null||"".equals(s)){
                        continue;
                    }
                    result=result+s;
                }
            }
            return result;
    }

    public static void main(String[] args) {
//        String result = convert("LEETCODEISHIRING",3);
        String result2 = convert("A",3);
        System.out.println(result2);
    }
}
