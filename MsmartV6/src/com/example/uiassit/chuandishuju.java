package com.example.uiassit;

import android.app.Application;

public class chuandishuju  extends Application{
       
	  public  static  String name = "yes";
	  public  static  int flag = 1;    //表示没有传数据
	  public void setname(String name){
		  this.name = name;
	  }
	
	
	  public  String getname(){
		  return this.name;
	  }
}
