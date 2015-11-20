package com.example.showword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class LrcHandle {
	    private static final String TAG = null;
		private List <String>mWords = new ArrayList<String>();         //获得每行中括号之后的歌词
	    private List <Long> mTimeList = new ArrayList<Long>();    //获得每行歌词所对应的毫秒数

	    //处理歌词文件
	    public void readLRC(String path) {
	        File file = new File(path);

	        try {
	            FileInputStream fileInputStream = new FileInputStream(file);
	            InputStreamReader inputStreamReader = new InputStreamReader(
	                    fileInputStream, "gbk");
	            BufferedReader bufferedReader = new BufferedReader(
	                    inputStreamReader);
	            String s = "";
	            while ((s = bufferedReader.readLine()) != null) {
	             addTimeToList(s);
	              //    Log.i(TAG, s);
	               if ((s.indexOf("[ar:") != -1) || (s.indexOf("[ti:") != -1)
	                        || (s.indexOf("[by:") != -1) || (s.indexOf("[al:") != -1) || (s.indexOf("[offset:")!= -1)) 
	                {
	                    s = s.substring(s.indexOf(":") + 1, s.indexOf("]"));
	                } else {
	                         String ss = s.substring( s.indexOf("["), s.indexOf("]")+1 );
	                            s = s.replace(ss, "");
	                }
	                  mWords.add(s);
	            
	            }

	            bufferedReader.close();
	            inputStreamReader.close();
	            fileInputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            mWords.add("没有歌词文件，赶紧去下载");
	        } catch (IOException e) {
	            e.printStackTrace();
	            mWords.add("没有读取到歌词");
	        }
	    }
	   public List getWords() {
	        return mWords;
	   }

	    public List getTime() {
	        return   mTimeList;
	    }

	    // 分离出时间
	    private long timeHandler(String string) {
	       string = string.replace(".", ":");                  //把字符串中的.换成：
	       String timeData[] = string.split(":");     //把字符串中的字符串按照冒号分隔，返回分割的字符串数组
	// 分离出分、秒并转换为整型
	        int minute = Integer.parseInt(timeData[0]);
	        int second = Integer.parseInt(timeData[1]);
	        int millisecond = Integer.parseInt(timeData[2]);

	        // 计算上一行与下一行的时间转换为毫秒数,当前这行歌词对应的时间转化为毫秒数
	          long currentTime = (minute * 60 + second) * 1000 + millisecond * 10;

	        return currentTime;
	    }

	   private void addTimeToList(String string) {
	        Matcher matcher = Pattern.compile(
	                "\\[\\d{1,2}:\\d{1,2}([\\.:]\\d{1,2})?\\]").matcher(string);
	        if (matcher.find()) {
	            String str = matcher.group();
	            mTimeList.add(new LrcHandle().timeHandler(str.substring(1,         //得到当前这行歌词的时间用中括号括的地方
	                    str.length() - 1)));
	        }

	    }
	
}
