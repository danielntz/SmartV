package com.example.adjustscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class adjustscreen   extends VideoView{

	 public adjustscreen(Context context, AttributeSet attrs, int defStyle) {  
	        super(context, attrs, defStyle);  
	    }  
	  
	    public adjustscreen(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	    }  
	  
	    public adjustscreen(Context context) {  
	        super(context);  
	    }  
	  
	    @Override  
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
	        // TODO Auto-generated method stub  
	  
	        int width = getDefaultSize(0, widthMeasureSpec);  
	        int height = getDefaultSize(0, heightMeasureSpec);  
	        setMeasuredDimension(width, height);  
	    }  

}
