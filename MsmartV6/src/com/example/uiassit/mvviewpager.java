package com.example.uiassit;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class mvviewpager extends FragmentPagerAdapter {
   
	public List<Fragment> fragments = new ArrayList<Fragment>();
	public mvviewpager(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	public mvviewpager(FragmentManager fragmentmanager , List<Fragment> frg){
		super(fragmentmanager);
		this.fragments = frg;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}
	

}
