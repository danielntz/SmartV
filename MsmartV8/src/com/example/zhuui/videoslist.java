package com.example.zhuui;

import com.example.Mfunction.FunctionfirstImage;
import com.example.uiassit.chuandishuju;
import com.example.uiassit.uiassit;
import com.example.uiassit.videoadapter;
import com.jerome.weibo.*;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class videoslist  extends Activity implements OnItemClickListener{

	private static final String TAG = null;
	private ListView showvideo;
	private videoadapter  adapter;
	private TextView zonggeshu;
//	private ImageView  hhh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.videoslist_layout);
	//	hhh = (ImageView)findViewById(R.id.showbitmap);
		showvideo = (ListView)findViewById(R.id.listvideo);
		zonggeshu = (TextView)findViewById(R.id.zongshijian);
		adapter = new videoadapter(this, new uiassit().videoname(),new FunctionfirstImage().showfirstimage());
		showvideo.setAdapter(adapter);
		showvideo.setOnItemClickListener(this);
		
	
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		//保存当前按下列表的视频信息数据和视频歌手数据
		 String shipinname = adapter.video.get(position).get("videoname").toString();
		 String shipingeshouname = adapter.video.get(position).get("videogeshouname").toString();
		 new chuandishuju().setname(shipinname);
		 new chuandishuju().setgeshouname(shipingeshouname);
	//	 Log.i(TAG, new chuandishuju().getname());
	//	 Log.i(TAG, new chuandishuju().getgeshouname());
		 if(parent == showvideo){
			 Intent intent = new Intent(this,videoshow.class);
			Bundle  bundle = new Bundle();
			bundle.putInt("mvbiaoqian", 2);
			 intent.putExtras(bundle);
			 startActivity(intent);
		 }
	}
	
     

	 
}
