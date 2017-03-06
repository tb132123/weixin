package com.leiyu.service;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.sdk.msg.out.News;

public class NewsService {
	
	public void add_news(String name,String url,String picurl){
		Record news=new Record();
		news.set("title", name).set("web_url", url).set("image_url", picurl);
		Db.save("news", news);
	}
	
	
	public void update_news(int id,String name,String url,String picurl){
		Record news=Db.findById("news", id);
		news.set("title", name).set("web_url", url).set("image_url", picurl);
		Db.update("news", news);;
	}
	
	public Record find_news(int id){
		Record record = Db.findFirst("select * from news where id="+id);
		return record;
	}
	
	public List<Record> list_news(){
		List<Record> news = Db.find("select * from news");
		return news;
	}
	
	public List<News> get_mynews(){
		List<Record> news = this.list_news();
		List<News> mynews=new ArrayList<>();
		
		for(int i=0;i<news.size();i++){
			News n=new News();
			n.setUrl(news.get(i).getStr("web_url"));
			n.setPicUrl(news.get(i).getStr("image_url"));
			n.setTitle(news.get(i).getStr("title"));
			mynews.add(n);
		}
		
		return mynews;
	}
	
	public void delete_news(int id){
		Record re=new Record();
		re.set("id", id);
		Db.delete("news", re);
	}
}
