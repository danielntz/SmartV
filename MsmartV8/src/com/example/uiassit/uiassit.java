package com.example.uiassit;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Mfunction.FunctionSDfilename;
import com.example.Mfunction.Functiongetfilename;
import com.jerome.weibo.R;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class uiassit  {
      
	
	  private static  List<HashMap<String,Object>> listcontent = new ArrayList<HashMap<String,Object>>();
	  static String songsname = "������";
	  static String zhuanjiname = "���Ǹ���";
	  public static int[] photo = new int[]{R.drawable.xiaotubiao,R.drawable.xiaotubiao,R.drawable.xiaotubiao};
	  static String[] name = new String[]{"���֣�"+ songsname,"ר�� ��"+ zhuanjiname,"���Ƶ�����̨"};
	public uiassit(){
		
	}
	
	public static void disappear(View view)
	{
		 view.setVisibility(view.INVISIBLE);
	}
	
	public  static void show(View view){
		view.setVisibility(view.VISIBLE);
	}
	//���ظ������б�
	public   static   List<String> huodegedan(){
		       
		   List<String> huodegedan = new ArrayList<String>();
	       File    file = Environment.getExternalStorageDirectory();
		   huodegedan = new FunctionSDfilename().getFilesname(file);
		  return  huodegedan;
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
	//�赥gedanlistview������Դ
	
	 private static List<HashMap<String,Object>> qqq = new ArrayList<HashMap<String,Object>>();      
	// static String  name1[] = new String[]{"ddd","aaa","sdf","sdfsdf"};
	// static String  name2[]  = new String[]{"eee","dddd","ssss","dse"};
	 private static List<String> songsnames = new ArrayList<String>();
	 private static List<String> songsgeshouname = new ArrayList<String>();
	 private static File file = Environment.getExternalStorageDirectory();
	  public  static List<HashMap<String,Object>> creategedan(){
		 //�����õ�ʵ�� 
		/*  for(int i = 0 ; i < 4; i++){
			   HashMap<String,Object> ok = new HashMap<String,Object>();
			    ok.put("geming", name1[i]);
			    ok.put("geshouming", name2[i]);
			    qqq.add(ok);
		  }*/
		songsnames = new FunctionSDfilename().getFilesname(file);
		songsgeshouname = new FunctionSDfilename().getFilesgeshouname(file);
		String[] name1 = new String[songsnames.size()];
		String[] name2 = new String[songsgeshouname.size()];
		for(int i = 0 ; i< songsnames.size();i++){
			   name1[i] = songsnames.get(i);
			   name2[i] = songsgeshouname.get(i);
			   HashMap<String,Object> ok = new HashMap<String ,Object>();
			   ok.put("geming", name1[i]);
			   ok.put("geshouming", name2[i]);
			   qqq.add(ok);
		}
		
		return  qqq;
	}
	//��������autocompletetextview������Դ
    
	private static List<String> textview = new ArrayList<String>(); 
	//��sd���е�����MP3�ļ��ӵ�����Դ��
    private  static  File str = Environment.getExternalStorageDirectory();
    private  static List<String>datasource = new FunctionSDfilename().getFilesname(str);
	private  static  int length = datasource.size();
    //private static String[] name3= new String[]{"sdf","ddd","rrr","wee","sdffff"};
     public static List<String> createtextview(){
		  for(int i = 0 ; i < length ; i++){
			   textview.add(datasource.get(i));
			   Log.i("TAG", datasource.get(i));
		  }
		 	return textview;
     }
     //��������autocompletetextview������Դ
     private static List<String> songslikename = new ArrayList<String>();
     public static List<String> createautolike(String name){
    	 
    	     songslikename.add(name) ; 
    	     return songslikename;
     }
     
    //ˢ��listview������
    private  static List<HashMap<String,Object>> updatedata = new ArrayList<HashMap<String,Object>>();
    public   static  List<HashMap<String,Object>>  Compare(String ziduan){
    	  File  file = Environment.getExternalStorageDirectory();
          List<String> pipeiname = new ArrayList<String>();
          List<String>  pipeigeshouname = new ArrayList<String>();
      	  pipeiname = new FunctionSDfilename().getFilesname(file);
      	  pipeigeshouname = new FunctionSDfilename().getFilesgeshouname(file);
    	  for(int i =0 ; i < pipeiname.size(); i++){
    		  if(pipeiname.get(i).equals(ziduan)){
    			    HashMap<String,Object> map = new HashMap<String,Object>();
    			    map.put("geming", pipeiname.get(i));
    			    map.put("geshouming", pipeigeshouname.get(i));
    			    updatedata.add(map);
    			    break;
    		    }
    	  }
    	
    	return updatedata;
    	
    }
   
    //װ��ϲ���������б�
   public  static  List<HashMap<String,Object>> map1 = new ArrayList<HashMap<String,Object>>();
    public   static  List<HashMap<String,Object>>  collectsongname(List<String> ziduan , int size){
  	  File  file = Environment.getExternalStorageDirectory();
        List<String> pipeiname = new ArrayList<String>();
        List<String>  pipeigeshouname = new ArrayList<String>();
    	  pipeiname = new FunctionSDfilename().getFilesname(file);
    	  pipeigeshouname = new FunctionSDfilename().getFilesgeshouname(file);
  	  for( int j = 0 ; j < size ; j++){
  		  for( int i =0 ; i < pipeiname.size() ; i++)
  		  if(  (pipeiname.get(i).equals(ziduan.get(j)))  ){
  			    HashMap<String,Object> map = new HashMap<String,Object>();
  			    map.put("geming", pipeiname.get(i));
  			    map.put("geshouming", pipeigeshouname.get(i));
  			    map1.add(map);
  			    break;
  		    }
  	  }
  	
  	return map1;
  	
  }
   //�������б��еļ�ͷ��ӵ����˵�
   //  public static List<HashMap<String,Object>> songgongneng = new ArrayList<HashMap<String,Object>>();
     public String name3[] = new String[]{"ɾ��","����","����"};
     public List<HashMap<String,Object>> tubiao(){
    	 List<HashMap<String,Object>> songgongneng = new ArrayList<HashMap<String,Object>>();
    	 for(int i = 0 ;i <3 ; i++){
    		    HashMap<String, Object> hhh1 = new HashMap<String, Object>();
    		    hhh1.put("gongneng", name3[i]);	
    		    songgongneng.add(hhh1);
    	   }
    	   return songgongneng;
     }
     
   //��sdcard �е�����MP4�ļ�ת�ص�listview��
     public List<HashMap<String,Object>> videozu = new ArrayList<HashMap<String,Object>>();
     public    List<HashMap<String,Object>> videoname(){
    	  File file  = Environment.getExternalStorageDirectory();
    	  List<String> videoname = new ArrayList<String>();
    	  List<String> videogeshouname = new ArrayList<String>();
    	  videoname = new FunctionSDfilename().getFilesnamevideo(file);
    	  videogeshouname = new FunctionSDfilename().getFilesgeshounamevideo(file);
    	  for(int i = 0 ; i < videoname.size(); i++){
    		  HashMap<String,Object> tianjia = new HashMap<String,Object>();
    		  tianjia.put("videoname", videoname.get(i));
    		  tianjia.put("videogeshouname", videogeshouname.get(i));
    		  videozu.add(tianjia);
    		  
    	  }
    	  return videozu;
      }
   
}
	

