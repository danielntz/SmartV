package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jerome.weibo.R;

import android.app.Activity;
import android.view.View;

public class uiassit  {
      
	
	  private static  List<HashMap<String,Object>> listcontent = new ArrayList<HashMap<String,Object>>();
	  static String songsname = "辛晓琪";
	  static String zhuanjiname = "我是歌手";
	  public static int[] photo = new int[]{R.drawable.xiaotubiao,R.drawable.xiaotubiao,R.drawable.xiaotubiao};
	  static String[] name = new String[]{"歌手："+ songsname,"专辑 ："+ zhuanjiname,"相似单曲电台"};
	uiassit(){
		
	}
	
	public static void disappear(View view)
	{
		 view.setVisibility(view.INVISIBLE);
	}
	
	public  static void show(View view){
		view.setVisibility(view.VISIBLE);
	}
	

	//listview 的数据源填充
	public  static List<HashMap<String,Object>> create(){
		
		
		
		for(int i = 0 ; i < 3 ; i++){
			HashMap<String,Object> listnei = new HashMap<String,Object>();
		 
			listnei.put("content", name[i]);
			
			listcontent.add(listnei);
		}
		
		return  listcontent;
		
	}
	//歌单listview的数据源
	
	 private static List<HashMap<String,Object>> qqq = new ArrayList<HashMap<String,Object>>();      
	 static String  name1[] = new String[]{"ddd","aaa","sdf","sdfsdf"};
	 static String  name2[]  = new String[]{"eee","dddd","ssss","dse"};
	public  static List<HashMap<String,Object>> creategedan(){
		
		  for(int i = 0 ; i < 4; i++){
			   HashMap<String,Object> ok = new HashMap<String,Object>();
			    ok.put("geming", name1[i]);
			    ok.put("geshouming", name2[i]);
			    qqq.add(ok);
		  }
		return  qqq;
	}
	//搜索栏的autocompletetextview的数据源
    
	private static List<String> textview = new ArrayList<String>(); 
	 private static String[] name3= new String[]{"sdf","ddd","rrr","wee"};
     public static List<String> createtextview(){
		  for(int i = 0 ; i < 4 ; i++){
			   textview.add(name3[i]);
		  }
		 	return textview;
     }
}
	

