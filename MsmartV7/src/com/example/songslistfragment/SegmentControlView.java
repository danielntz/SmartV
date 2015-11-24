package com.example.songslistfragment;




import org.xmlpull.v1.XmlPullParser;


import com.jerome.weibo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
/**
 *    自定义控件
 * @author jsjxy
 *
 */
public class SegmentControlView     extends  LinearLayout{
             
	    private   TextView     textview1  = null ;    //已下载音乐
	    private   TextView     textview2  = null ;   //已下载视频
	    private  TextView      line = null   ;                 //中间竖线
	   private  OnsegmentControler    listener;  
	  private   SegmentControlView  view1 = null;
	
	public SegmentControlView(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
     
     public SegmentControlView(Context context, AttributeSet attrs) {
  		super(context, attrs);
  		init();
  	}
  	
  	@SuppressLint("NewApi")
 	public SegmentControlView(Context context, AttributeSet attrs, int defStyleAttr) {
  		super(context, attrs, defStyleAttr);
  		init();
  	}
    //初始化
    public void init(){
    textview1 = new TextView(getContext());
    textview2 = new TextView(getContext());
    line     =  new TextView(getContext());

    
    //用來描述控件的大小
    textview1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
    line.setLayoutParams(new LayoutParams(1,LayoutParams.MATCH_PARENT));
    textview2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
   
    
    //添加控件文字及大小
    textview1.setText("已下载的音乐");
    textview2.setText("已下载的视频");
   
    textview1.setTextSize(16);
    textview2.setTextSize(16);
   
    //设置文字的颜色，背景选择器
		XmlPullParser xrp = getResources().getXml(R.drawable.anniu); 
	    try {  
	        ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);  
	        textview1.setTextColor(csl);
	        textview2.setTextColor(csl);
	     
	      } catch (Exception e) {  
	    } 
    
    //控件在布局中的位置
    textview1.setGravity(Gravity.CENTER);
    textview2.setGravity(Gravity.CENTER);

    textview1.setPadding(3, 6, 3, 6);
    textview2.setPadding(3, 6, 3, 6);
    
    textview1.setBackgroundResource(R.drawable.left);
    textview2.setBackgroundResource(R.drawable.right);
   
    line.setBackgroundColor(getResources().getColor(R.color.blue));
   
    
    //在此布局上添加组件
    this.removeAllViews();
    this.addView(textview1);
    this.addView(line);
    this.addView(textview2);
   
    this.invalidate();
    textview1.setSelected(true);
    
    
    //添加监听事件
    textview1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(textview1.isSelected()){
				return ;
			}
			textview1.setSelected(true);
          textview2.setSelected(false);	
      
          if(listener !=null){
          	 listener.setOnsegment(textview1, 0);
          }
		}
	});
    
    textview2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(textview2.isSelected()){
				return ;
			}
			textview1.setSelected(false);
          textview2.setSelected(true);	
         
          if(listener !=null){
              listener.setOnsegment(textview2, 1);
          }
		}
		
	});
    
    
	
  }
   
    
    public void setOnsegmentlistenerclicker( OnsegmentControler listener){
  	          
  	     this.listener = listener;
    }   
	 
      
}
