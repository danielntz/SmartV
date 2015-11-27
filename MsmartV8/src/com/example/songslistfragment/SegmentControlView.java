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
 *    �Զ���ؼ�
 * @author jsjxy
 *
 */
public class SegmentControlView     extends  LinearLayout{
             
	    private   TextView     textview1  = null ;    //����������
	    private   TextView     textview2  = null ;   //��������Ƶ
	    private  TextView      line = null   ;                 //�м�����
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
    //��ʼ��
    public void init(){
    textview1 = new TextView(getContext());
    textview2 = new TextView(getContext());
    line     =  new TextView(getContext());

    
    //�Á������ؼ��Ĵ�С
    textview1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
    line.setLayoutParams(new LayoutParams(1,LayoutParams.MATCH_PARENT));
    textview2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
   
    
    //��ӿؼ����ּ���С
    textview1.setText("�����ص�����");
    textview2.setText("�����ص���Ƶ");
   
    textview1.setTextSize(16);
    textview2.setTextSize(16);
   
    //�������ֵ���ɫ������ѡ����
		XmlPullParser xrp = getResources().getXml(R.drawable.anniu); 
	    try {  
	        ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);  
	        textview1.setTextColor(csl);
	        textview2.setTextColor(csl);
	     
	      } catch (Exception e) {  
	    } 
    
    //�ؼ��ڲ����е�λ��
    textview1.setGravity(Gravity.CENTER);
    textview2.setGravity(Gravity.CENTER);

    textview1.setPadding(3, 6, 3, 6);
    textview2.setPadding(3, 6, 3, 6);
    
    textview1.setBackgroundResource(R.drawable.left);
    textview2.setBackgroundResource(R.drawable.right);
   
    line.setBackgroundColor(getResources().getColor(R.color.blue));
   
    
    //�ڴ˲�����������
    this.removeAllViews();
    this.addView(textview1);
    this.addView(line);
    this.addView(textview2);
   
    this.invalidate();
    textview1.setSelected(true);
    
    
    //��Ӽ����¼�
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
