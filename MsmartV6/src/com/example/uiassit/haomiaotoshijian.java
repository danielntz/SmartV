package com.example.uiassit;

public class haomiaotoshijian {
   
	  public haomiaotoshijian(){
		  
	  }
	  //把毫秒数变成时间格式 如 01：00
	  public  String  formattime(long time){
		    time = time/ 1000;
	        String strHour = "" + (time/3600);
	        String strMinute = "" + time%3600/60;
	        String strSecond = "" + time%3600%60;
	        strHour = strHour.length() < 2? "0" + strHour: strHour;
	        strMinute = strMinute.length() < 2? "0" + strMinute: strMinute;
	        strSecond = strSecond.length() < 2? "0" + strSecond: strSecond;
	        String strRsult = "";
	         
	        if (!strHour.equals("00"))
	        {
	            strRsult += strHour + ":";
	        }
	         
	        if (!strMinute.equals("00"))
	        {
	            strRsult += strMinute + ":";
	        }
	         
	        strRsult += strSecond;
	         
	        return strRsult;
	  }
	
}
