package com.example.Mfunction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;
import android.util.Log;
/**
 * �������ļ���
 * @author lenovo
 *
 */
public class Functiongetfilename {
         
	   private static final String TAG = null;
	   private List<String> mp3name = new ArrayList<String>(); 
	   private File file = Environment.getExternalStorageDirectory(); //��õ�ַ��"/sdcard/"
	   
	   public Functiongetfilename(){
		   
	   }
	   
	   public  void getfilename(){
		   
		   mp3name= new FunctionSDfilename().getFilesname(file);
		   for(int i = 0 ; i < mp3name.size();i++){
			      String ss = mp3name.get(i);
			      Log.i(TAG, ss);
		   }
		   
	   }
}
