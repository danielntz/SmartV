package com.example.songslistfragment;

import java.util.HashMap;
import java.util.List;

import com.example.uiassit.autocompletetextadapter;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.gedanlistviewadapter;
import com.example.uiassit.gedanlistviewlikeadapter;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class favourite_list  extends Fragment implements OnItemClickListener{
   
	    private static final String TAG = null;
		private gedanlistviewlikeadapter gedanadapter = new gedanlistviewlikeadapter();
	    private ListView  myfavourite ;
	    private AutoCompleteTextView  wodezuiaiauto ;
	    private autocompletetextadapter wodezuiaiadapter = null;
	    private List<String> likesongname ;
	    private autocompletetextadapter automylike = null;
	    
	   
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment1 = inflater.inflate(R.layout.favourite_list_layout, container, false);
	  	
		 myfavourite = (ListView)fragment1.findViewById(R.id.gequliebiao1);
		 wodezuiaiauto = (AutoCompleteTextView)fragment1.findViewById(R.id.sousuoneirong);
			
		 //获取Activity传递过来的值
		if(new chuandishuju().flag == 1){ //说明没有传递数据
			 Log.i(TAG, "index :"+ new chuandishuju().flag);
		}
		else {       //传递了数据
			Bundle bundle = this.getArguments();
			String name = bundle.getString("ddd");  //获得传递过来的歌的名字，然后进行列表刷新
	//	Log.i(TAG, name);
	//	likesongname = uiassit.Compare(name);    //装载数据源
	//	Log.i(TAG, (String) likesongname.get(0).get("geming"));
		automylike = new autocompletetextadapter(getActivity(), uiassit.createautolike(name));
		gedanadapter = new  gedanlistviewlikeadapter(getActivity(), uiassit.Compare(name));
		wodezuiaiauto.setThreshold(0);
		wodezuiaiauto.setAdapter(automylike);
		gedanadapter.clear();
		myfavourite.setAdapter(gedanadapter);
		gedanadapter.refresh(uiassit.Compare(name));
	    myfavourite.setOnItemClickListener(this);
		}
	   Log.i(TAG, "index :"+ new chuandishuju().flag);
		return  fragment1;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		  
	}
      
	
	     
	
} 
