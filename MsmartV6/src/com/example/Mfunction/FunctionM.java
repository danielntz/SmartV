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
	   //�������l   
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
	  //��ͣ���l
	   public void  pause(){
          if(player!= null &&player.isPlaying())
           
        	  player.pause();
          
		  
	   }
	  //��һ��
	   public void xiayishou(){
		   
	   }
	  //��һ��
	  public void shangyishou(){
		  
	  }
	
}
