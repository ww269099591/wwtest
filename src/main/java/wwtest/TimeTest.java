package wwtest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTest {
	public static void main(String args[]) {
	Date date = new Date();
	date.getTime();
	//Mon Jun 03 11:19:06 CST 2019
	System.out.println(date);
	//1559531946178 获取毫秒数
	System.out.println(date.getTime());
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日_HH时mm分ss秒");
	String timeStr = sdf.format(new Date());
    //2019年06月03日_11时21分59秒
	System.out.println(timeStr);
	
	Date time=null;
	Date time2=null;
	try {
	//将字符串转为时间 按照一个格式转换
	time= sdf.parse(timeStr);
	String timeStr2="2019年06月03日_11时21分59秒";
	time2=sdf.parse(timeStr2);
	// date 方法 compareTo date1小于date2返回-1，date1大于date2返回1，相等返回0如下。
	System.out.println(time2.compareTo(time));
	} catch (ParseException e) {
	e.printStackTrace();
	}
	}
}
