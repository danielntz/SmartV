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
		viewadapter = new listviewadapter(getActivity(), uiassit.create(), uiassit.photo);  //�Ѹ��ĵ�����֪ͨadapter
	    //�������зǳ���Ҫ ������listview��ˢ������
     	viewadapter.clear(uiassit.create());      //���listview�����ݲ�����������getview
		listinfomation.setAdapter(viewadapter);                  
		viewadapter.refresh(uiassit.create());     //ͨ������Դ��listview������������getview
		
	     
		
		return fragment2;
	}
   
   
	
}
