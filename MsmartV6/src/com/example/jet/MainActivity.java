package com.example.jet;

import java.util.zip.Inflater;





import com.example.zhuui.zhujiemian;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.jerome.weibo.*;
public class MainActivity extends Activity {

	TextView image;
	MoreWindow mMoreWindow;
	//6¸ö¹¦ÄÜ
		private TextView shipinlist;
		private TextView gongneng;
		private TextView shipinbofang;
		private TextView gequlist;
		private TextView zhujiemian;
		private TextView zhuanjilist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
       
	    image = (TextView) findViewById(R.id.show);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMoreWindow(v);
			}
		});
	}

	private void showMoreWindow(View view) {
		if (null == mMoreWindow) {
			mMoreWindow = new MoreWindow(this);
			mMoreWindow.init();
			mMoreWindow.setFocusable(true);
			mMoreWindow.setTouchable(true);
		
		}

		mMoreWindow.showMoreWindow(view,100);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
