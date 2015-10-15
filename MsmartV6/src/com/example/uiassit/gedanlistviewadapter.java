package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jerome.weibo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class gedanlistviewadapter  extends BaseAdapter{
      
	  private List<HashMap<String,Object>> transit = new ArrayList<HashMap<String,Object>>();
	  private  TextView  geming;
	  private  TextView  geshou;
	  private LayoutInflater   inflater = null;
	  
	 public  gedanlistviewadapter(Context context,List<HashMap<String,Object>> hhh){
		       super();
		       this.transit = hhh;
		       this.inflater  = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	 }
	  
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return transit.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return transit.get(position);
	}
	public void refresh(List<HashMap<String,Object>> hhh){
		  transit = hhh;
		 notifyDataSetChanged();
	}
	public void clear(){
		transit.clear();
		notifyDataSetChanged();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 if(convertView == null){
			   convertView = inflater.inflate(R.layout.wholegedan_layout, null);
			   geming = (TextView)convertView.findViewById(R.id.showgeming);
			   geshou = (TextView)convertView.findViewById(R.id.showgeshou);
		 }
		 else{}
		 //·µ»ØÊý¾Ý
		 geming.setText(transit.get(position).get("geming").toString());
		 geshou.setText(transit.get(position).get("geshouming").toString());
		 
		
		return convertView;
	}

}
