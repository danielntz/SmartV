package com.example.Mfunction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class FunctionM {
         
	private static final String TAG = null;
	public     MediaPlayer   player;
	public   List<String>gequmingziliebiao = new ArrayList<String>();
	public  List<String> geshounameliebiao = new ArrayList<String>();
	public  String wholeaddress = null;
	    public FunctionM()
	      {
	    	this.player = null;
	      }
	    
	    public  FunctionM( MediaPlayer  player){
	    	
	    	this.player = player;
	    	  
	    }
	   //播放音頻   
	   public  void  start(String gequmingzi) throws IOException 
	   {
		  if(this.player == null)
		  {
		  this.player = new MediaPlayer();
		  File file = Environment.getExternalStorageDirectory();
	   	  gequmingziliebiao = new FunctionSDfilename().getFilesname(file);   //得到sdcard下的所有歌曲名字
	   	  geshounameliebiao = new FunctionSDfilename().getFilesgeshouname(file);
	      for(int i = 0; i< gequmingziliebiao.size() ;i++){
	    	  if(gequmingzi.equals(gequmingziliebiao.get(i))){
	    		   wholeaddress = geshounameliebiao.get(i)+"-"+gequmingziliebiao.get(i)+".mp3";
	    		//   Log.i(TAG, geshounameliebiao.get(i));
	    		//   Log.i(TAG, gequmingziliebiao.get(i));
	    		//   Log.i(TAG, wholeaddress);
	    		   break;
	    		   
	    	  }
	     }
	      this.player.setDataSource("/sdcard/"+wholeaddress);
		  this. player.prepare();
		 
		  }
		  this.player.start();
	   }
	  //暫停音頻
	   public void  pause(){
          if(player!= null &&player.isPlaying())
           
        	  player.pause();
          
		  
	   }
	  //下一首
	   public void xiayishou(){
		   
	   }
	  //上一首
	  public void shangyishou(){
		  
	  }
	
}
