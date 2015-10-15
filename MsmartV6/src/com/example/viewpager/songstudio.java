package com.example.viewpager;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.uiassit.listviewadapter;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

public class songstudio  extends Fragment{
	   
	private ListView   listinfomation;
	private listviewadapter   viewadapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment2 =  inflater.inflate(R.layout.fragment1_layout, container,false);
		listinfomation = (ListView)fragment2.findViewById(R.id.showotherinfo);
		viewadapter = new listviewadapter(getActivity(), uiassit.create(), uiassit.photo);  //把更改的数据通知adapter
	    //底下三行非常重要 ，控制listview的刷新内容
     	viewadapter.clear(uiassit.create());      //清空listview的数据并且重新启用getview
		listinfomation.setAdapter(viewadapter);                  
		viewadapter.refresh(uiassit.create());     //通过数据源对listview进行重新启用getview
		
	     
		
		return fragment2;
	}
   
   
	
}
