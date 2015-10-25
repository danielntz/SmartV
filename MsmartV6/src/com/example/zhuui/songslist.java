package com.example.zhuui;

import com.example.songslistfragment.favourite_list;
import com.example.songslistfragment.mix_list;
import com.example.songslistfragment.song_list;
import com.example.uiassit.chuandishuju;
import com.jerome.weibo.*;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class songslist  extends  FragmentActivity implements OnClickListener{
     
	 private static final String TAG = null;
	private  favourite_list   wodezuiai ;
	 private  mix_list         zuheliebiao;
	 private  song_list        gequliebiao;
	 private   FragmentManager  fragmentmanager;    //用于对Fragment的处理
	 private  Button    one;
	 private  Button two;
	 private  Button three;
	 private String name1;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.songslist_layout);
		fragmentmanager = getSupportFragmentManager();     //获得fragmet
		one = (Button)findViewById(R.id.tab1);
		two = (Button)findViewById(R.id.tab2);
		three = (Button)findViewById(R.id.tab3);
	    
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		setTabSelection(0);
	}
     
	public void setTabSelection (int index){
		 
		FragmentTransaction trans = fragmentmanager.beginTransaction();
		clearselection();
		hideFragments(trans);
		switch (index) {
		case 0:
			wodezuiai = null;                       //如果每次要更新fragment的界面的话,就要设置成null,否则不调用oncreateview函数
			one.setTextColor(Color.GREEN);
			if(gequliebiao == null){
				gequliebiao = new song_list();
				trans.add(R.id.songslist, gequliebiao);
			}
			else{
				 trans.show(gequliebiao);
			}
			
			trans.commit();
			break;
		case 1:
			 two.setTextColor(Color.GREEN);
		    //采用application 的方法来获得activity传递过来的数据
		   	Bundle data = new  Bundle();
		   	data.putString("ddd",new chuandishuju().name );
			
			 if(wodezuiai == null){
				   
				     wodezuiai = new favourite_list();	        //重新声明一个对象
				 if( !new chuandishuju().name.equals("yes"))
					{  
					   new chuandishuju().flag = 2;
					   Log.isLoggable(TAG, new chuandishuju().flag);
					   wodezuiai.setArguments(data);
					}
					trans.add(R.id.songslist, wodezuiai);
				}
				/*else{
					//wodezuiai.setArguments(data);
				
					if(!new chuandishuju().name.equals("yes"))
						{  
						   new chuandishuju().flag = 2;
						   Log.isLoggable(TAG, new chuandishuju().flag);
						   wodezuiai.setArguments(data);
						}
					 trans.show(wodezuiai);
				}*/
	
			trans.commit();
		     break;
		case 2:
			 three.setTextColor(Color.GREEN);
			 wodezuiai = null;
			 if(zuheliebiao == null){
					zuheliebiao = new mix_list();
					trans.add(R.id.songslist, zuheliebiao);
				}
				else{
					 trans.show(zuheliebiao);
				}
				trans.commit();break;
		}
		
	}
    //隐藏fragment
	public void hideFragments(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (gequliebiao != null) {  
            transaction.hide(gequliebiao);  
        }  
        if (wodezuiai != null) {  
            transaction.hide(wodezuiai);  
        }  
        if (zuheliebiao != null) {  
            transaction.hide(zuheliebiao);  
        }  
	}
    //清除UI界面
	public void clearselection() {
		// TODO Auto-generated method stub
		one.setTextColor(Color.WHITE);
		two.setTextColor(Color.WHITE);
		three.setTextColor(Color.WHITE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  switch (v.getId()) {
		case R.id.tab1:
			 setTabSelection(0);
			break;
		case R.id.tab2:
			  setTabSelection(1);
			  break;
		case R.id.tab3:
			setTabSelection(2);
		    break;
		}
	}


	
	 
	 
	 
}
