package com.example.uiassit;

import java.util.ArrayList;
import java.util.List;

import com.example.adjustscreen.adjustscreen;

import android.app.Application;
import android.media.MediaPlayer;

public class chuandishuju  extends Application{
       
	  public  static  String name = "yes";
	  public  static  int flag = 1;    //��ʾû�д�����
	  public  static  List<String> xihuandegequ = new ArrayList<String>();
	  public  static  String geshouname;
	  public  static  adjustscreen  maxscreen;
	  public  static long bofangshijian;   
	  public  static  long  wholetime;
	  public  static  int  timeprogress;
      
	  
	  public void setname(String name){
		  this.name = name;
	  }
	  public  String getname(){
		  return this.name;
	  }
	  public  void setgeshouname(String name){
		  this.geshouname = name;
	  }
	  public String getgeshouname(){
		  return this.geshouname;
	  }
	  // ʹ��Ļ��С�䵽��  ���ݸ�����Ļ��ֵ����ǰ�Ĳ���ʱ�����Ƶ����
	  public void  setMediaplayer(adjustscreen  player){
		  this.maxscreen = player;
		  
	  }
	  public  void  setzongshijian(long shijian){
		  this.bofangshijian = shijian;
	  }
	  public   long  getzongshijian(){
		   return this.bofangshijian;
	  }
	  public  adjustscreen   getMediaPlayer(){
		  return this.maxscreen;
	  }
	  
	  public void setwholetime(long wholeshijian){
		  this.wholetime = wholeshijian;
	  }
	 public  long getwholetime(){
		 return (int) this.wholetime;
	 }
	 public void settimeprogress(int timeprogress){
		   this.timeprogress = timeprogress;
	 }
	 public  int  gettiemprogress(){
		 return timeprogress;
	 }
	 
}
