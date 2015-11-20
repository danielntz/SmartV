package com.example.viewpager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Mfunction.FunctionM;
import com.example.showword.LrcHandle;
import com.example.slidechange.WordView;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.readirc;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

public class songword  extends Fragment{
	  
	private WordView  mwordView;
	private  MediaPlayer mPlayer = null;
	private TextView    showgecidan;
	private  String content;
	 private  LrcHandle   handleword;    //歌词处理
     private  List<String>   rowword;     //获得每一行除去中括号内的内容
     private  List<Long> rowtime  = new ArrayList<Long>();    //获得每一行中括号内的东西
     private   LrcHandle    handle = new LrcHandle();
      private   handler   hand;
      private  MediaPlayer   player ;     //接收主界面传递过来的Mediaplayer
      private  boolean   flag  = false; 
     //handler机制
     public   class handler extends  Handler{

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				Bundle  bundle  =msg.getData();
				String  geci = bundle.getString("content");
				showgecidan.setText(geci);
				
			}
     	 
      }
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View fragment3 = inflater.inflate(R.layout.fragment3_layout,container, false);
		 showgecidan = (TextView)fragment3.findViewById(R.id.showgecidan);
		    hand = new handler();
	       initword();
	        player =   new chuandishuju().getPlayer();
	     new Thread(new myshowgeci()).start();
   /*		 mPlayer = new FunctionM().player;
		if(mPlayer == null){
			Toast.makeText(getActivity(), "没有播放歌曲", 0);
		}
		else
		{ 
	 	LrcHandle lrcHandler = new LrcHandle();
			try {
			lrcHandler.readLRC("/sdcard/geci.lrc");
			mTimeList = lrcHandler.getTime();
		//	mPlayer.setDataSource("/sdcard/geci.mp3");
		//	mPlayer.prepare();
			} catch (IllegalArgumentException e) {
			e.printStackTrace();
			} catch (SecurityException e) {
			e.printStackTrace();
			} catch (IllegalStateException e) {
			e.printStackTrace();
			}
			final Handler handler = new Handler();
		//	mPlayer.start();
			new Thread(new Runnable() {
			int i = 0;

			@Override
			public void run() {
			while (mPlayer.isPlaying()) {
			handler.post(new Runnable() {

			@Override
			public void run() {
			mwordView.invalidate();
			}
			});
			try {
				Thread.sleep( (Integer) mTimeList.get(i+1) -(Integer) mTimeList.get(i));
			} catch (InterruptedException e) {
			}
			i++;
			if (i == mTimeList.size() - 1) {
			mPlayer.stop();
			break;
			}
			}
			}
			}).start();
		}*/
			
		 return  fragment3;
	}
	  /**
     * 歌词初始化
     */
   public    void    initword(){
  	           handleword = new LrcHandle();
  	          String path = "/sdcard/See you again.lrc";
  	           handleword.readLRC(path);
  	          rowword = handleword.getWords();     
  	          rowtime = handleword.getTime();
   }
   
 //用同步显示歌词,内部类
   public  class myshowgeci implements  Runnable{
     
  	      private   long    time;
  	      private  int  i =5;       //唱的第一句话             rowword
  	      private  int  k = 0;     //所对应的第一个时间   rowtime
	   @Override
	    public void run() {
		       try {
		    	       
			       	Thread.sleep(150);       //开始显示歌名
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		// TODO Auto-generated method stub
		          while(player.isPlaying()){
		                         time = player.getCurrentPosition();
		        	      //        Log.i(TAG, rowword.get(i) );
		                   //        gecicontent .setText(rowword.get(i));    //需要用到handler机制
		                          Message    msg = new Message();
		                           Bundle     bun = new Bundle();
		                           bun.putString("content", rowword.get(i));
		                           msg.setData(bun);
		                           hand.sendMessage(msg);
		        	               i++;
		        	        
		              try {
						Thread.sleep(rowtime.get(k+1) - rowtime.get(k) );     //下一句和上一句之间间隔的时间
						         k++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          }
           }
	
  }
	
}
