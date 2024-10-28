package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 字符串转日期
	 * @param strDate
	 * @param strFormat
	 * @return
	 */
	public static Date formatStr2Date(String strDate,String strFormat){
		Date retValue = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
			retValue =  sdf.parse(strDate);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return retValue;
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @param strFormat
	 * @return
	 */
	public static String formatDate2Str(Date date,String strFormat){
		String retValue = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		retValue =  sdf.format(date);
		
		return retValue;
	
	}
	
	/**
	 * 获取两个日期之间相差的天数
	 * @param et
	 * @param st
	 * @return
	 */
	public static int getTwoDateDays(Date et,Date st){
		int day = 0;
		day = (int)((et.getTime()-st.getTime())/(24*60*60*1000));
		return day;
	}
}
