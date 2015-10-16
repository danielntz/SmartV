package com.example.uiassit;

import java.util.List;

import com.jerome.weibo.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
//autocompletetextview 怎样去实现Filterable的接口
public class autocompletetextadapter  extends  BaseAdapter implements Filterable {
     
	 private TextView textview; 
	 private Context context;
	 private LayoutInflater  inflater;
	 private  List<String> textviewdata;
	 
	
	

	public  autocompletetextadapter(Context context ,List<String> ppp ){
		 
		 this.textviewdata = ppp;
		 this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	
	 }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return textviewdata.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return textviewdata.get(position);
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
	    	 convertView = inflater.inflate(R.layout.autocompletetext_layout, null);
	    	 
	    	 textview = (TextView)convertView.findViewById(R.id.autodata);
	     }
	     else{}
	    
	     textview.setText(textviewdata.get(position).toString());
		
		
		return convertView;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

}
