package com.example.uiassit;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class mypageeradapter  extends FragmentPagerAdapter{
    
	private List<Fragment> fragmentlist = new ArrayList<Fragment>();
	
	
	public mypageeradapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
    
	public   mypageeradapter(FragmentManager  fragmentManager, List<Fragment> fragments){
		    
		    super(fragmentManager);
		    this.fragmentlist = fragments;
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragmentlist.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return  fragmentlist.size();
	}

}
