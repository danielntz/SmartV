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
/**
 * 采用viewholder 避免oom（内存泄露）
 * @author jsjxy
 *
 */
public class videoadapter  extends BaseAdapter{
    
	    LayoutInflater  inflater;
	    Context context ;
	    public  List<HashMap<String,Object>> video = new ArrayList<HashMap<String,Object>>();
	    private ImageView tupian;
	    private TextView  videoname;
	    private TextView  videogeshouname;
	    private List<Bitmap> tupian1 = new ArrayList<Bitmap>(); 
	    private Bitmap  adjustbitmap;
	    private   ViewHolder  holder   = null;
	     
	      static  class ViewHolder {
	    	     public          ImageView   tupian;
	    	     public           TextView  videoname;
	    	     public          TextView  videogeshouname;
	      }
	    
	    
	    
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
		if(   convertView == null){
		      holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.videofragment, null);
			holder.tupian = (ImageView)convertView.findViewById(R.id.tupian);
			holder.videoname = (TextView)convertView.findViewById(R.id.videoname);
			holder.videogeshouname = (TextView)convertView.findViewById(R.id.videogeshouname);
			 convertView.setTag(holder);
		}
		else{
			    holder = (ViewHolder)convertView.getTag();
		}
		
	    adjustbitmap = ThumbnailUtils.extractThumbnail(tupian1.get(position), 160, 120);  //对图片的缩略,宽，高
		holder.tupian.setImageBitmap(adjustbitmap);
		holder.videoname.setText(video.get(position).get("videoname").toString());
		holder.videogeshouname.setText(video.get(position).get("videogeshouname").toString());
		
		
		return convertView;
	}

}
