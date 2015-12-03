package com.example.viewpager;

import com.example.Mfunction.FunctionM;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.uiassit;
import com.example.zhuui.videoshow;
import com.jerome.weibo.R;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class appreciatephoto   extends Fragment implements android.view.View.OnClickListener{
    
	private  ImageView rotatephoto; 
	private  TextView  geshoumingzi;
	private  String geshouname = "";
	private  TextView   MV ;                         //点击弹出播放MV界面
	private  TextView   Info;                        //点击弹出当前歌曲的信息
	private   FunctionM      current ;      //获得主界面的音乐播放对象
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View fragment1 = inflater.inflate(R.layout.fragment2_layout,container, false);
		 rotatephoto =(ImageView)fragment1.findViewById(R.id.rotatephoto);
		 MV = (TextView)fragment1.findViewById(R.id.lookmv);
		 Info = (TextView)fragment1.findViewById(R.id.detail);
		 geshoumingzi = (TextView)fragment1.findViewById(R.id.authername);
		 geshouname = new chuandishuju().getgeshouname();
		 current = new chuandishuju().getTomv();
		 geshoumingzi.setText(geshouname);
		 MV.setOnClickListener(this);
		 rotatephoto();
		 return  fragment1;
	}
	
	public  void    zantingmusic(){
	  
		
		 if(current.player !=null)
		current.pause();
		 else{
			     current.pause();
		 }
	
	}
	
	//旋转图片
	public void rotatephoto(){
		/*AnimationSet  animationset = new AnimationSet(true);
		RotateAnimation  rotateanimation  = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateanimation.setDuration(1000);
		rotateanimation.setFillBefore(true);
		rotateanimation.setRepeatCount(-1);
		animationset.addAnimation(rotateanimation);
		
		rotatephoto.startAnimation(animationset);*/
		Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotatephoto);
		LinearInterpolator lin = new LinearInterpolator();
		animation.setInterpolator(lin);
		rotatephoto.startAnimation(animation);
		
	}
	public void rotatepicture(){
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		      switch (v.getId()) {
			case R.id.lookmv:
				      zantingmusic();
				       Intent   intent  = new Intent();
				       intent.setClass(getActivity(), videoshow.class);
				       Bundle    bundle   = new Bundle();
				       bundle.putInt("mvbiaoqian", 1);
				       intent.putExtras(bundle);                        //传递给videoshow界面
				       startActivity(intent);
				break;

		
			}
	}

	
	 

}
