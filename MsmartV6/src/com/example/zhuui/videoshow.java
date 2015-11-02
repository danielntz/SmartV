package com.example.zhuui;

import java.util.ArrayList;
import java.util.List;

import com.example.Mfunction.FunctionV;
import com.example.adjustscreen.adjustscreen;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.haomiaotoshijian;
import com.example.uiassit.mvviewpager;
import com.example.uiassit.uiassit;
import com.example.viewpager.aboutmv;
import com.example.viewpager.aboutxinxi;
import com.jerome.weibo.*;
import com.jerome.weibo.R.layout;

import android.R.color;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

public class videoshow  extends FragmentActivity implements OnClickListener, OnPageChangeListener, OnSeekBarChangeListener, OnPreparedListener{
       
	  private static final String TAG = null;
	private ViewPager   viewpager;
	  private List<Fragment> jiemian = null;   //װ��fragment
	  private mvviewpager  pager = null;
	  private  TextView  aboutxinxi ;
	  private  TextView    aboutmv;
	  private  Button    bofangmv;
	  private Button     zantingmv;
	  private  RelativeLayout  showfunction ;
	  private  int flag = 0 ;         //�����жϽ����������Ű�ť��ʱ����û����ʾ����Ƶ��  0 û��ʾ�� 1 ��ʾ
	  private  int flagbutton = 0;    //�����ж�  0 ���Ű�ť�� 1 ��ͣ��ť
	  private  SeekBar   time;
	  private  TextView  time1;
	  private  TextView  time2;
	  private  TextView  max;
	  private   adjustscreen  screen ;
	  private   FunctionV  screenvideo = new FunctionV() ;
	  private   boolean  fullscreen = false;     //false û��ȫ���� trueȫ��
	  private  long wholetime ;       //�����Ƶ���ܳ��Ⱥ�����
	  private  String formattime;     //ת��Ϊʱ���ʽ���ַ���
	  private  int  min = 0;  //����ʱ��ķ�
	  private  int  second = 0; //����ʱ�����
	  private  boolean flagshijiangenzong ;     //��ͣʱ������ʱ�䲻�ߣ� ��ʼʱ����ʱ��ͬ��,�����߳��е�ѭ����ʵ��
	 
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);       //ȡ������
		setContentView(R.layout.videoshow_layout);
		viewpager = (ViewPager)findViewById(R.id.about);
		aboutxinxi = (TextView)findViewById(R.id.aboutinformation);
		aboutmv = (TextView)findViewById(R.id.aboutmv);
		bofangmv = (Button)findViewById(R.id.bofangmv);
		zantingmv = (Button)findViewById(R.id.zantingmv);
		showfunction = (RelativeLayout)findViewById(R.id.xianshi);
		time = (SeekBar)findViewById(R.id.time);
		time1 = (TextView)findViewById(R.id.shengyushijian);
		time2 = (TextView)findViewById(R.id.zongshijian);
		screen = (adjustscreen)findViewById(R.id.showvideo);
		max = (TextView )findViewById(R.id.max);
	    chushihua();
	    bofangmv.setOnClickListener(this);
	    zantingmv.setOnClickListener(this);
	    showfunction.setOnClickListener(this);
		ininitviewpager();
		
		viewpager.setOnPageChangeListener(this);
		aboutxinxi.setOnClickListener(this);
		aboutmv.setOnClickListener(this);
		time.setOnSeekBarChangeListener(this);
		max.setOnClickListener(this);
	}
	//��ʼ��videoview�Ĳ��Ŵ�С
	public void chushihua(){
		 RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(480, 300);  //videoview������Ƶ�Ĵ�С
		 params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 screen.setLayoutParams(params);
		 
	}
	//����viewpager
	public void ininitviewpager()
	{
		jiemian = new ArrayList<Fragment>();
		jiemian.add(new aboutmv());
		jiemian.add(new aboutxinxi());
		pager = new mvviewpager(getSupportFragmentManager(), jiemian);
		viewpager.setAdapter(pager);
		viewpager.setCurrentItem(0);
		aboutxinxi.setTextColor(Color.BLUE);     //Ĭ��������ʾ�����Ϣ
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
		//	aboutxinxi.setBackgroundColor(color.holo_green_dark);
			aboutxinxi.setTextColor(Color.BLUE);
			aboutmv.setTextColor(Color.BLACK);
			break;

		case 1 :
		//	aboutmv.setBackgroundColor(color.holo_blue_bright);
			aboutmv.setTextColor(Color.BLUE);
			aboutxinxi.setTextColor(Color.BLACK);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.aboutinformation:
			 viewpager.setCurrentItem(0);
			 aboutxinxi.setTextColor(Color.BLUE);
			 aboutmv.setTextColor(Color.BLACK);
			 break;
		case R.id.max:  //���
			
			 Intent inten1 =new Intent(this,maxscreen.class);
			 startActivity(inten1);
		     //������Ļ������ֵ��ȫ�ֶ����ڴ���Ļ�ǵ��ô˶������Ϣ
			 new  chuandishuju().setMediaplayer(screen);
			 new  chuandishuju().setzongshijian(screen.getCurrentPosition());
			  
			 //���ô���һ��Activityֱ���ڴ�Activity�Ͻ��в���
			/*	if(!fullscreen){
			@SuppressWarnings("deprecation")
			 RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT); 
			 layoutparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			 layoutparams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			 layoutparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			 layoutparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			 screen.setLayoutParams(layoutparams);
			 fullscreen = true;   }
			else{
				 RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(480, 320);
				 params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				 screen.setLayoutParams(params);
				 fullscreen = false;
			}*/
			 break;
		case R.id.aboutmv:
			 viewpager.setCurrentItem(1);
			 aboutmv.setTextColor(Color.BLUE);
			 aboutxinxi.setTextColor(Color.BLACK);
			 break;
		case R.id.bofangmv :
			 uiassit.show(zantingmv);
			 uiassit.disappear(bofangmv);
			 flagbutton  =1;
			 screenvideo.start(screen);
			 flagshijiangenzong = true;
		//	 time.setMax(screen.getDuration());
			 screen.setOnPreparedListener(this);
			
			// Log.i(TAG,"����"+screen.getDuration() );
			 new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					     
					while(flagshijiangenzong ){
						 
						try {
							   time.setProgress(screen.getCurrentPosition());
							   
					       	   Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				 
			 }).start();
		 	 break;
			 
			 
		case R.id.zantingmv:
			 uiassit.show(bofangmv);
			 uiassit.disappear(zantingmv);
			 flagbutton  = 0;
			 screenvideo.pause(screen);
	
			 break;
			 
		case R.id.xianshi:
			if(flag == 0 )
			{      
				 if(flagbutton == 0)
				 {
				   uiassit.show(bofangmv);
				   uiassit.show(time);
				   uiassit.show(time1);
				   uiassit.show(time2);
				   uiassit.show(max);
				   }
				 else{
					 uiassit.show(zantingmv);
					 uiassit.show(time);
					 uiassit.show(time1);
					 uiassit.show(time2);
					 uiassit.show(max);
					 }
				  flag = 1;
			}
			else{
			      if(flagbutton  == 0)
			      {
				   uiassit.disappear(bofangmv);
				   uiassit.disappear(time);
				   uiassit.disappear(time1);
				   uiassit.disappear(time2);
				   uiassit.disappear(max);
				  
			      }
			      else{
			    	  uiassit.disappear(zantingmv);
			    	  uiassit.disappear(time);
					  uiassit.disappear(time1);
					  uiassit.disappear(time2);
					  uiassit.disappear(max);
			      }
				flag = 0;
			}
			 break;
		}
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,  //����������ֵ�ĸı�
			boolean fromUser) {
		// TODO Auto-generated method stub
	      String nowtime = new haomiaotoshijian().formattime(progress);
	      new chuandishuju().settimeprogress(progress);
	    
		  if(nowtime.contains(":")){
			  time1.setText(nowtime);
			  }
		  else
			 time1.setText("00:"+nowtime); 	
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {      //��ʼ�϶�
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {      //ֹͣ�϶�
		// TODO Auto-generated method stub
	
		screen.seekTo(time.getProgress());                 //�����ƶ���λ��
	   
		
	}
	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		  time.setMax(screen.getDuration());
		  wholetime = screen.getDuration();           //���ʱ����ܳ���
		  new chuandishuju().setwholetime(wholetime); //���洫�ݵ���ʱ������
		  formattime =  new haomiaotoshijian().formattime(wholetime);
		  time2.setText(formattime);    //��ʾ��ʱ��
		  time1.setText("00:00");       //��ʾ����ʱ��
	}
	
	
	
}
