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
	  static String songsname = "������";
	  static String zhuanjiname = "���Ǹ���";
	  public static int[] photo = new int[]{R.drawable.xiaotubiao,R.drawable.xiaotubiao,R.drawable.xiaotubiao};
	  static String[] name = new String[]{"���֣�"+ songsname,"ר�� ��"+ zhuanjiname,"���Ƶ�����̨"};
	uiassit(){
		
	}
	
	public static void disappear(View view)
	{
		 view.setVisibility(view.INVISIBLE);
	}
	
	public  static void show(View view){
		view.setVisibility(view.VISIBLE);
	}
	

	//listview ������Դ���
	public  static List<HashMap<String,Object>> create(){
		
		
		
		for(int i = 0 ; i < 3 ; i++){
			HashMap<String,Object> listnei = new HashMap<String,Object>();
		 
			listnei.put("content", name[i]);
			
			listcontent.add(listnei);
		}
		
		return  listcontent;
		
	}
	//�赥listview������Դ
	
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
	//��������autocompletetextview������Դ
    
	private static List<String> textview = new ArrayList<String>(); 
	 private static String[] name3= new String[]{"sdf","ddd","rrr","wee"};
     public static List<String> createtextview(){
		  for(int i = 0 ; i < 4 ; i++){
			   textview.add(name3[i]);
		  }
		 	return textview;
     }
}
	

