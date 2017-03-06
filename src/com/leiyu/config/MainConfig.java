package com.leiyu.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.leiyu.control.NewControl;
import com.leiyu.control.TempControl;
import com.leiyu.control.WeiXinApiControl;
import com.leiyu.control.WeiXinMsgControl;

public class MainConfig extends JFinalConfig{
	
	

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		
		me.setDevMode(true);
		ApiConfigKit.setDevMode(me.getDevMode());
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/msg", WeiXinMsgControl.class);
		me.add("/api", WeiXinApiControl.class);
		me.add("/news", NewControl.class);
		me.add("/temp",TempControl.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://flsg9o4m.694.dnstoo.com:3306/nutz?characterEncoding=utf8";
		C3p0Plugin cp=new C3p0Plugin(url, "nutz_f", "tb132123");
		cp.setInitialPoolSize(10);
		me.add(cp);
		ActiveRecordPlugin arp=new ActiveRecordPlugin(cp);
		
		me.add(arp);
		arp.addMapping("news", Mynews.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 8888, "/", 10);
	}

}
