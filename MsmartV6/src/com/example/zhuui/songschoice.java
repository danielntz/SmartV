package com.example.zhuui;

import com.example.uiassit.songuiadapter;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

import android.app.Activity;
import android.inputmethodservice.Keyboard.Key;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class songschoice  extends Activity implements OnTouchListener, OnClickListener, OnItemClickListener{
       
	  private PopupWindow   songselect ;
	  private GridView  gridview1 ;
	  private songuiadapter  hhh2;
	  private LinearLayout  quxiao;
	  private Button    buttonquxiao;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);       //取消标题
		setContentView(R.layout.songschoice_layout);
	    gridview1 = (GridView) findViewById(R.id.songfunction);
	    quxiao = (LinearLayout)findViewById(R.id.quxiao);
	    buttonquxiao = (Button)findViewById(R.id.cancel);
	  	hhh2= new songuiadapter(new uiassit().tubiao(), this);
		gridview1.setAdapter(hhh2);
		quxiao.setOnTouchListener(this);
		gridview1.setOnItemClickListener(this);
		buttonquxiao.setOnClickListener(this);
		
		 
	}
	
	public void init(){
		
		
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.quxiao:
			 if(event.getAction() == MotionEvent.ACTION_DOWN)
				 finish();
			break;
	
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancel:
			 finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if(position == 0)
		 Toast.makeText(this, "sfsdf", 0).show();
		if(position == 1)
			 Toast.makeText(this, "tttttt", 0).show();
	}
   
}
