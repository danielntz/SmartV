package com.example.zhuui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.example.Mfunction.FunctionM;
import com.example.songslistfragment.favourite_list;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.gridvietianchong;
import com.example.uiassit.gridviewadapter;
import com.example.uiassit.haomiaotoshijian;
import com.example.uiassit.mypageeradapter;
import com.example.uiassit.uiassit;
import com.example.viewpager.appreciatephoto;
import com.example.viewpager.songstudio;
import com.example.viewpager.songword;
import com.jerome.weibo.*;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
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

public class zhujiemian  extends FragmentActivity implements OnClickListener, OnTouchListener, OnSeekBarChangeListener{
    
	private static final String TAG = null;
	private   LinearLayout linearlayout;
	private   ImageView  suoxiao;
	//private   TextView   songtitle;
	private    LinearLayout   songtitle;
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
    private FunctionM   bofangmusic = new FunctionM();  //初始化MediaPlayer,用来播放当前按下的第一首
    private  FunctionM    xiayishoumusic = new FunctionM();      //重新开启一个Mediaplayer对象,用来播放下一首歌
	private  FragmentPagerAdapter  fpadapter;
	private  ImageView   leftdot;
	private  ImageView   middledot;
	private  ImageView   rightdot;
	private   int flagbofangrule ;    //1 随机播放，2 顺序播放(按照列表的方式) 3 单曲循环 
	private   int flagcollectrule;    //1 不喜欢 2 喜欢
    private  PopupWindow  introduction;
    private  PopupWindow  collectlike;
    long starttime ;                     //当前线程开启时间
    long endtime  ;                     //当前线程结束时间
    private String gequmingzi = "";    //获得传递过来的歌曲名字
    private String geshoumingzi= "";  //获得传递过来的歌手名字
    private  TextView  bofangshijian;
    private  TextView  zongshijian;
    private  long   longshijian;       //获得相对应歌曲的总毫秒数
    private  String  longshijian1;     //转化成时间格式
    private  boolean   judge =  false;
    private  int       progress  = 1;            //判断当前歌的长度是否还变化， 变化说明没有完，没变化说明歌曲结束
    private   int    panduanshifang  = 1;     //当1，释放当前歌曲，当2,释放下一首歌曲
    private    int     addindex = 0;
    private    int     readdindex = 0;        
    private   LayoutInflater   inflater;
    private   String  xiayishougequmingzi;
    private   int      judgekong;                   //当1时，释放空间，当2时释放下一首歌空间
    private   boolean    jumpshunxu = true;                  //用来跳出线程的循环,结束某一个线程
    private  boolean    jumprandom = true;
    private  boolean   jumprepeat = true;
    private  String    secondename ;
    private  int         j = 1 ;                                                      //用来做为顺序播放
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhujiemian_layout);
	    
		
		//获取ID
		linearlayout = (LinearLayout)findViewById(R.id.wholezhujiemian);
		suoxiao = (ImageView)findViewById(R.id.suoxiao);
	//	songtitle = (TextView)findViewById(R.id.songtitle);
		songtitle =(LinearLayout)findViewById(R.id.songtitle);
		inflater = LayoutInflater.from(this);
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
		bofangshijian = (TextView)findViewById(R.id.bofangshijian);    //音乐播放的时间
		zongshijian = (TextView)findViewById(R.id.zongshijian);        //音乐的总时间
		flagbofangrule =1 ;     //初始播放为随机播放
		gongneng.setImageResource(R.drawable.neng);
		flagcollectrule = 1;    //初始化为不喜欢
		//初始化viewpaper
		initsetviewadapter();
		//初始化获得传递过来的值
		Intent intent =getIntent();
	    gequmingzi = intent.getStringExtra("geming");
	//	songtitle.setText(gequmingzi);          给textview添加歌曲的名字
	     inithuadongtitlecontent(gequmingzi);
	     try {
			bofangmusic();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        seekbar.setOnSeekBarChangeListener(this);
     //   seekbar.setOnSeekBarChangeListener(new seekbarprogress());
}

	  private  void   inithuadongtitlecontent( String gequmingzi){
		         View  view = inflater.inflate(R.layout.huadongsongtitle_layout, null);   //在加载新的布局文件前，一定要指定inflater，否则是空的
		        TextView   hhh = (TextView)view.findViewById(R.id.songtitlecontent);
		       hhh.setText("");
		       hhh.setText(gequmingzi);
		        hhh.setFocusable(false);
		        hhh.setMovementMethod(ScrollingMovementMethod.getInstance());
		     
		       songtitle.addView(view);
		
	  }
	  //播放音乐时的主界面布局初始化
	  
	    public   void  initbofangjiemian(FunctionM   bofangmusic){
	    	  
	    	try {
				     bofangmusic.start(gequmingzi);
				     
				     Log.i(TAG, gequmingzi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			seekbar.setMax(bofangmusic.player.getDuration());   //给seekbar添加具体的时间
		//   Log.i(TAG, "进度"+bofangmusic.player.getDuration());
		    longshijian = bofangmusic.player.getDuration();
		      longshijian1 = new haomiaotoshijian().formattime(longshijian);
		      zongshijian.setText(longshijian1);
		       if(!judge)
		      bofangshijian.setText("00:00");
	    }
	    
	    //当按下下一首按钮时的主界面布局初始化或者是暂停完后，重新播放接下来的歌曲
	    public   void   initnextbofangjiemian(FunctionM   bofangmusic){ 
	    	//bofangmusic.player.start();     //为何是空指针
	   	List<String>gequminzi = uiassit.huodegedan();
	    	for(int i = 0 ; i < gequminzi.size(); i++){
	    		     if(gequmingzi.equals(gequminzi.get(i))){
	    		    	       try {
								   Log.i(TAG, gequminzi.get(i+j));
	    		    	    	   bofangmusic.start(gequminzi.get(i+j));
				                  //判断3种不同的播放模式
	    		    	    	   
								    j++;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    		     }
	    	}
	     	seekbar.setMax(bofangmusic.player.getDuration());   //给seekbar添加具体的时间
	//   Log.i(TAG, "进度"+bofangmusic.player.getDuration());
	    longshijian = bofangmusic.player.getDuration();
	      longshijian1 = new haomiaotoshijian().formattime(longshijian);
	      zongshijian.setText(longshijian1);
	       if(!judge)
	      bofangshijian.setText("00:00");
	}
	    
	 
	  
	  /**
	   * 进入页面后自动播放音乐，是顺序播放
	   * @throws InterruptedException
	   */
	    private    void    bofangmusic() throws InterruptedException{
	     	 
	    	if(!flag) 
			 {
				 uiassit.disappear(bofang);
				 uiassit.show(zanting);
				 flag = true;
			 }
	    		 initbofangjiemian(bofangmusic);
	    		 new Thread(new shunxubofang()).start();
	    		// jumprepeat = false;
	    		// jumprandom = false;
		
		
	    }
	   
	 /**
	  *   当前歌曲完成后自动播放下一首歌曲，也就是顺序播放
	  *   参数 i 用做加的歌曲顺序
	  */
	       public     void      nextsong (int  i,FunctionM  xiayishoumusic){
	    	                try {
	    	                 
	    	                	int    position   = new chuandishuju().getIndex();     //得到播放完的歌曲的索引
	    	                 Log.i(TAG, position+"");     
	    	                	List<HashMap<String,Object>>gequliebiao = new ArrayList<HashMap<String,Object>>();
								      gequliebiao = uiassit.creategedan();
								     
								       xiayishougequmingzi = gequliebiao.get(position+i).get("geming").toString();
								       new  chuandishuju().setNextsongname(xiayishougequmingzi);
								       new  chuandishuju().setIndex(position+i);        //记录不管是顺序播放还是随机播放还是循环播放当前播放歌曲在数据源中的位置
								         Log.i(TAG, position+ i +"");
	    	                	        xiayishoumusic.start(xiayishougequmingzi);
	    	                	   new Thread(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										  runOnUiThread(new Runnable() {
												
												@Override
												public void run() {
													// TODO Auto-generated method stub
													inithuadongtitlecontent(xiayishougequmingzi);
												}
											});
									}
								}).start();
	    	                	   
	    	                	   	} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	      }
	       /**
	        * 重新播放下一首
	        */
	       public  void   chongxinshunxubofang(){
	    	      new Thread (new restartbofang()).start();
	       }
	      /**
	       *  随机播放列表中的歌曲
	       */
	       public  void   randombofang(){
	    	       new Thread(new randombofang()).start();
	    	                                          //跳出顺序播放的循环线程
	       }
	       /**
	        * 单曲循环当前播放的歌曲
	        */
	       public  void   repeatbofang(){
	    	         new Thread(new repeatbofang()).start();
	    	        jumprandom = false;
	    	        jumpshunxu = false;
	       }
	       /**
	        * 随机播放下一首歌曲
	        * @param xiayishoumusic
	        */
	       public  void  randomnextsong(FunctionM  xiayishoumusic){
	    	   try {
	                 int  length;         //歌曲装载的数据源的长度
	                 int  position;      //随机的位置
             	     List<String > gequming = new ArrayList<String>();
					     gequming = uiassit.huodegedan();
					  
					     length = gequming.size();
					     Log.i(TAG, length+"");
					     Random   random = new Random();
					     position = Math.abs(random.nextInt()%(length));
					     new chuandishuju().setIndex(position);     
					     Log.i(TAG, position+"");
				        xiayishougequmingzi = gequming.get(position).toString();
					   //      Log.i(TAG, position+ i +"");
               	        xiayishoumusic.start(xiayishougequmingzi);
               	   new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							  runOnUiThread(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										inithuadongtitlecontent(xiayishougequmingzi);
									}
								});
						}
					}).start();
               	   
               	   	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       }
	       /**
	        * 单曲循环当前歌曲
	        */
	           public  void   repeatcurrentsong(FunctionM   xiayishoumusic){
	        	   try {
		                
		             	int    position   = new chuandishuju().getIndex();     //得到播放完的歌曲的索引
		             	Log.i(TAG, position+"");
	                   	List<HashMap<String,Object>>gequliebiao = new ArrayList<HashMap<String,Object>>();
						      gequliebiao = uiassit.creategedan();
						  
					        xiayishougequmingzi = gequliebiao.get(position).get("geming").toString();
						   //      Log.i(TAG, position+ i +"");
	               	        xiayishoumusic.start(xiayishougequmingzi);
	               	   new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								  runOnUiThread(new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											inithuadongtitlecontent(xiayishougequmingzi);
										}
									});
							}
						}).start();
	               	   
	               	   	} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           }
	/**
	 * 初始化viewpager
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

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	   switch (v.getId()) {
	   
	   case R.id.suoxiao:
		    finish();
		  if(bofangmusic.player != null){
		    bofangmusic.player.stop();     //stop后需要prepare才行
		    bofangmusic.player.reset();    //处在空闲状态
		    judgekong  = 1;
		    jumpshunxu = false;
		  }
		  if(xiayishoumusic.player != null){
			  xiayishoumusic.player.stop();
			  xiayishoumusic.player.reset();
            judgekong = 1;
            jumpshunxu  = false;
		  }
		    break;
	case R.id.bofang:
	    	 if(!flag) 
		 {
			 uiassit.disappear(bofang);
			 uiassit.show(zanting);
			 flag = true;
		 }
		 
		
		 if(bofangmusic.player != null)
        initbofangjiemian(bofangmusic);
       if(xiayishoumusic.player != null)
          initnextbofangjiemian(xiayishoumusic);
    
		 break;
	case R.id.wholezhujiemian:
		 if(menupopwindow != null)
		menupopwindow.dismiss();
		 break;
	case R.id.zanting:
		 if(flag){
			 uiassit.disappear(zanting);
             uiassit.show(bofang);
             flag = false;
             judge = true;
		 }
		 if(bofangmusic.player !=null)
		bofangmusic.pause();
		 else{
			     xiayishoumusic.pause();
		 }
		 break;
	case R.id.xiayishou:
		       bofangmusic.player = null;
		      xiayishoubofang();
           
		       
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
	case R.id.gongneng:
		 if(flagbofangrule == 1){
		    
		     gongneng.setImageResource(R.drawable.tupian1);     //随机播放播放模式
			 flagbofangrule =2;
			 starttime = System.currentTimeMillis();   //当前系统的时间
			 initjieshaofunction(1);
			 new Thread(new myintroduction()).start();
			 randombofang();
			 jumpshunxu  = false;  
			 jumprandom = true;
			 
			 
		 }
		 else if(flagbofangrule == 2){
		
			 gongneng.setImageResource(R.drawable.neng1);       //切换到单曲循环模式
			 flagbofangrule =3 ;
			  starttime = System.currentTimeMillis();      //当前系统的时间
			  initjieshaofunction(2);
			  new Thread(new myintroduction()).start();
			  repeatbofang();
			  jumprandom =false;
			  jumpshunxu = false;
			  jumprepeat = true;
			  
			 
		 }else{
		
			 gongneng.setImageResource(R.drawable.neng);       //切换到顺序播放模式
			 flagbofangrule = 1;
			 starttime = System.currentTimeMillis();     //当前系统的时间
				 initjieshaofunction(3);
				 new Thread(new myintroduction()).start();
		         chongxinshunxubofang();
				 jumprepeat = false;
				 jumprandom = false;
				 jumpshunxu = true;
		 }
		
		 break;
	case R.id.collect:
		 if(flagcollectrule == 1 ){
			 collect.setImageResource(R.drawable.heart1);
			 Log.i(TAG,	 "1");
			 flagcollectrule =2;
			 //给我的最爱的列表栏里面添加喜欢的歌曲,采用application，全局对象
		     chuandishuju shuju = (chuandishuju)getApplicationContext();
			 shuju.setname(gequmingzi);
			 initshoucang();
			 new Thread (new myshoucang()).start();
			 
		     
		 }
		 else{
			   collect.setImageResource(R.drawable.collect);    //在点一下取消喜欢
			   flagcollectrule =1 ;
			    Log.i(TAG,	 "2");
		 }
		 break;
     }
	  
	  
		   
	}
	public void initshoucang(){
		 View  shoucang = getLayoutInflater().inflate(R.layout.shoucang_layout, null);
		 collectlike = new PopupWindow(shoucang,500,70);
		 collectlike.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.CENTER_VERTICAL, 0, -260);//后面两个参数是x，y
	}
	
	 //下一首按钮的功能
	 public  void  xiayishoubofang() {
		             
		             bofangmusic.player = null;
		             int   position = new chuandishuju().getIndex() +1 ;
                     new chuandishuju().setIndex(position);
                     List<HashMap<String,Object>>gequliebiao = new ArrayList<HashMap<String,Object>>();
				     gequliebiao = uiassit.creategedan();
				     xiayishougequmingzi = gequliebiao.get(position).get("geming").toString();
                    initnextbofangjiemian(xiayishoumusic);	
               //     new Thread(new shunxubofang()).start();
   }
                       
	 
	 public void initjieshaofunction(int select ){
		 switch (select) {
		case 1:
			View functionintroduce = getLayoutInflater().inflate(R.layout.introduceframe, null);  //弹出介绍界面
		      introduction = new PopupWindow(functionintroduce,500,70);
		      introduction.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.CENTER_VERTICAL, 0,-260); 
			break;
		case 2 :
			 View functionintroduce1 = getLayoutInflater().inflate(R.layout.introduceframe1, null);
			 introduction = new PopupWindow(functionintroduce1,500,70);
			 introduction.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.CENTER_VERTICAL, 0, -260);
			 break;
		case 3:
			 View functionintroduce2 = getLayoutInflater().inflate(R.layout.introduceframe2, null);
			 introduction = new PopupWindow(functionintroduce2,500,70);
			 introduction.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.CENTER_VERTICAL, 0, -260);
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
	   // menupopwindow.setOutsideTouchable(true);
	/*	gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "sdf", 0).show();
				Log.i(TAG, "dsfdsf");
			}
			
		});*/
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
	 
	
	 
	 public class myintroduction implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(450);
				endtime = System.currentTimeMillis();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					if(introduction != null && introduction.isShowing() && endtime - starttime  - 450 < 50 && endtime - starttime - 450 > 0 )
					 {
						
						introduction.dismiss();
					 }
					//if(endtime - starttime - 1500 <0 && introduction != null)  
					//	introduction.dismiss();
					//introduction.dismiss();
				}
			});
			
		}	
		 
	 }
	
	 
	 public   class   shunxubofang  implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 while(jumpshunxu)
				{     
					  if(bofangmusic.player != null)
					  {	 
						  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//获得当前播放的进度值
					  }
					  if(xiayishoumusic.player != null){
					         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //获得接下来一首歌的当前播放进度
					  }
						  //判断一首歌是否结束，结束则释放MediaPlayer资源,
					 //getduration 和  getCurrentPosition 不相等，不知是为何？
	                       if(bofangshijian.getText().equals(zongshijian.getText())){
	            	             if(panduanshifang == 1) {
	            	            	 bofangmusic.player.stop();    
	            	                 bofangmusic.player.reset();
	                  	            bofangmusic.player = null;      //释放上一首歌的Mediaplayer对象
	                  	            panduanshifang = 2;
	                  	              addindex = 1;
	            	             }
	            	             else{
	            	            	   if(xiayishoumusic.player != null){
	            	            	 xiayishoumusic.player.stop();    
	            	                 xiayishoumusic.player.reset();
	                  	             xiayishoumusic.player = null;      //释放下一首歌的Mediaplayer对象
	                  	             addindex = 1;
	            	             }
	            	             }
	                  if(judgekong != 1)    {
	                     nextsong(addindex,xiayishoumusic);
	            	     runOnUiThread( new Runnable() {                                      //更改主界面的线程
					 	public void run() {
							   initbofangjiemian(xiayishoumusic);
					 	}
					});
	            	    }
	         	  //     break;
	             }
					 try {
						  	Thread.sleep(1000);
					  
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
 }
	 
	 public  class   randombofang  implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 while(jumprandom)
				{     
					  if(bofangmusic.player != null)
					  {	 
						  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//获得当前播放的进度值
					  }
					  if(xiayishoumusic.player != null){
					         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //获得接下来一首歌的当前播放进度
					  }
						  //判断一首歌是否结束，结束则释放MediaPlayer资源,
					 //getduration 和  getCurrentPosition 不相等，不知是为何？
	                       if(bofangshijian.getText().equals(zongshijian.getText())){
	            	             if(panduanshifang == 1) {
	            	            	 bofangmusic.player.stop();    
	            	                 bofangmusic.player.reset();
	                  	            bofangmusic.player = null;      //释放上一首歌的Mediaplayer对象
	                  	            panduanshifang = 2;
	                  	 //             addindex = 1;        
	                  	         
	            	             }
	            	             else{
	            	            	   if(xiayishoumusic.player != null){
	            	            	     xiayishoumusic.player.stop();    
	            	                     xiayishoumusic.player.reset();
	                  	                xiayishoumusic.player = null;      //释放下一首歌的Mediaplayer对象
	                  	        }
	            	             }
	                  if(judgekong != 1)    {
	                    randomnextsong(xiayishoumusic); 
	            	     runOnUiThread( new Runnable() {                                      //更改主界面的线程
					 	public void run() {
							   initbofangjiemian(xiayishoumusic);
					 	}
					});
	            	    }
	         	  //     break;
	             }
					 try {
						  	Thread.sleep(1000);
					  
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
 }
	    public  class    repeatbofang  implements  Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				 while(jumprepeat)
					{     
						  if(bofangmusic.player != null)
						  {	 
							  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//获得当前播放的进度值
						  }
						  if(xiayishoumusic.player != null){
						         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //获得接下来一首歌的当前播放进度
						  }
							  //判断一首歌是否结束，结束则释放MediaPlayer资源,
						 //getduration 和  getCurrentPosition 不相等，不知是为何？
		                       if(bofangshijian.getText().equals(zongshijian.getText())){
		            	             if(panduanshifang == 1) {
		            	            	 bofangmusic.player.stop();    
		            	                 bofangmusic.player.reset();
		                  	            bofangmusic.player = null;      //释放上一首歌的Mediaplayer对象
		                  	            panduanshifang = 2;
		                      }
		            	             else{
		            	            	   if(xiayishoumusic.player != null){
		            	            	     xiayishoumusic.player.stop();    
		            	                     xiayishoumusic.player.reset();
		                  	                xiayishoumusic.player = null;      //释放下一首歌的Mediaplayer对象
		                  	       }
		            	             }
		                  if(judgekong != 1)    {
		                    repeatcurrentsong(xiayishoumusic);
		            	     runOnUiThread( new Runnable() {                                      //更改主界面的线程
						 	public void run() {
								   initbofangjiemian(xiayishoumusic);
						 	}
						});
		            	    }
		         	  //     break;
		             }
						 try {
							  	Thread.sleep(1000);
						  
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
 }
	    public  class    restartbofang  implements  Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				 while(jumpshunxu)
					{     
						  if(bofangmusic.player != null)
						  {	 
							  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//获得当前播放的进度值
						  }
						  if(xiayishoumusic.player != null){
						         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //获得接下来一首歌的当前播放进度
						  }
							  //判断一首歌是否结束，结束则释放MediaPlayer资源,
						 //getduration 和  getCurrentPosition 不相等，不知是为何？
		                       if(bofangshijian.getText().equals(zongshijian.getText())){
		            	             if(panduanshifang == 1) {
		            	            	 bofangmusic.player.stop();    
		            	                 bofangmusic.player.reset();
		                  	            bofangmusic.player = null;      //释放上一首歌的Mediaplayer对象
		                  	            panduanshifang = 2;
		                  	             addindex = 1;
		                      }
		            	             else{
		            	            	   if(xiayishoumusic.player != null){
		            	            	     xiayishoumusic.player.stop();    
		            	                     xiayishoumusic.player.reset();
		                  	                xiayishoumusic.player = null;      //释放下一首歌的Mediaplayer对象
		                  	                readdindex = 1;
		            	            	   }
		            	             }
		                  if(judgekong != 1)    {
		                    nextsong(readdindex, xiayishoumusic);
		            	     runOnUiThread( new Runnable() {                                      //更改主界面的线程
						 	public void run() {
								   initbofangjiemian(xiayishoumusic);
						 	}
						});
		            	    }
		         	  //     break;
		             }
						 try {
							  	Thread.sleep(1000);
						  
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
 }
	 
	 public class myshoucang implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			  try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  runOnUiThread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					 if(collectlike != null && collectlike.isShowing()){
						 collectlike.dismiss();
					 }
				}
				  
			  });
		}
		 
	 }

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		
		String nowtime = new haomiaotoshijian().formattime(progress);
		//Log.i(TAG, progress+"");
		new chuandishuju().setCurrentprogress(progress);
		
		  if(nowtime.contains(":")){
			  bofangshijian.setText(nowtime);
			  }
		  else
			 bofangshijian.setText("00:"+nowtime); 	
		 
		  
		  
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		 if(bofangmusic.player != null)
		  bofangmusic.player.seekTo(seekbar.getProgress());
	 else{
			 xiayishoumusic.player.seekTo(seekbar.getProgress());
		 }
	}
	  
		  
	  
	  
}
