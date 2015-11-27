package com.example.slidechange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.showword.LrcHandle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
/**
 *  自定义控件，继承TextView
 * @author lenovo
 *
 */
public class WordView  extends TextView{
	private List mWordsList = new ArrayList();
	private Paint mLoseFocusPaint;
	private Paint mOnFocusePaint;
	private float mX = 0;
	private float mMiddleY = 0;
	private float mY = 0;
	private static final int DY = 50;        //偏移量每个歌词向上的位移量
	private int mIndex = 0;

	public WordView(Context context) throws IOException {
	super(context);
	init();
	}

	public WordView(Context context, AttributeSet attrs) throws IOException {
	super(context, attrs);
	init();
	}

	public WordView(Context context, AttributeSet attrs, int defStyle)
	throws IOException {
	super(context, attrs, defStyle);
	init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);

	canvas.drawColor(Color.BLACK);          //画布的背景颜色

	Paint p = mLoseFocusPaint;
	p.setTextAlign(Paint.Align.CENTER);      //画笔的位置在中央
	Paint p2 = mOnFocusePaint;
	p2.setTextAlign(Paint.Align.CENTER);

	canvas.drawText((String)mWordsList.get(mIndex), mX, mMiddleY, p2);   //绘制字符，在画布中的位置

	int alphaValue = 25;
	
	float tempY = mMiddleY;
	for (int i = mIndex - 1; i >= 0; i--) {
	tempY -= DY;
	if (tempY < 0) {
	break;
	}
	p.setColor(Color.argb(255 - alphaValue, 245, 245, 245));       //离得越远的歌词越模糊
	canvas.drawText((String) mWordsList.get(i), mX, tempY, p);
	alphaValue += 25;
	}
	alphaValue = 25;
	tempY = mMiddleY;
	
	for (int i = mIndex + 1, len = mWordsList.size(); i < len; i++) {
	tempY += DY;
	if (tempY > mY) {
	break;
	}
	p.setColor(Color.argb(255 - alphaValue, 245, 245, 245));
	canvas.drawText((String) mWordsList.get(i), mX, tempY, p);
	alphaValue += 25;
	}
	mIndex++;
	}

	@Override
	protected void onSizeChanged(int w, int h, int ow, int oh) {
	super.onSizeChanged(w, h, ow, oh);

	mX = w * 0.5f;
	mY = h;
	mMiddleY = h * 0.3f;
	}

	
	private void init() throws IOException {
	setFocusable(true);

	LrcHandle lrcHandler = new LrcHandle();
	lrcHandler.readLRC("/sdcard/geci.lrc");
	mWordsList = lrcHandler.getWords();

	mLoseFocusPaint = new Paint();
	mLoseFocusPaint.setAntiAlias(true);
	mLoseFocusPaint.setTextSize(22);
	mLoseFocusPaint.setColor(Color.WHITE);
	mLoseFocusPaint.setTypeface(Typeface.SERIF);

	mOnFocusePaint = new Paint();
	mOnFocusePaint.setAntiAlias(true);
	mOnFocusePaint.setColor(Color.YELLOW);
	mOnFocusePaint.setTextSize(30);
	mOnFocusePaint.setTypeface(Typeface.SANS_SERIF);
	}
}
