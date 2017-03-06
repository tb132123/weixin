package com.leiyu.control;
import java.util.List;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.leiyu.service.NewsService;

public class NewControl extends Controller{
	private  static final NewsService ser=new NewsService();
	
	
	public void index(){
		List<Record> news = ser.list_news();
		this.setAttr("news", news);
		renderJsp("/index.jsp");
	}
	
	
	
	public void update(){
		
		String name=this.getPara("name");
		String Description=this.getPara("desc");
		int id=Integer.parseInt(Description);
		String PicUrl=this.getPara("PUrl");
		String Url=this.getPara("Url");
		ser.update_news(id, name, Url, PicUrl);
		redirect("/news");
	}
	
	public void edit(){
		int id=this.getParaToInt(0);
		
		Record my = ser.find_news(id);
		//News my=enews.get(id);
		this.setAttr("mynews", my);
		renderJsp("/edit.jsp");
		
	}
	
	public void add(){
		String name=this.getPara("name");
		String PicUrl=this.getPara("PUrl");
		String Url=this.getPara("Url");
		if(name!=""&&PicUrl!=""&&Url!=""){
			ser.add_news(name, Url, PicUrl);
			redirect("/news");
		}
		else{
			
		redirect("/news");
		
		}
	}
	
	public void delete(){
		int id=this.getParaToInt(0);
		ser.delete_news(id);
		redirect("/news");
	}
	
	
	
}
