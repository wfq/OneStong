package com.onestong.app.domain;

public class Constant {
	//Btn的标识  
    public static final int BTN_FLAG_EVENT = 0x01;  
    public static final int BTN_FLAG_YIXIN = 0x01 << 1;  
    public static final int BTN_FLAG_FOUND = 0x01 << 2;  
    public static final int BTN_FLAG_ME = 0x01 << 3;  
      
    //Fragment的标识  
    public static final String FRAGMENT_FLAG_EVENT = "事件";   
    public static final String FRAGMENT_FLAG_YIXIN = "易信";   
    public static final String FRAGMENT_FLAG_FOUND = "发现";   
    public static final String FRAGMENT_FLAG_ME = "我";   
    public static final String FRAGMENT_FLAG_SIMPLE = "simple";
}
