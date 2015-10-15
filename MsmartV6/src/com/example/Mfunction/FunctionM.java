package com.example.Mfunction;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;

public class FunctionM {
         
	public     MediaPlayer   player;
	   
	public FunctionM(){
	    	this.player = null;
	    }
	    
	    public  FunctionM( MediaPlayer  player){
	    	
	    	this.player = player;
	    	  
	    }
	   //播放音頻   
	   public  void  start() throws IOException 
	   {
		  if(this.player == null)
		  {
		  this.player = new MediaPlayer();
		  
	      this.player.setDataSource("/sdcard/geci.mp3");
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
