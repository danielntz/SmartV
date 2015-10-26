package com.example.zhuui;

import java.util.ArrayList;
import java.util.List;

import com.example.uiassit.mvviewpager;
import com.example.viewpager.aboutmv;
import com.example.viewpager.aboutxinxi;
import com.jerome.weibo.*;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class videoshow  extends FragmentActivity{
       
	  private ViewPager   viewpager;
	  private List<Fragment> jiemian = null;   //装载fragment
	  private mvviewpager  pager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);    //取消标题
		setContentView(R.layout.videoshow_layout);
		viewpager = (ViewPager)findViewById(R.id.about);
		jiemian = new ArrayList<Fragment>();
		jiemian.add(new aboutmv());
		jiemian.add(new aboutxinxi());
		pager = new mvviewpager(getSupportFragmentManager(), jiemian);
		viewpager.setAdapter(pager);
		viewpager.setCurrentItem(0);
		viewpager.setOnPageChangeListener(null);
	}
}
