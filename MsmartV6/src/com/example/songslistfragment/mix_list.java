package com.example.songslistfragment;

import com.jerome.weibo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class mix_list  extends Fragment{
	
	   private ListView listview;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment3 = inflater.inflate(R.layout.mix_list_layout, container, false);
		 listview = (ListView)fragment3.findViewById(R.id.gequliebiao);
	     
		 
		 
		 
		 return  fragment3;
	}
}
