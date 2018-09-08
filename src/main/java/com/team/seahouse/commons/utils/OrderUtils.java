package com.team.seahouse.commons.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: 订单操作的工具类
 * @Description: 提供订单相关操作的工具类，生成订单号等
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/9/6
 */
public class OrderUtils {
	
	/** 订单编号后缀位数 */
	private static final int SUFFIX_NUMBER = 2;

	private OrderUtils() {
		throw new AssertionError();
	}

	/** 获得订单编号 */
	public static String getOrderNumber(Long userId) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String prefixNumber = sdf.format(new Date());
		String suffixNumber = RandomUtils.number(SUFFIX_NUMBER);
		String userNumber = prefixNumber + Long.toString(userId) + suffixNumber;
		return userNumber;
	}

	/** 获得支付金额 */
	public static BigDecimal getPayAmount(BigDecimal shipmentAmount, BigDecimal orderAmount) {
		if (shipmentAmount != null) {
			orderAmount.add(shipmentAmount);
		}
		return orderAmount;
	}
	
	public static void main(String[] args) {
	    System.out.println(getOrderNumber(18L));
	}
}
