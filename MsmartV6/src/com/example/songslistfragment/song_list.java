package com.example.songslistfragment;

import com.example.uiassit.autocompletetextadapter;
import com.example.uiassit.gedanlistviewadapter;
import com.example.uiassit.uiassit;
import com.jerome.weibo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class song_list extends Fragment {
	
	
	  private ListView  gedanliebiao ;
	  private gedanlistviewadapter adapter = null;
	  private AutoCompleteTextView  autodata;
	  private autocompletetextadapter autoadapter = null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment2 = inflater.inflate(R.layout.song_list_layout, container, false);
		gedanliebiao = (ListView)fragment2.findViewById(R.id.gequliebiao);
		autodata = (AutoCompleteTextView)fragment2.findViewById(R.id.sousuoneirong);
		autoadapter = new autocompletetextadapter(getActivity(),uiassit.createtextview());
		adapter = new gedanlistviewadapter(getActivity(),uiassit.creategedan());
		if(autoadapter.filttextviewdata != null){
			autoadapter.filttextviewdata.clear();
          }
		autoadapter.notifyDataSetChanged();
		autodata.setThreshold(0);        //输入几个字符开始匹配，暂时是这样 
		autodata.setAdapter(autoadapter);
		
		adapter.clear();
		gedanliebiao.setAdapter(adapter);       
		adapter.refresh(uiassit.creategedan());
		
		
		return  fragment2;
	}
}
