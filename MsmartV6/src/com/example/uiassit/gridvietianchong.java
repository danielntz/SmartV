package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jerome.weibo.R;

import android.widget.GridView;
import android.widget.SimpleAdapter;

public class gridvietianchong {
       
	   static int[] tupian  =  new int[]{R.drawable.up,R.drawable.down,R.drawable.cancel,R.drawable.sf,R.drawable.liuyan};
	   static String[] hanzi = new String[]{"上传","下载","删除","列表","留言"};
	
	
	  public gridvietianchong() {
		// TODO Auto-generated constructor stub
	}
	
	  public static List<HashMap<String,Object>> deploy(){
			
		  List<HashMap<String,Object>> photo = new ArrayList<HashMap<String,Object>>();
			for(int i= 0 ; i < 5 ;i++){
				HashMap<String,Object> xiaophoto = new HashMap<String, Object>();
				xiaophoto.put("tupain", tupian[i]);
				xiaophoto.put("introduce", hanzi[i]);
				photo.add(xiaophoto);
			}
			return photo;
	  }
	  
}  
