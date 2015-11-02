package com.example.Mfunction;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.util.Log;

public class FunctionSDfilename {
   
	private static final String TAG = null;
	private  String  filename;
    private  List<String> filesname = new ArrayList<String>();       //装载歌名
    private  List<String> filesgeshouname = new ArrayList<String>(); //装载歌手名
	//private  HashMap<List,List> ddd;
    //获得歌名名字资源
    public FunctionSDfilename(){
		   
	   }
	   //参数为"/sdcard/",装载后缀为MP3的文件的名字
	   public List<String> getFilesname(File SDpath){
		 
		   File[] files = SDpath.listFiles();   //获得SDpath路径下的文件
		  
		  if(files != null){
			  for(File file : files){
				  if(file.isDirectory()){   //如果地址是文件夹
					  //这里可以查找文件夹内的文件，使用递归
				  }
				  else{
					  String filename = file.getName(); //得到文件的名字
					  if(filename.endsWith(".mp3")){
						 String zhenname = filename.substring(filename.indexOf("-")+1,filename.lastIndexOf(".")).toString();
						 filesname.add(zhenname);
					  }
					  
				  }
			  }
			  return filesname;
		  }
		   return filesname;
     }
	   //获得歌手名字资源
	   public  List<String> getFilesgeshouname(File SDpathgeshou){
		    File[] file = SDpathgeshou.listFiles();
		    if(file != null){
		    	for(File file1 : file){
		    		if(file1.isDirectory()){   //如果地址是文件夹
						  //这里可以查找文件夹内的文件，使用递归
					  }
					  else{
						  String filename = file1.getName(); //得到文件的名字
						  if(filename.endsWith(".mp3")){
							
							  String zhenname = filename.substring(0,filename.indexOf("-")).toString();
							 filesgeshouname.add(zhenname);
						  }
		    	}
		    }
		    	return filesgeshouname;
	   }
		    return filesgeshouname;
		    
	   }
	   //获得视频的名字
	   public List<String> getFilesnamevideo(File SDpath){
			 
		   File[] files = SDpath.listFiles();   //获得SDpath路径下的文件
		  
		  if(files != null){
			  for(File file : files){
				  if(file.isDirectory()){   //如果地址是文件夹
					  //这里可以查找文件夹内的文件，使用递归
				  }
				  else{
					  String filename = file.getName(); //得到文件的名字
					  if(filename.endsWith(".mp4")){
						 String zhenname = filename.substring(filename.indexOf("-")+1,filename.lastIndexOf(".")).toString();
						 filesname.add(zhenname);
					  }
					  
				  }
			  }
			  return filesname;
		  }
		   return filesname;
     }
	   //获得视频歌手名字资源
	   public  List<String> getFilesgeshounamevideo(File SDpathgeshou){
		    File[] file = SDpathgeshou.listFiles();
		    if(file != null){
		    	for(File file1 : file){
		    		if(file1.isDirectory()){   //如果地址是文件夹
						  //这里可以查找文件夹内的文件，使用递归
					  }
					  else{
						  String filename = file1.getName(); //得到文件的名字
						  if(filename.endsWith(".mp4")){
							
							  String zhenname = filename.substring(0,filename.indexOf("-")).toString();
							 filesgeshouname.add(zhenname);
						  }
		    	}
		    }
		    	return filesgeshouname;
	   }
		    return filesgeshouname;
		    
	   }
	
}
