package com.example.songslistfragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.Mfunction.FunctionSDfilename;
import com.example.Mfunction.Functiongetfilename;
import com.example.uiassit.autocompletetextadapter;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 *  �����˵������ظ���������ȥ��
 *  ����listview���б��item��ᷢ���仯��ÿ�λ���item�����ݷ����仯
 * @author lenovo
 *
 */
public class song_list extends Fragment implements OnItemClickListener  {
	
	
	  private static final String TAG = null;
	private ListView  gedanliebiao ;
	  private gedanlistviewadapter adapter = null;
	  private AutoCompleteTextView  autodata;
	  private autocompletetextadapter autoadapter = null;
	  private gedanlistviewadapter updateadapter = null;
	  //���ڻ��SD���ϵ�����MP3�ļ�������
	  
		
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment2 = inflater.inflate(R.layout.song_list_layout, container, false);
		gedanliebiao = (ListView)fragment2.findViewById(R.id.gequliebiao);
		autodata = (AutoCompleteTextView)fragment2.findViewById(R.id.sousuoneirong);
		autoadapter = new autocompletetextadapter(getActivity(),uiassit.createtextview());
		adapter = new gedanlistviewadapter(getActivity(),uiassit.creategedan());
	    
		autodata.setThreshold(0);              //���뼸���ַ���ʼƥ�䣬��ʱ������ 
		autodata.setAdapter(autoadapter);      
		adapter.clear();                   
		gedanliebiao.setAdapter(adapter);       
		adapter.refresh(uiassit.creategedan());
		new Functiongetfilename().getfilename();;
		autodata.setOnItemClickListener(this);   //autocompletetextview�ĵ���¼�
		gedanliebiao.setOnItemClickListener(this);
		
		
		return  fragment2;
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	if( parent != gedanliebiao){
		String gename = autoadapter.filttextviewdata.get(position).toString();
		 updateadapter = new gedanlistviewadapter(getActivity(), uiassit.Compare(gename));
		 updateadapter.clear();
		 gedanliebiao.setAdapter(updateadapter);
		 updateadapter.refresh(uiassit.Compare(gename));
	}
		 if(parent == gedanliebiao){     //����listviewʱ���õķ���
			 Intent intent1 = new Intent(getActivity(),zhujiemian.class);
			 String name =  adapter.transit.get(position).get("geming").toString();
			 intent1.putExtra("geming", name);
			 Log.i(TAG, name);
			 startActivity(intent1);      //����������
		 }
	}



	


	
	
	
	
}
