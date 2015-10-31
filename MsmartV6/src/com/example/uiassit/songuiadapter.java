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
import android.widget.ImageView;
import android.widget.TextView;

public class songuiadapter   extends BaseAdapter{
       
	private ImageView imageview;
	private TextView  text;
	   Context context ;
	   LayoutInflater  inflater;
	   List<HashMap<String,Object>> hhh = new ArrayList<HashMap<String,Object>>();
	   int tubiao[] = new int[]{R.drawable.jiandantubiao0,R.drawable.jiandantubiao1,R.drawable.jiandantubiao3};
	
	public songuiadapter( List<HashMap<String,Object>> tanchu,Context context){
		  this.context = context;
		  inflater = LayoutInflater.from(context);
		  this.hhh = tanchu;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.hhh.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.hhh.get(position);
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
	        	 convertView = inflater.inflate(R.layout.songlisttanchu_layout, null);
	        	 imageview = (ImageView)convertView.findViewById(R.id.gongnengtupian);
	        	 text = (TextView)convertView.findViewById(R.id.gongnengwenzi);
	        	 
	        }
	        else{}
	        imageview.setImageResource(tubiao[position]);
	        text.setText(this.hhh.get(position).get("gongneng").toString());
		    return convertView;
	}

}
