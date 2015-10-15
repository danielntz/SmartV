package com.example.uiassit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.util.EncodingUtils;

import android.os.Environment;

public class readirc {
    
	    readirc(){
	    	
	    }
	   //讀取文件中的內容并顯示在界面上
	   public  static String  readirltools() throws IOException
	   {   
		   String  content;
		  /*  String finalcontent = null;
		    StringBuffer   content = new StringBuffer();
		    File file = new File("/sdcard/hrh.txt");
		    if( !file.exists() && file.length() < 0 )
		    {
		    	return "沒有找到歌詞文件";
		    }
		    else{
		    	BufferedReader  reader = new BufferedReader(new FileReader(file));
		        String line = "";
		        while((line = reader.readLine()) != null){
		    	  content.append(line);
		    	  finalcontent = content.toString();
		    	  reader.close();
		   }
		        return finalcontent;
		    }*/
		   File  file = new File(Environment.getExternalStorageDirectory(),"geci.lrc");
		   if(!file.exists()){
			   return "沒有找到文件";
		   }
		   else{
			   FileInputStream fis = new FileInputStream(file);
		  
		   byte[]  buffer = new byte[fis.available()];
		   fis.read(buffer);
		    content = EncodingUtils.getString(buffer, "UTF-8");    //把字節數組轉化成字符串
		   fis.close();
		   }
		   return content;
		  	}
}
