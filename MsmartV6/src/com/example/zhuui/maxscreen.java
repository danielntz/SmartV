package com.example.zhuui;

import com.example.Mfunction.FunctionV;
import com.example.adjustscreen.adjustscreen;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.haomiaotoshijian;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

public class maxscreen extends Activity implements OnPreparedListener, OnClickListener, OnSeekBarChangeListener{
         
	   private adjustscreen  large ;
	   private FunctionV   bofang = new FunctionV();
	   private TextView bofangshijian;
	   private TextView zongshijian;
	   private Button maxbofang;
	   private Button maxzanting;
	   private RelativeLayout shijianbaozhi;
	   private RelativeLayout  gongnengbiaozhi;
	   private SeekBar   jindu;
	   private boolean  show = false;         //是否显示 false 没有显示，true显示
	   private RelativeLayout  baohan;
	   private int        flag = 1 ;              //1 播放按钮    0 暂停按钮
	   private TextView  text;
	   private RelativeLayout  fan;
	   private String  bofangtime;           //把播放毫秒转化成时间标记
	   private String  zongshi;              //把总时间毫秒转化成时间标记
	   private boolean flagshijiangenzong = true;
	   private int     timeguocheng;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);       //取消标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
		setContentView(R.layout.maxscreen_layout);
		//large =(adjustscreen) findViewById(R.id.enlarge);
		shijianbaozhi = (RelativeLayout)findViewById(R.id.shijian);
		gongnengbiaozhi = (RelativeLayout)findViewById(R.id.gongneng);
		jindu = (SeekBar)findViewById(R.id.maxseekbar);
		baohan = (RelativeLayout)findViewById(R.id.baohan);
		maxbofang = (Button)findViewById(R.id.maxbofang);
	//	fan = (RelativeLayout)findViewById(R.id.fan);
		maxzanting = (Button)findViewById(R.id.maxzanting);
		bofangshijian = (TextView)findViewById(R.id.bofangshijian);
		zongshijian = (TextView)findViewById(R.id.zantinshijian);
		//text = (TextView)findViewById(R.id.fanhui);
		baohan.setOnClickListener(this);
		maxbofang.setOnClickListener(this);
		maxzanting.setOnClickListener(this);
	//	large.setOnPreparedListener(this);
	//	large.setOnClickListener(this);
		large = new chuandishuju().getMediaPlayer();
		jindu.setOnSeekBarChangeListener(this);
		zongshi = righttime(new chuandishuju().getwholetime());
		zongshijian.setText(zongshi);
		bofangtime = lefttime(new chuandishuju().getzongshijian());
		timeguocheng = new chuandishuju().gettiemprogress();
		jindu.setProgress(timeguocheng);
		 if(bofangtime.contains(":")){
			  bofangshijian.setText(bofangtime);
			 }
		  else
			 bofangshijian.setText("00:"+bofangtime); 	
	  //   bofang.start(large);
		  large.seekTo(jindu.getProgress());
	    new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				     
				while(flagshijiangenzong ){
					 
					try {
						   jindu.setProgress(large.getCurrentPosition());
				       	   Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			 
		 }).start();
	}
   
	//视频加载
	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		   
	}
	
	//改变时间格式
	public String lefttime(long time){
		String lefttime = new haomiaotoshijian().formattime(time);
		return lefttime;
	}
	
	public String righttime(long time){
		String righttime = new haomiaotoshijian().formattime(time);
		 return righttime;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.baohan:
			 if(!show){
				 uiassit.show(shijianbaozhi);
				 if(flag == 1)
					 uiassit.show(maxbofang);
				 else
					 uiassit.show(maxzanting);
				 uiassit.show(jindu);
				// uiassit.show(fan);
				 show = true;
			 }
			 else{
				 uiassit.disappear(shijianbaozhi);
                if( flag == 0)
                	uiassit.disappear(maxzanting);
                else
                	uiassit.disappear(maxbofang);
                 uiassit.disappear(jindu);
              //   uiassit.disappear(fan);
                 show = false;
			 }
			 break;
		case R.id.maxbofang:
			 flag = 0 ;
			 uiassit.show(maxzanting);
			 uiassit.disappear(maxbofang);
			 break;
		case R.id.maxzanting:
			 flag = 1;
			 uiassit.show(maxbofang);
			 uiassit.disappear(maxzanting);
			 break;
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
	/*	 String nowtime = new haomiaotoshijian().formattime(progress);
		  if(nowtime.contains(":")){
			  bofangshijian.setText(nowtime);
			  }
		  else
			 bofangshijian.setText("00:"+nowtime);*/ 	
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
      
	  
}
