package com.example.uiassit;

import android.app.Application;

public class chuandishuju  extends Application{
       
	  public  static  String name = "yes";
	  public  static  int flag = 1;    //��ʾû�д�����
	  public void setname(String name){
		  this.name = name;
	  }
	
	
	  public  String getname(){
		  return this.name;
	  }
}
