package com.example.Mfunction;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.util.Log;

public class FunctionSDfilename {
   
	private static final String TAG = null;
	private  String  filename;
    private  List<String> filesname = new ArrayList<String>();       //װ�ظ���
    private  List<String> filesgeshouname = new ArrayList<String>(); //װ�ظ�����
	//private  HashMap<List,List> ddd;
    //��ø���������Դ
    public FunctionSDfilename(){
		   
	   }
	   //����Ϊ"/sdcard/",װ�غ�׺ΪMP3���ļ�������
	   public List<String> getFilesname(File SDpath){
		 
		   File[] files = SDpath.listFiles();   //���SDpath·���µ��ļ�
		  
		  if(files != null){
			  for(File file : files){
				  if(file.isDirectory()){   //�����ַ���ļ���
					  //������Բ����ļ����ڵ��ļ���ʹ�õݹ�
				  }
				  else{
					  String filename = file.getName(); //�õ��ļ�������
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
	   //��ø���������Դ
	   public  List<String> getFilesgeshouname(File SDpathgeshou){
		    File[] file = SDpathgeshou.listFiles();
		    if(file != null){
		    	for(File file1 : file){
		    		if(file1.isDirectory()){   //�����ַ���ļ���
						  //������Բ����ļ����ڵ��ļ���ʹ�õݹ�
					  }
					  else{
						  String filename = file1.getName(); //�õ��ļ�������
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
	   //�����Ƶ������
	   public List<String> getFilesnamevideo(File SDpath){
			 
		   File[] files = SDpath.listFiles();   //���SDpath·���µ��ļ�
		  
		  if(files != null){
			  for(File file : files){
				  if(file.isDirectory()){   //�����ַ���ļ���
					  //������Բ����ļ����ڵ��ļ���ʹ�õݹ�
				  }
				  else{
					  String filename = file.getName(); //�õ��ļ�������
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
	   //�����Ƶ����������Դ
	   public  List<String> getFilesgeshounamevideo(File SDpathgeshou){
		    File[] file = SDpathgeshou.listFiles();
		    if(file != null){
		    	for(File file1 : file){
		    		if(file1.isDirectory()){   //�����ַ���ļ���
						  //������Բ����ļ����ڵ��ļ���ʹ�õݹ�
					  }
					  else{
						  String filename = file1.getName(); //�õ��ļ�������
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
