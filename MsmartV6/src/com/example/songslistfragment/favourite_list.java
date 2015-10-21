package com.example.songslistfragment;

import com.example.uiassit.autocompletetextadapter;
import com.example.uiassit.gedanlistviewadapter;
import com.jerome.weibo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class favourite_list  extends Fragment{
   
	    private static final String TAG = null;
		private gedanlistviewadapter gedanadapter = null;
	    private ListView  myfavourite = null;
	    private AutoCompleteTextView  wodezuiaiauto = null;
	    private autocompletetextadapter wodezuiaiadapter = null;
	   
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment1 = inflater.inflate(R.layout.favourite_list_layout, container, false);
	  	
	//	 myfavourite = (ListView)fragment1.findViewById(R.id.gequliebiao);
	//	 wodezuiaiauto = (AutoCompleteTextView)fragment1.findViewById(R.id.sousuoneirong);
		 //获取Activity传递过来的值
		Bundle bundle = this.getArguments();
		String name = bundle.getString("ddd");
		Log.i(TAG, name);
		return  fragment1;
	}
      
	
	     
	
} 
