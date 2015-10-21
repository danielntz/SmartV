package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.zhuui.zhujiemian;
import com.jerome.weibo.R;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class gedanlistviewadapter  extends BaseAdapter implements  android.view.View.OnClickListener{
      
	  private static final String TAG = null;
	  public List<HashMap<String,Object>> transit = new ArrayList<HashMap<String,Object>>();
	  private  TextView  geming;
	  private  TextView  geshou;
	  private LayoutInflater   inflater = null;
	  private  Context context;
	  public gedanlistviewadapter(){
		  
	  }
	   public  gedanlistviewadapter(Context context,List<HashMap<String,Object>> hhh){
		       super();
		       this.transit = hhh;
		       this.context = context;
		       this.inflater  = LayoutInflater.from(context);
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
		 //返回数据
		 geming.setText(transit.get(position).get("geming").toString());
		 geshou.setText(transit.get(position).get("geshouming").toString());
	//	 geming.setOnClickListener(this);
		
		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.showgeming:
			String name = (String) geming.getText();
			Log.i(TAG, name);
			Intent inten1 = new Intent(context,zhujiemian.class);   //点击歌名时弹出主界面窗口,继承baseadapter,里面的控件添加点击事件
			context.startActivity(inten1);
		    break;

		
		
		}
	}

	

}
