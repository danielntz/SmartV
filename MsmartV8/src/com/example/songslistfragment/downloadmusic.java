package com.example.songslistfragment;

import com.jerome.weibo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class downloadmusic  extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		     View   song = inflater.inflate(R.layout.song_layout, null);
		     return song;
	}
      
}
