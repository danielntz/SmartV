package com.example.uiassit;

import java.util.ArrayList;
import java.util.List;

import com.jerome.weibo.R;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Interpolator.Result;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
//autocompletetextview 怎样去实现Filterable的接口  ,怎样去实现过滤器接口
public class autocompletetextadapter  extends  BaseAdapter implements Filterable, android.view.View.OnClickListener {
     
	 private TextView textview; 
	 private Context context;
	 private LayoutInflater  inflater;
	 private  List<String> textviewdata;
     private  ArrayFilter mFilter;             //生成过滤器
     public  List<String> filttextviewdata;   //过滤后的list列表
	 private Object mlock = new Object();
	// private  static int j =0 ;
	
	

	public  autocompletetextadapter(Context context ,List<String> ppp ){
		 
		 this.textviewdata = ppp;
		 this.context = context;
		 this.inflater = LayoutInflater.from(context);
	 }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filttextviewdata.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		//return filttextviewdata.get(position);
		return filttextviewdata.get(position);
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
	    
	       textview.setText(filttextviewdata.get(position).toString());
	     //  textview.setOnClickListener(this);
	       
	 
		
		return convertView;
	}
	public void clear(){
		  textviewdata.clear();
		  notifyDataSetChanged();
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		if(mFilter == null){
			mFilter = new ArrayFilter();
		}
		return mFilter;
	} 	
	
	private class ArrayFilter extends Filter{

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			// TODO Auto-generated method stub
			FilterResults  results = new FilterResults();
			
			if(constraint == null || constraint.length() == 0){
				synchronized (mlock) {
					List<String> list = new ArrayList<String>(textviewdata);    //把源数据赋给新建的list
			     	results.values = list;
					results.count = list.size();
				 return results; 
				} 
			}
			else{
				String prefixstring =  constraint.toString().toLowerCase();
				final int count = textviewdata.size();
				final ArrayList<String> newvalues = new ArrayList<String>(count);
				for(int i =0 ; i<count; i ++){
					String value = textviewdata.get(i);
					String valuetext = value.toLowerCase();
					//进行匹配
					if(valuetext.startsWith(prefixstring)){
						newvalues.add(value);
					}
				}
				results.values = newvalues;
				results.count = newvalues.size();
			}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			  // TODO Auto-generated method stub
			 filttextviewdata =  (List<String>) results.values;
			if(results.count > 0){
                
				notifyDataSetChanged();
			}
			else{
				notifyDataSetInvalidated();
			}
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.autodata:
			 
			 break;

		default:
			break;
		}
	}

	
	

}
