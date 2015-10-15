package com.example.uiassit;

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

public class listviewadapter  extends BaseAdapter{
     
	private ImageView  showleft;
	private TextView   showmiddle;
	private ImageView  showright;
	 private LayoutInflater   inflater = null;
	 List<HashMap<String,Object>> hhh =null;
	 private int[] pitcure = new int[3];
	 public static int[] photo1 = new int[]{R.drawable.xiaotubiao,R.drawable.xiaotubiao,R.drawable.xiaotubiao};
	 
	
	 public listviewadapter (Context context,List<HashMap<String,Object>> ooo , int[] iii){
		 super();
		 this.hhh = ooo;
		 this.pitcure = iii;
		 this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	 }
	
	 //动态加载数据
	 public void refresh(List<HashMap<String,Object>> ooo ){
	  
		 hhh = ooo;
		
		 notifyDataSetChanged();
	 }
	 //清除所有数据
	 public void  clear(List<HashMap<String,Object>> ooo ){
		    hhh = ooo;
		    hhh.clear();
		    notifyDataSetChanged();
		 
	 }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return hhh.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return hhh.get(position);
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
			convertView = inflater.inflate(R.layout.listview_layout, null);
			showleft = (ImageView)convertView.findViewById(R.id.showtubiao);
			showmiddle = (TextView)convertView.findViewById(R.id.showinfo);
			showright = (ImageView)convertView.findViewById(R.id.showarrow);
		}
		else{}
		//返回数据
		showleft.setImageResource(photo1[position]);
	    showmiddle.setText(hhh.get(position).get("content").toString());
	   showright.setImageResource(R.drawable.arrow);
		
		return convertView;
	}

}
