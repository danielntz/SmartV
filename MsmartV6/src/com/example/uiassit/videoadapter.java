package com.example.uiassit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.Mfunction.FunctionfirstImage;
import com.jerome.weibo.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class videoadapter  extends BaseAdapter{
    
	    LayoutInflater  inflater;
	    Context context ;
	    List<HashMap<String,Object>> video = new ArrayList<HashMap<String,Object>>();
	    private ImageView tupian;
	    private TextView  videoname;
	    private TextView  videogeshouname;
	    private List<Bitmap> tupian1 = new ArrayList<Bitmap>(); 
	    private Bitmap  adjustbitmap;
	  
	 public videoadapter(){
		 
	 }
	 
	  
	 
	 public videoadapter(Context context,List<HashMap<String,Object>> video1 ,List<Bitmap> lll ){
		    this.context = context;
		    this.video = video1;
		    inflater = LayoutInflater.from(context);
		    this.tupian1 = lll;
		 
	 }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return video.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return video.get(position);
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
			convertView = inflater.inflate(R.layout.videofragment, null);
			tupian = (ImageView)convertView.findViewById(R.id.tupian);
			videoname = (TextView)convertView.findViewById(R.id.videoname);
			videogeshouname = (TextView)convertView.findViewById(R.id.videogeshouname);
		}
		else{}
		
	    adjustbitmap = ThumbnailUtils.extractThumbnail(tupian1.get(position), 160, 120);  //¶ÔÍ¼Æ¬µÄËõÂÔ,¿í£¬¸ß
		tupian.setImageBitmap(adjustbitmap);
		videoname.setText(video.get(position).get("videoname").toString());
		videogeshouname.setText(video.get(position).get("videogeshouname").toString());
		
		
		return convertView;
	}

}
