package com.leiyu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.sdk.utils.JsonUtils;
import com.leiyu.config.Temperature;

public class TempService {
	public String get_temp(){
		List<Temperature> tt=new ArrayList<>();
		List<Record> list = Db.find("select * from temp order by id");
		for(int i=0;i<list.size();i++){
			Temperature t=new Temperature();
			t.setTime(list.get(i).get("time").toString());
			t.setTemp(list.get(i).get("temp").toString());
			tt.add(t);
		}
		Collections.sort(tt, new Comparator<Temperature>() {

			@Override
			public int compare(Temperature o1, Temperature o2) {
				return new Float(o1.getTime()).compareTo(new Float(o2.getTime()));
			}

		});
		return JsonUtils.toJson(tt);
	}
}	
