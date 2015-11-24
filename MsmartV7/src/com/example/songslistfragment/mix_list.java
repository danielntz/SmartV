package com.example.songslistfragment;

import com.jerome.weibo.R;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.method.HideReturnsTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class mix_list  extends Fragment{
	   
	  private     downloadmusic   song;
	  private    downloadvideo     mv;
	    private     SegmentControlView   view1;
        FragmentManager  fragmentmanager;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragment3 = inflater.inflate(R.layout.mix_list_layout, container, false);
	 fragmentmanager = getChildFragmentManager();
	   view1 = (SegmentControlView)fragment3.findViewById(R.id.segment);
	  setTabSelection(0); 
	   view1.setOnsegmentlistenerclicker(new  OnsegmentControler() {
			
			@Override
			public void setOnsegment(View v, int position) {
				// TODO Auto-generated method stub
				      setTabSelection(position);
			}
		});
		 
		 
		 return  fragment3;
	}
	private void setTabSelection(int i) {
		// TODO Auto-generated method stub
	   android.support.v4.app.FragmentTransaction  trans = fragmentmanager.beginTransaction();
		      hidefragment(trans);
		      switch(i){
		      case 0 :
		    	   if(song == null){
		    		   song = new downloadmusic();
		    		  trans.add(R.id.jiashang, song);
		    	   }
		    	   else{
		    		   trans.show(song);
		    	   }
		    	   trans.commit();
		    	   break;
		       case 1 :
   	   if(mv == null){
   		   mv = new downloadvideo();
   		   trans.add(R.id.jiashang, mv);
   	   }
   	   else{
   		   trans.show(mv);
   	   }
   	   trans.commit();
     }
	}
	private void hidefragment(android.support.v4.app.FragmentTransaction trans) {
		// TODO Auto-generated method stub
		     if(song != null){
		         trans.hide(song);
		     }
		     if(mv != null){
		    	 trans.hide(mv);
		     }
	}
}
