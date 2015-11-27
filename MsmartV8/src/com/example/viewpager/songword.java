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
	 private  LrcHandle   handleword;    //��ʴ���
     private  List<String>   rowword;     //���ÿһ�г�ȥ�������ڵ�����
     private  List<Long> rowtime  = new ArrayList<Long>();    //���ÿһ���������ڵĶ���
     private   LrcHandle    handle = new LrcHandle();
      private   handler   hand;
      private  MediaPlayer   player ;     //���������洫�ݹ�����Mediaplayer
      private  boolean   flag  = false; 
     //handler����
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
			Toast.makeText(getActivity(), "û�в��Ÿ���", 0);
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
     * ��ʳ�ʼ��
     */
   public    void    initword(){
  	           handleword = new LrcHandle();
  	          String path = "/sdcard/See you again.lrc";
  	           handleword.readLRC(path);
  	          rowword = handleword.getWords();     
  	          rowtime = handleword.getTime();
   }
   
 //��ͬ����ʾ���,�ڲ���
   public  class myshowgeci implements  Runnable{
     
  	      private   long    time;
  	      private  int  i =5;       //���ĵ�һ�仰             rowword
  	      private  int  k = 0;     //����Ӧ�ĵ�һ��ʱ��   rowtime
	   @Override
	    public void run() {
		       try {
		    	       
			       	Thread.sleep(150);       //��ʼ��ʾ����
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		// TODO Auto-generated method stub
		          while(player.isPlaying()){
		                         time = player.getCurrentPosition();
		        	      //        Log.i(TAG, rowword.get(i) );
		                   //        gecicontent .setText(rowword.get(i));    //��Ҫ�õ�handler����
		                          Message    msg = new Message();
		                           Bundle     bun = new Bundle();
		                           bun.putString("content", rowword.get(i));
		                           msg.setData(bun);
		                           hand.sendMessage(msg);
		        	               i++;
		        	        
		              try {
						Thread.sleep(rowtime.get(k+1) - rowtime.get(k) );     //��һ�����һ��֮������ʱ��
						         k++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          }
           }
	
  }
	
}
