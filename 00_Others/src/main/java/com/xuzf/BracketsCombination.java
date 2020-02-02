package com.xuzf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/26
 * Time: 10:47 PM
 * Description: No Description
 */
public class BracketsCombination {
    public static List<String> list = new ArrayList<>();

    public static void main( String[] args ) {
        String result="";
        _gen(0,0,3,result);

        System.out.println(list);
    }
    public static void _gen(int leftCount,int rightConut,int count,String result){
        if(rightConut==count){//如果左括号和右括号都匹配完了，直接返回
            list.add(result);
            return ;
        }

        if(leftCount<count){
            _gen(leftCount+1,rightConut,count,result+"(");
        }
        if(rightConut<count&&rightConut<leftCount){
            _gen(leftCount,rightConut+1,count,result+")");
        }
    }
}
