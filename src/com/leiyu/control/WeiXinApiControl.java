package com.leiyu.control;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MenuApi;
import com.jfinal.weixin.sdk.api.MessageApi;
import com.jfinal.weixin.sdk.api.UserApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.sdk.utils.JsonUtils;

public class WeiXinApiControl extends ApiController{
	private String str2="";
	public void index(){
		render("/api/index.html");
	}

	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		ApiConfig ap=new ApiConfig();
		ap.setAppId("wx2506f9bfa04e81ff");
		ap.setToken("JavaJfinal");
		ap.setAppSecret("69b60f7aca54f806000bb7378fed98b5");
		ap.setEncryptMessage(false);
		ap.setEncodingAesKey("P7lZ1cZ99gBq9AfNjyaPdh0eN2lIa21dgdSSCheEyyK");
		return ap;
	}
	
	/**
	  * ��ȡ���ںŲ˵�
	  */
	  public void getMenu() {
	    ApiResult apiResult = MenuApi.getMenu();
	    if (apiResult.isSucceed())
	      renderText(apiResult.getJson());
	    else
	      renderText(apiResult.getErrorMsg());
	    }
	     
	    /**
	    * ��ȡ���ںŹ�ע�û�
	    */
	    public void getFollowers() {
	      ApiResult apiResult = UserApi.getFollows();
	      renderText(apiResult.getJson());
	    }
	    
	    //菜单自定义
	    public void createMenu(){
	    	
	    	
	    	try{
	    	FileInputStream fi=new FileInputStream("C:/menu.txt");
	    	
	    	str2=IOUtils.toString(fi);
	    	fi.close();
	    	}catch(Exception e){}
	    	
	    	ApiResult result=MenuApi.createMenu(str2);
	    	if(result.isSucceed()){
	    		renderText(result.getJson());
	    	}else{
	    		renderText(result.getErrorMsg());
	    	}
	    }
	    //高级群发
	    public void send_msg(){
	    	Map<String,String>mp1=new HashMap<>();
	    	
	    	mp1.put("thumb_media_id", "1111");
	    	mp1.put("title", "微信开发");
	    	mp1.put("content", "hhjhjhjjjjk68182812");
	    	
	    	
	    	
	    	List<Map>list=new ArrayList<>();
	    	
	    	list.add(mp1);
	    	Map<String ,List> maps=new HashMap<>();
	    	maps.put("articles", list);
	    	String json=JsonUtils.toJson(maps);
	    	json="{"+json+"}";
	    	ApiResult result=MessageApi.sendAll(json);
	    	
	    	if(result.isSucceed()){
	    		renderText(result.getJson());
	    	}else{
	    		renderText(result.getErrorMsg());
	    	}
	    }

}
