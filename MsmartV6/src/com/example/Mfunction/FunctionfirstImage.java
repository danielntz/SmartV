package com.example.Mfunction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;

/**
 * 可以用来获得视频第一帧的图片并显示在组件上
 * @author lenovo
 *
 */
public class FunctionfirstImage {
      
	   private List<String> videogeshouname;
	   private List<String> videoname;
	   private List<Bitmap> tupian = new ArrayList<Bitmap>();
	
	  public  FunctionfirstImage(){
		  
	  }
	
	  public  List<Bitmap> showfirstimage(){
		      
		     File path = Environment.getExternalStorageDirectory();
		     videogeshouname = new FunctionSDfilename().getFilesgeshounamevideo(path);
		     videoname = new FunctionSDfilename().getFilesnamevideo(path);
		     MediaMetadataRetriever  media = new MediaMetadataRetriever();
		     for(int i =0 ;i < videoname.size();i ++){
		       media.setDataSource("/sdcard/"+videogeshouname.get(i)+"-"+videoname.get(i)+".mp4");
		       Bitmap bitmap = media.getFrameAtTime();
		       tupian.add(bitmap);
		     }
		     return  tupian;
	  }
	
}
