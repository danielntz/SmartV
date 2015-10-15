package com.example.viewpager;

import java.io.IOException;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Mfunction.FunctionM;
import com.example.showword.LrcHandle;
import com.example.slidechange.WordView;
import com.example.uiassit.readirc;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

public class songword  extends Fragment{
	  
	private WordView  mwordView;
	private List  mTimeList;
	private  MediaPlayer mPlayer = null;
	private TextView    showgecidan;
	private  String content;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View fragment3 = inflater.inflate(R.layout.fragment3_layout,container, false);
		 showgecidan = (TextView)fragment3.findViewById(R.id.showgecidan);
		 mwordView = (WordView)fragment3.findViewById(R.id.showgeci);
		 try {
			 content = readirc.readirltools();
			 showgecidan.setText(content);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
   /*		 mPlayer = new FunctionM().player;
		if(mPlayer == null){
			Toast.makeText(getActivity(), "Ã»ÓÐ²¥·Å¸èÇú", 0);
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
	
	
}
