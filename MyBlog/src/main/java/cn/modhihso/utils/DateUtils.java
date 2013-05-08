package cn.modhihso.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间基本操作
 * 
 * @author hqm
 * @email hqm1988.good@163.com
 * @createTime 2012-4-18 下午3:11:41
 * 
 */
public class DateUtils {
	private static final DateFormat dformat_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat dformatyyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final DateFormat dformat_day = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat dformat_month = new SimpleDateFormat("yyyy-MM");

	private DateUtils() {
	}

	/**
	 * 获取现在的时间，精确到秒
	 * 
	 * @return
	 */
	public static String now() {
		return dformat_full.format(new Date());
	}

	/**
	 * 获取现在的时间，精确到秒
	 * 
	 * @return
	 */
	public static String nowYyyyMMddHHmmss() {
		return dformatyyyyMMddHHmmss.format(new Date());
	}

	/**
	 * 获取今天的日期
	 * 
	 * @return
	 */
	public static String today() {
		return dformat_day.format(new Date());
	}
	/**
	 * 获取本月
	 * 
	 * @return
	 */
	public static String month() {
		return dformat_month.format(new Date());
	}
}
