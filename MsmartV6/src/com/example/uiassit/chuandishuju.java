package com.example.uiassit;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

public class chuandishuju  extends Application{
       
	  public  static  String name = "yes";
	  public  static  int flag = 1;    //表示没有传数据
	  public  static  List<String> xihuandegequ = new ArrayList<String>();
	  public void setname(String name){
		  this.name = name;
	  }
	
	
	  public  String getname(){
		  return this.name;
	  }
	 
}
