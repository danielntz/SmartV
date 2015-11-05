package com.example.Mfunction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class FunctionV implements OnPreparedListener {
       
	   private static final String TAG = null;
	   public  VideoView  mvview ;
	   private  static Context context;
	   private  int bofang = 0 ;   //1 ��ʾ�����У�0 ��ʾ��ͣ 2��ʾ
	   private  List<String> shipinname = new ArrayList<String>();
	   private  List<String> shipingeshouname = new ArrayList<String>();
	   private  String wholeaddress;
	  
	 
	  public  void start(VideoView showmv ,String newname){
		    if(this.bofang == 0){
		    
		    	File file = Environment.getExternalStorageDirectory();
			   	shipinname = new FunctionSDfilename().getFilesnamevideo(file);   //�õ�sdcard�µ�������Ƶ����
			   	shipingeshouname = new FunctionSDfilename().getFilesgeshounamevideo(file);  
		    	for(int i = 0; i < shipinname.size(); i++){
		    		 if(newname.equals(shipinname.get(i))){
			    		   wholeaddress = shipingeshouname.get(i)+"-"+shipinname.get(i)+".mp4";
			    		  
			    		 Log.i(TAG, wholeaddress);
			    		   break;
		    	}
		    	}
		    	//showmv.setVideoPath("/sdcard/Wiz Khalifa-See you again.mp4");
		      showmv.setVideoPath("/sdcard/"+wholeaddress); //���ñ�����Դ·��
			  showmv.requestFocus();    //���ý���
			   this.bofang = 1 ;
		   
		     showmv.setOnPreparedListener(this);
		     showmv.start();
		    }
		   
	  }
	  public   void pause(VideoView showmv){
		
		  if(showmv != null && showmv.isPlaying()){
			showmv.pause();
			this.bofang = 2;
		 }
	  }
	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		  
	}
}
