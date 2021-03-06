package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.zhuui.songschoice;
import com.example.zhuui.zhujiemian;
import com.jerome.weibo.R;
import com.jerome.weibo.R.layout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;



public class gedanlistviewadapter  extends BaseAdapter implements  android.view.View.OnClickListener, OnItemClickListener{
      
	  private static final String TAG = null;
	  public List<HashMap<String,Object>> transit = new ArrayList<HashMap<String,Object>>();
	//  private  TextView  geming;
	//  private  TextView  geshou;
	  private LayoutInflater   inflater = null;
	  private  Context context;
	//  private  ImageView  arrow;
	  private  PopupWindow  tanchukuang;
	  private  LayoutInflater inflater1 = null;
	  private  View  songselect;
	  private  ViewHolder  holder = null;
	  public gedanlistviewadapter(){
		  
	  }
	   public  gedanlistviewadapter(Context context,List<HashMap<String,Object>> hhh){
		       super();
		       this.transit = hhh;
		       this.context = context;
		       this.inflater  = LayoutInflater.from(context);
	 }
	   static  class ViewHolder{
			  
		   public  TextView geming;
		   public  TextView geshou;
		   public  ImageView arrow;
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
			   holder= new ViewHolder();
			   convertView = inflater.inflate(R.layout.wholegedan_layout, null);
			   
			  holder.geming = (TextView)convertView.findViewById(R.id.showgeming);
			   holder.geshou = (TextView)convertView.findViewById(R.id.showgeshou);
			   holder.arrow = (ImageView)convertView.findViewById(R.id.xialagongneng);
			   //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
			   convertView.setTag(holder);
		 }
		 else{
			     holder = (ViewHolder)convertView.getTag();
		 }
		 //返回数据
		 holder.geming.setText(transit.get(position).get("geming").toString());
		 holder.geshou.setText(transit.get(position).get("geshouming").toString());
	//	 geming.setOnClickListener(this);
		 holder.arrow.setOnClickListener(this);
		 return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.showgeming:
			String name = (String) holder.geming.getText();
			Log.i(TAG, name);
			Intent inten1 = new Intent(context,zhujiemian.class);   //点击歌名时弹出主界面窗口,继承baseadapter,里面的控件添加点击事件
			context.startActivity(inten1);
		    break;
		case R.id.xialagongneng:
			 //	this.inflater1 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    Intent intent = new Intent(context,songschoice.class);
		    context.startActivity(intent);
			/*   Button buttoncancel;
		      
		      this.inflater1 = LayoutInflater.from(context);
			  songselect = inflater1.inflate(R.layout.songschoice_layout, null); 
			  GridView  gridview1 = (GridView) songselect.findViewById(R.id.songfunction);
			  songuiadapter hhh2= new songuiadapter(new uiassit().tubiao(), context);
			  gridview1.setAdapter(hhh2);
		      tanchukuang = new PopupWindow(songselect, 480, 400);
		      buttoncancel = (Button)songselect.findViewById(R.id.cancel);
			  tanchukuang.showAtLocation(geming, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
			  tanchukuang.setTouchable(true);                //获取菜单的焦点
		      tanchukuang.setTouchable(true);
		      tanchukuang.setOutsideTouchable(true);
		      buttoncancel.setOnClickListener(this);
		      gridview1.setOnItemClickListener(this);*/
			 break;
		case R.id.cancel:
			// Toast.makeText(context, "sdfsdf", 0).show();
		     if(tanchukuang.isShowing() && tanchukuang != null){
		    	   tanchukuang.dismiss();
		     }
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		    Toast.makeText(context, "sdfsd", 0).show();
		// TODO Auto-generated method stub
		
	}

	

}
