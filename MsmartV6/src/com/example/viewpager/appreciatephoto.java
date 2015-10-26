package com.example.viewpager;

import com.example.uiassit.chuandishuju;
import com.jerome.weibo.R;

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

public class appreciatephoto   extends Fragment{
    
	private  ImageView rotatephoto; 
	private  TextView  geshoumingzi;
	private  String geshouname = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View fragment1 = inflater.inflate(R.layout.fragment2_layout,container, false);
		 rotatephoto =(ImageView)fragment1.findViewById(R.id.rotatephoto);
		 geshoumingzi = (TextView)fragment1.findViewById(R.id.authername);
		 geshouname = new chuandishuju().getgeshouname();
		 geshoumingzi.setText(geshouname);
		 rotatephoto();
		 return  fragment1;
	}
	
	//Ðý×ªÍ¼Æ¬
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
	 

}
