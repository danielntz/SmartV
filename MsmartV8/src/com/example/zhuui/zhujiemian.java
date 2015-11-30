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
	private   PopupWindow  menupopwindow;    //��������
	private   ImageView    rotatephoto;
	private  GridView   gridview;
	private  gridviewadapter   adapter;
	private  ImageView       collectlist;
	private  ImageView       collectfasong;
	boolean  flag = false;      //��������жϰ�ť�Ƿ���
	private  ViewPager  viewpager = null; 
	private  List<Fragment> fragments = null;
    private FunctionM   bofangmusic = new FunctionM();  //��ʼ��MediaPlayer,�������ŵ�ǰ���µĵ�һ��
    private  FunctionM    xiayishoumusic = new FunctionM();      //���¿���һ��Mediaplayer����,����������һ�׸�
	private  FragmentPagerAdapter  fpadapter;
	private  ImageView   leftdot;
	private  ImageView   middledot;
	private  ImageView   rightdot;
	private   int flagbofangrule ;    //1 ������ţ�2 ˳�򲥷�(�����б�ķ�ʽ) 3 ����ѭ�� 
	private   int flagcollectrule;    //1 ��ϲ�� 2 ϲ��
    private  PopupWindow  introduction;
    private  PopupWindow  collectlike;
    long starttime ;                     //��ǰ�߳̿���ʱ��
    long endtime  ;                     //��ǰ�߳̽���ʱ��
    private String gequmingzi = "";    //��ô��ݹ����ĸ�������
    private String geshoumingzi= "";  //��ô��ݹ����ĸ�������
    private  TextView  bofangshijian;
    private  TextView  zongshijian;
    private  long   longshijian;       //������Ӧ�������ܺ�����
    private  String  longshijian1;     //ת����ʱ���ʽ
    private  boolean   judge =  false;
    private  int       progress  = 1;            //�жϵ�ǰ��ĳ����Ƿ񻹱仯�� �仯˵��û���꣬û�仯˵����������
    private   int    panduanshifang  = 1;     //��1���ͷŵ�ǰ��������2,�ͷ���һ�׸���
    private    int     addindex = 0;
    private    int     readdindex = 0;        
    private   LayoutInflater   inflater;
    private   String  xiayishougequmingzi;
    private   int      judgekong;                   //��1ʱ���ͷſռ䣬��2ʱ�ͷ���һ�׸�ռ�
    private   boolean    jumpshunxu = true;                  //���������̵߳�ѭ��,����ĳһ���߳�
    private  boolean    jumprandom = true;
    private  boolean   jumprepeat = true;
    private  String    secondename ;
    private  int         j = 1 ;                                                      //������Ϊ˳�򲥷�
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhujiemian_layout);
	    
		
		//��ȡID
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
		bofangshijian = (TextView)findViewById(R.id.bofangshijian);    //���ֲ��ŵ�ʱ��
		zongshijian = (TextView)findViewById(R.id.zongshijian);        //���ֵ���ʱ��
		flagbofangrule =1 ;     //��ʼ����Ϊ�������
		gongneng.setImageResource(R.drawable.neng);
		flagcollectrule = 1;    //��ʼ��Ϊ��ϲ��
		//��ʼ��viewpaper
		initsetviewadapter();
		//��ʼ����ô��ݹ�����ֵ
		Intent intent =getIntent();
	    gequmingzi = intent.getStringExtra("geming");
	//	songtitle.setText(gequmingzi);          ��textview��Ӹ���������
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
		         View  view = inflater.inflate(R.layout.huadongsongtitle_layout, null);   //�ڼ����µĲ����ļ�ǰ��һ��Ҫָ��inflater�������ǿյ�
		        TextView   hhh = (TextView)view.findViewById(R.id.songtitlecontent);
		       hhh.setText("");
		       hhh.setText(gequmingzi);
		        hhh.setFocusable(false);
		        hhh.setMovementMethod(ScrollingMovementMethod.getInstance());
		     
		       songtitle.addView(view);
		
	  }
	  //��������ʱ�������沼�ֳ�ʼ��
	  
	    public   void  initbofangjiemian(FunctionM   bofangmusic){
	    	  
	    	try {
				     bofangmusic.start(gequmingzi);
				     
				     Log.i(TAG, gequmingzi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			seekbar.setMax(bofangmusic.player.getDuration());   //��seekbar��Ӿ����ʱ��
		//   Log.i(TAG, "����"+bofangmusic.player.getDuration());
		    longshijian = bofangmusic.player.getDuration();
		      longshijian1 = new haomiaotoshijian().formattime(longshijian);
		      zongshijian.setText(longshijian1);
		       if(!judge)
		      bofangshijian.setText("00:00");
	    }
	    
	    //��������һ�װ�ťʱ�������沼�ֳ�ʼ����������ͣ������²��Ž������ĸ���
	    public   void   initnextbofangjiemian(FunctionM   bofangmusic){ 
	    	//bofangmusic.player.start();     //Ϊ���ǿ�ָ��
	   	List<String>gequminzi = uiassit.huodegedan();
	    	for(int i = 0 ; i < gequminzi.size(); i++){
	    		     if(gequmingzi.equals(gequminzi.get(i))){
	    		    	       try {
								   Log.i(TAG, gequminzi.get(i+j));
	    		    	    	   bofangmusic.start(gequminzi.get(i+j));
				                  //�ж�3�ֲ�ͬ�Ĳ���ģʽ
	    		    	    	   
								    j++;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    		     }
	    	}
	     	seekbar.setMax(bofangmusic.player.getDuration());   //��seekbar��Ӿ����ʱ��
	//   Log.i(TAG, "����"+bofangmusic.player.getDuration());
	    longshijian = bofangmusic.player.getDuration();
	      longshijian1 = new haomiaotoshijian().formattime(longshijian);
	      zongshijian.setText(longshijian1);
	       if(!judge)
	      bofangshijian.setText("00:00");
	}
	    
	 
	  
	  /**
	   * ����ҳ����Զ��������֣���˳�򲥷�
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
	  *   ��ǰ������ɺ��Զ�������һ�׸�����Ҳ����˳�򲥷�
	  *   ���� i �����ӵĸ���˳��
	  */
	       public     void      nextsong (int  i,FunctionM  xiayishoumusic){
	    	                try {
	    	                 
	    	                	int    position   = new chuandishuju().getIndex();     //�õ�������ĸ���������
	    	                 Log.i(TAG, position+"");     
	    	                	List<HashMap<String,Object>>gequliebiao = new ArrayList<HashMap<String,Object>>();
								      gequliebiao = uiassit.creategedan();
								     
								       xiayishougequmingzi = gequliebiao.get(position+i).get("geming").toString();
								       new  chuandishuju().setNextsongname(xiayishougequmingzi);
								       new  chuandishuju().setIndex(position+i);        //��¼������˳�򲥷Ż���������Ż���ѭ�����ŵ�ǰ���Ÿ���������Դ�е�λ��
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
	        * ���²�����һ��
	        */
	       public  void   chongxinshunxubofang(){
	    	      new Thread (new restartbofang()).start();
	       }
	      /**
	       *  ��������б��еĸ���
	       */
	       public  void   randombofang(){
	    	       new Thread(new randombofang()).start();
	    	                                          //����˳�򲥷ŵ�ѭ���߳�
	       }
	       /**
	        * ����ѭ����ǰ���ŵĸ���
	        */
	       public  void   repeatbofang(){
	    	         new Thread(new repeatbofang()).start();
	    	        jumprandom = false;
	    	        jumpshunxu = false;
	       }
	       /**
	        * ���������һ�׸���
	        * @param xiayishoumusic
	        */
	       public  void  randomnextsong(FunctionM  xiayishoumusic){
	    	   try {
	                 int  length;         //����װ�ص�����Դ�ĳ���
	                 int  position;      //�����λ��
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
	        * ����ѭ����ǰ����
	        */
	           public  void   repeatcurrentsong(FunctionM   xiayishoumusic){
	        	   try {
		                
		             	int    position   = new chuandishuju().getIndex();     //�õ�������ĸ���������
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
	 * ��ʼ��viewpager
	 */
	private void initsetviewadapter() {
		// TODO Auto-generated method stub
		  viewpager = (ViewPager)findViewById(R.id.pager);
		  //�������л�fragment���뼯����
		  fragments = new ArrayList<Fragment>();
		  fragments.add(new songstudio());
		  fragments.add(new appreciatephoto());
		  fragments.add(new songword());
		  fpadapter = new mypageeradapter(getSupportFragmentManager(),fragments);
		  //����������
		  viewpager.setAdapter(fpadapter);
		  viewpager.setCurrentItem(1);      //Ĭ�ϵڶ���fragment������ʾ
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
		    bofangmusic.player.stop();     //stop����Ҫprepare����
		    bofangmusic.player.reset();    //���ڿ���״̬
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
			
			init(); //�����ˆν���
		}
		 break;
	case R.id.gongneng:
		 if(flagbofangrule == 1){
		    
		     gongneng.setImageResource(R.drawable.tupian1);     //������Ų���ģʽ
			 flagbofangrule =2;
			 starttime = System.currentTimeMillis();   //��ǰϵͳ��ʱ��
			 initjieshaofunction(1);
			 new Thread(new myintroduction()).start();
			 randombofang();
			 jumpshunxu  = false;  
			 jumprandom = true;
			 
			 
		 }
		 else if(flagbofangrule == 2){
		
			 gongneng.setImageResource(R.drawable.neng1);       //�л�������ѭ��ģʽ
			 flagbofangrule =3 ;
			  starttime = System.currentTimeMillis();      //��ǰϵͳ��ʱ��
			  initjieshaofunction(2);
			  new Thread(new myintroduction()).start();
			  repeatbofang();
			  jumprandom =false;
			  jumpshunxu = false;
			  jumprepeat = true;
			  
			 
		 }else{
		
			 gongneng.setImageResource(R.drawable.neng);       //�л���˳�򲥷�ģʽ
			 flagbofangrule = 1;
			 starttime = System.currentTimeMillis();     //��ǰϵͳ��ʱ��
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
			 //���ҵ�����б����������ϲ���ĸ���,����application��ȫ�ֶ���
		     chuandishuju shuju = (chuandishuju)getApplicationContext();
			 shuju.setname(gequmingzi);
			 initshoucang();
			 new Thread (new myshoucang()).start();
			 
		     
		 }
		 else{
			   collect.setImageResource(R.drawable.collect);    //�ڵ�һ��ȡ��ϲ��
			   flagcollectrule =1 ;
			    Log.i(TAG,	 "2");
		 }
		 break;
     }
	  
	  
		   
	}
	public void initshoucang(){
		 View  shoucang = getLayoutInflater().inflate(R.layout.shoucang_layout, null);
		 collectlike = new PopupWindow(shoucang,500,70);
		 collectlike.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.CENTER_VERTICAL, 0, -260);//��������������x��y
	}
	
	 //��һ�װ�ť�Ĺ���
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
			View functionintroduce = getLayoutInflater().inflate(R.layout.introduceframe, null);  //�������ܽ���
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
		//�����˵�
		View  tanchuview = getLayoutInflater().inflate(R.layout.tanchumenu, null);    //��õ�������Ĳ��� 
		gridview = (GridView)tanchuview.findViewById(R.id.showthing);       //����gridview,�ĸ�������gridview�ʹ��ĸ�����Ѱ��R.id  
		gridviewadapter hhh = new gridviewadapter(this);
		gridview.setAdapter(hhh);
		menupopwindow = new PopupWindow(tanchuview,500,350);                          //���õ������棬��ȣ��߶�
		//menupopwindow.setFocusable(true);                                           //��ȡ�����˵��Ľ���
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
     	menupopwindow.showAtLocation(this.findViewById(R.id.wholezhujiemian), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //������λ��
	  }
	  
	 public class seekbartongbu implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
			
			try {
				Thread.sleep(1000);
				seekbar.setProgress(bofangmusic.player.getCurrentPosition()); //��õ�ǰ���ŵĽ���ֵ
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
						  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//��õ�ǰ���ŵĽ���ֵ
					  }
					  if(xiayishoumusic.player != null){
					         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //��ý�����һ�׸�ĵ�ǰ���Ž���
					  }
						  //�ж�һ�׸��Ƿ�������������ͷ�MediaPlayer��Դ,
					 //getduration ��  getCurrentPosition ����ȣ���֪��Ϊ�Σ�
	                       if(bofangshijian.getText().equals(zongshijian.getText())){
	            	             if(panduanshifang == 1) {
	            	            	 bofangmusic.player.stop();    
	            	                 bofangmusic.player.reset();
	                  	            bofangmusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
	                  	            panduanshifang = 2;
	                  	              addindex = 1;
	            	             }
	            	             else{
	            	            	   if(xiayishoumusic.player != null){
	            	            	 xiayishoumusic.player.stop();    
	            	                 xiayishoumusic.player.reset();
	                  	             xiayishoumusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
	                  	             addindex = 1;
	            	             }
	            	             }
	                  if(judgekong != 1)    {
	                     nextsong(addindex,xiayishoumusic);
	            	     runOnUiThread( new Runnable() {                                      //������������߳�
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
						  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//��õ�ǰ���ŵĽ���ֵ
					  }
					  if(xiayishoumusic.player != null){
					         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //��ý�����һ�׸�ĵ�ǰ���Ž���
					  }
						  //�ж�һ�׸��Ƿ�������������ͷ�MediaPlayer��Դ,
					 //getduration ��  getCurrentPosition ����ȣ���֪��Ϊ�Σ�
	                       if(bofangshijian.getText().equals(zongshijian.getText())){
	            	             if(panduanshifang == 1) {
	            	            	 bofangmusic.player.stop();    
	            	                 bofangmusic.player.reset();
	                  	            bofangmusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
	                  	            panduanshifang = 2;
	                  	 //             addindex = 1;        
	                  	         
	            	             }
	            	             else{
	            	            	   if(xiayishoumusic.player != null){
	            	            	     xiayishoumusic.player.stop();    
	            	                     xiayishoumusic.player.reset();
	                  	                xiayishoumusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
	                  	        }
	            	             }
	                  if(judgekong != 1)    {
	                    randomnextsong(xiayishoumusic); 
	            	     runOnUiThread( new Runnable() {                                      //������������߳�
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
							  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//��õ�ǰ���ŵĽ���ֵ
						  }
						  if(xiayishoumusic.player != null){
						         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //��ý�����һ�׸�ĵ�ǰ���Ž���
						  }
							  //�ж�һ�׸��Ƿ�������������ͷ�MediaPlayer��Դ,
						 //getduration ��  getCurrentPosition ����ȣ���֪��Ϊ�Σ�
		                       if(bofangshijian.getText().equals(zongshijian.getText())){
		            	             if(panduanshifang == 1) {
		            	            	 bofangmusic.player.stop();    
		            	                 bofangmusic.player.reset();
		                  	            bofangmusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
		                  	            panduanshifang = 2;
		                      }
		            	             else{
		            	            	   if(xiayishoumusic.player != null){
		            	            	     xiayishoumusic.player.stop();    
		            	                     xiayishoumusic.player.reset();
		                  	                xiayishoumusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
		                  	       }
		            	             }
		                  if(judgekong != 1)    {
		                    repeatcurrentsong(xiayishoumusic);
		            	     runOnUiThread( new Runnable() {                                      //������������߳�
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
							  seekbar.setProgress(bofangmusic.player.getCurrentPosition()); 	//��õ�ǰ���ŵĽ���ֵ
						  }
						  if(xiayishoumusic.player != null){
						         seekbar.setProgress(xiayishoumusic.player.getCurrentPosition());  //��ý�����һ�׸�ĵ�ǰ���Ž���
						  }
							  //�ж�һ�׸��Ƿ�������������ͷ�MediaPlayer��Դ,
						 //getduration ��  getCurrentPosition ����ȣ���֪��Ϊ�Σ�
		                       if(bofangshijian.getText().equals(zongshijian.getText())){
		            	             if(panduanshifang == 1) {
		            	            	 bofangmusic.player.stop();    
		            	                 bofangmusic.player.reset();
		                  	            bofangmusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
		                  	            panduanshifang = 2;
		                  	             addindex = 1;
		                      }
		            	             else{
		            	            	   if(xiayishoumusic.player != null){
		            	            	     xiayishoumusic.player.stop();    
		            	                     xiayishoumusic.player.reset();
		                  	                xiayishoumusic.player = null;      //�ͷ���һ�׸��Mediaplayer����
		                  	                readdindex = 1;
		            	            	   }
		            	             }
		                  if(judgekong != 1)    {
		                    nextsong(readdindex, xiayishoumusic);
		            	     runOnUiThread( new Runnable() {                                      //������������߳�
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
