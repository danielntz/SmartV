package com.example.songslistfragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.Mfunction.FunctionSDfilename;
import com.example.Mfunction.Functiongetfilename;
import com.example.uiassit.autocompletetextadapter;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.gedanlistviewadapter;
import com.example.uiassit.uiassit;
import com.example.zhuui.zhujiemian;
import com.jerome.weibo.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 *  下拉菜单出现重复现象，怎样去重
 *  滑动listview，列表的item项会发生变化，每次滑动item项内容发生变化
 * @author lenovo
 *
 */
public class song_list extends Fragment implements OnItemClickListener  {
	
	
	  private static final String TAG = null;
	  private ListView  gedanliebiao ;
	  private gedanlistviewadapter adapter = null;
	  private AutoCompleteTextView  autodata;
	  private autocompletetextadapter autoadapter = null;
	  private gedanlistviewadapter updateadapter = new gedanlistviewadapter();
	  private ListView gedanliebiao2 ;     //用于刷新后的listview
	//  private  gedanlistviewadapter  
	  //用于获得SD卡上的所有MP3文件的名字
	  
		
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment2 = inflater.inflate(R.layout.song_list_layout, container, false);
		gedanliebiao = (ListView)fragment2.findViewById(R.id.gequliebiao);
		gedanliebiao2 = (ListView)fragment2.findViewById(R.id.gequliebiao);
		autodata = (AutoCompleteTextView)fragment2.findViewById(R.id.sousuoneirong);
		autoadapter = new autocompletetextadapter(getActivity(),uiassit.createtextview());
		adapter = new gedanlistviewadapter(getActivity(),uiassit.creategedan());
	    
		autodata.setThreshold(0);              //输入几个字符开始匹配，暂时是这样 
		autodata.setAdapter(autoadapter);       
		adapter.clear();                   
		gedanliebiao.setAdapter(adapter);       
		adapter.refresh(uiassit.creategedan());
		new Functiongetfilename().getfilename();;
		autodata.setOnItemClickListener(this);   //autocompletetextview的点击事件
		gedanliebiao.setOnItemClickListener(this);
		
		
		return  fragment2;
	}

	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	if( parent != gedanliebiao && parent!= gedanliebiao2){   //多个组件绑定一个点击列表事件
		String gename = autoadapter.filttextviewdata.get(position).toString();
		 updateadapter = new gedanlistviewadapter(getActivity(), uiassit.Compare(gename));
		 updateadapter.clear();
		 gedanliebiao.setAdapter(updateadapter);
		 new chuandishuju().setname(gename);
		 updateadapter.refresh(uiassit.Compare(gename));
		 
	}
		 if(parent == gedanliebiao){     //按下listview时调用的方法
			//分两种情况  2初始化的，1 进行Autocomplextextview选择后的
			 if(updateadapter.transit.size() < 2  && updateadapter.transit.size() > 0){
				 Intent intent1 = new Intent(getActivity(),zhujiemian.class);
				 String name =  updateadapter.transit.get(position).get("geming").toString();
				 String geshou = updateadapter.transit.get(position).get("geshouming").toString();
				 new chuandishuju().setgeshouname(geshou);      //存储当前歌手名字，传给另一个界面
				 new chuandishuju().setIndex(position);                     //获得当前歌曲的索引
				 intent1.putExtra("geming", name);
				 new chuandishuju().setname(name);
				 Log.i(TAG, name);
				 startActivity(intent1);      //开启主界面
			 }
			 else{
		    Intent intent1 = new Intent(getActivity(),zhujiemian.class);
			 String name =  adapter.transit.get(position).get("geming").toString();
			 String geshou = adapter.transit.get(position).get("geshouming").toString();
			 intent1.putExtra("geming", name);
			 new chuandishuju().setIndex(position);                     //获得当前歌曲的索引
			 Log.i(TAG, new chuandishuju().getIndex()+"");
			 new chuandishuju().setgeshouname(geshou);
			 new chuandishuju().setname(name);
			 Log.i(TAG, name);
			 startActivity(intent1);      //开启主界面
			 }
		 }
		
	}



	


	
	
	
	
}
