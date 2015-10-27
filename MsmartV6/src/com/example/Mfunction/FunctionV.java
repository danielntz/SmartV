package com.example.Mfunction;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;
import android.widget.VideoView;

public class FunctionV implements OnPreparedListener {
       
	   public  VideoView  mvview ;
	   private  static Context context;
	   private  int bofang = 0 ;   //1 表示播放中，0 表示暂停 2表示
	  
	 
	  public  void start(VideoView showmv){
		    if(this.bofang == 0){
		      showmv.setVideoPath("/sdcard/see you again.mp4"); //设置本地资源路径
			  showmv.requestFocus();    //设置焦点
			   this.bofang = 1 ;
		    }
		     showmv.setOnPreparedListener(this);
		     showmv.start();
		   
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
