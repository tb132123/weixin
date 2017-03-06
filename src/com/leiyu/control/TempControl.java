package com.leiyu.control;

import com.jfinal.core.Controller;
import com.leiyu.service.TempService;

public class TempControl extends Controller{
	private TempService ser=new TempService();
	
	public void index(){
		renderJson(ser.get_temp());
	}
	
	public void show(){
		renderJsp("/test.jsp");
	}
	
	public void sub_temp(){
		
	}
}
