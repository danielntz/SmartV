package com.example.uiassit;

import com.jerome.weibo.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class gridviewadapter  extends BaseAdapter implements OnClickListener{
     
	   private static final String TAG = null;
	   private ImageView  view1;
	   private TextView   view2;
	   private LayoutInflater inflater;
	
	public gridviewadapter(Context context){
		super();
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	 gridviewadapter(){
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return  gridvietianchong.deploy().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = inflater.inflate(R.layout.gridviewcontent, null);
			view1 = (ImageView)convertView.findViewById(R.id.contentphoto);
			view2 = (TextView)convertView.findViewById(R.id.contentwenzi);
		}
		else{}
		view1.setImageResource(gridvietianchong.tupian[position]);       //ªÒ»°Õº∆¨
		view2.setText(gridvietianchong.deploy().get(position).get("introduce").toString());
		view1.setOnClickListener(this);
		view2.setOnClickListener(this);
		
		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.contentphoto:
			 Log.i(TAG, "sdf");
			 break;
		case R.id.contentwenzi:
			 Log.i(TAG, "sdfsf");
			 break;
		default:
			break;
		}
	}

}
