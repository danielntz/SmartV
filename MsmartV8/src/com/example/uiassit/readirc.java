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
	   //�xȡ�ļ��еă��ݲ��@ʾ�ڽ�����
	   public  static String  readirltools() throws IOException
	   {   
		   String  content;
		  /*  String finalcontent = null;
		    StringBuffer   content = new StringBuffer();
		    File file = new File("/sdcard/hrh.txt");
		    if( !file.exists() && file.length() < 0 )
		    {
		    	return "�]���ҵ����~�ļ�";
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
			   return "�]���ҵ��ļ�";
		   }
		   else{
			   FileInputStream fis = new FileInputStream(file);
		  
		   byte[]  buffer = new byte[fis.available()];
		   fis.read(buffer);
		    content = EncodingUtils.getString(buffer, "UTF-8");    //���ֹ����M�D�����ַ���
		   fis.close();
		   }
		   return content;
		  	}
}
