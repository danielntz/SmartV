package com.example.zhuui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.example.Mfunction.FunctionM;
import com.example.uiassit.gridvietianchong;
import com.example.uiassit.gridviewadapter;
import com.example.uiassit.mypageeradapter;
import com.example.uiassit.uiassit;
import com.example.viewpager.appreciatephoto;
import com.example.viewpager.songstudio;
import com.example.viewpager.songword;
import com.jerome.weibo.*;

import android.R.color;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class zhujiemian  extends FragmentActivity implements OnClickListener, OnTouchListener{
    
	private   LinearLayout linearlayout;
	private   ImageView  suoxiao;
	private   TextView   songtitle;
	private   ImageView  duogongneng;
	private   TextView   duringtime;
	private   TextView   wholetime;
	private   SeekBar    seekbar;
	private   Button     bofang;
	private   Button     zanting;
	private   Button     xiayishou;
	private   Button     shangyishou;
	private   ImageView   collect;
	private   ImageView   gongneng;
	private   PopupWindow  menupopwindow;    //弹出界面
	private   ImageView    rotatephoto;
	private  GridView   gridview;
	private  gridviewadapter   adapter;
	private  ImageView       collectlist;
	private  ImageView       collectfasong;
	boolean  flag = false;      //标记用来判断按钮是否按下
	private  ViewPager  viewpager = null; 
	private  List<Fragment> fragments = null;
    private FunctionM   bofangmusic = new FunctionM();  //初始化MediaPlayer
	private  FragmentPagerAdapter  fpadapter;
	private  ImageView   leftdot;
	private  ImageView   middledot;
	private  ImageView   rightdot;
	

	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhujiemian_layout);
	    
		
		//获取ID
		linearlayout = (LinearLayout)findViewById(R.id.wholezhujiemian);
		suoxiao = (ImageView)findViewById(R.id.suoxiao);
		songtitle = (TextView)findViewById(R.id.songtitle);
		duogongneng = (ImageView)findViewById(R.id.duogongneng);
		collect = (ImageView)findViewById(R.id.collect);
		gongneng = (ImageView)findViewById(R.id.gongneng);
		rotatephoto = (ImageView)findViewById(R.id.rotatephoto);
        bofang  = (Button)findViewById(R.id.bofang);
		zanting= (Button)findViewById(R.id.zanting);
	    xiayishou = (Button)findViewById(R.id.xiayishou);
		shangyishou = (Button)findViewById(R.id.shangyishou);
		collectfasong = (ImageView)findViewById(R.id.collectfasong);
		collectlist = (ImageView)findViewById(R.id.collectlist);
		seekbar = (SeekBar)findViewById(R.id.progress_bar);
		leftdot = (ImageView)findViewById(R.id.leftdot);
		middledot = (ImageView)findViewById(R.id.middledot);
		rightdot = (ImageView)findViewById(R.id.rightdot);
		
		//初始化viewpaper
		initsetviewadapter();
		
	    bofang.setOnClickListener(this);
	    zanting.setOnClickListener(this);
	    xiayishou.setOnClickListener(this);
	    shangyishou.setOnClickListener(this);
	    suoxiao.setOnClickListener(this);
	    linearlayout.setOnClickListener(this);
        duogongneng.setOnClickListener(this);
        collect.setOnClickListener(this);
        gongneng.setOnClickListener(this);
        collectlist.setOnClickListener(this);
        collectfasong.setOnClickListener(this);
     //   seekbar.setOnSeekBarChangeListener(new seekbarprogress());
}

	/**
	 * 
	 */
	private void initsetviewadapter() {
		// TODO Auto-generated method stub
		  viewpager = (ViewPager)findViewById(R.id.pager);
		  //把三个切换fragment放入集合中
		  fragments = new ArrayList<Fragment>();
		  fragments.add(new songstudio());
		  fragments.add(new appreciatephoto());
		  fragments.add(new songword());
		  fpadapter = new mypageeradapter(getSupportFragmentManager(),fragments);
		  //设置适配器
		  viewpager.setAdapter(fpadapter);
		  viewpager.setCurrentItem(1);      //默认第二个fragment首先显示
		  viewpager.setOnPageChangeListener(new exchangedot());
		
	 }
	
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	   switch (v.getId()) {
	   
	   case R.id.suoxiao:
		    finish(); 
		    break;
	case R.id.bofang:
		 if(!flag) 
		 {
			 uiassit.disappear(bofang);
			 uiassit.show(zanting);
			 flag = true;
		 }
		 
		
		 try {
		 	bofangmusic.start();
		
			 seekbar.setMax(bofangmusic.player.getDuration());   //给seekbar添加具体的时间
			// new Thread(new seekbartongbu()).start();
			new Thread (new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true){
					
					try {
						seekbar.setProgress(bofangmusic.player.getCurrentPosition()); //获得当前播放的进度值
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
				
			}).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 break;
	case R.id.wholezhujiemian:
		 menupopwindow.dismiss();
		 break;
	case R.id.zanting:
		 if(flag){
			 uiassit.disappear(zanting);
             uiassit.show(bofang);
             flag = false;
		 }
		bofangmusic.pause();
		 
		 break;
	case R.id.xiayishou:
		 break;
	case R.id.shangyishou :
		 break;
	case R.id.duogongneng:
		
		if(menupopwindow !=null && menupopwindow.isShowing()){
			 menupopwindow.dismiss();
		}
		else{
			
			init(); //弹出菜單界面
		}
		 break;
	
     }
	  
		   
	}
	
	public void  init(){
		//弹出菜单
		View  tanchuview = getLayoutInflater().inflate(R.layout.tanchumenu, null);    //获得弹出界面的布局 
		gridview = (GridView)tanchuview.findViewById(R.id.showthing);       //布局gridview,哪个界面获得gridview就从哪个界面寻找R.id  
		gridviewadapter hhh = new gridviewadapter(this);
		gridview.setAdapter(hhh);
		menupopwindow = new PopupWindow(tanchuview,500,350);                          //设置弹出界面，宽度，高度
		//menupopwindow.setFocusable(true);                                           //获取弹出菜单的焦点
		//menupopwindow.setTouchable(true);
	    //menupopwindow.setOutsideTouchable(true);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "sdf", 0).show();
			}
			
		});
     	menupopwindow.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //弹出的位置
	  }
	  
	 public class seekbartongbu implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
			
			try {
				Thread.sleep(1000);
				seekbar.setProgress(bofangmusic.player.getCurrentPosition()); //获得当前播放的进度值
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		 
	 }
	
	  public class exchangedot implements OnPageChangeListener{

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
					
					 leftdot.setImageResource(R.drawable.greendot);
					 middledot.setImageResource(R.drawable.dotwhite);
					 rightdot.setImageResource(R.drawable.dotwhite);
					break;
				case 1:
					 middledot.setImageResource(R.drawable.greendot);
					 rightdot.setImageResource(R.drawable.dotwhite);
					 leftdot.setImageResource(R.drawable.dotwhite);
					break;
				case 2:
					rightdot.setImageResource(R.drawable.greendot);
					middledot.setImageResource(R.drawable.dotwhite);
					leftdot.setImageResource(R.drawable.dotwhite);
					 
					break;
				
				}
		}
		  
	  }
	 
	 public class seekbarprogress implements OnSeekBarChangeListener{

		 
		@Override
		
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			  int  position;
			if(bofangmusic.player == null){
				 position = progress;
				 try {
					bofangmusic.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			else{
				position = progress;
				try {
					try {
						bofangmusic.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
	 
	  
		  
	  
	  
}
