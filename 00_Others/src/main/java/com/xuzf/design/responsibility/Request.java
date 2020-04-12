package com.xuzf.design.responsibility;

import lombok.Data;

import java.util.Date;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:40 上午
 * @Description
 * 请求
 */
@Data
public class Request {
    /***
     * 申请人
     */
    private String applyer;
    /***
     * 申请类型
     */
    private String type;
    /***
     * 申请内容
     */
    private String content;
    /***
     * 申请值
     */
    private int number;
    /***
     * 申请日期
     */
    private Date date;
}
