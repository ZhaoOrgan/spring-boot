package com.springboot.demo.config.mybatis;

import com.springboot.demo.constants.DynamicDataSourceGlobal;

/**
 * @description: 给当前线程赋值数据源
 * @author zhaoxuefeng
 * @date 2018年7月20日 下午11:06:33
 */
public final class DynamicDataSourceHolder {

	private static final ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal<DynamicDataSourceGlobal>();

	private DynamicDataSourceHolder() {
	}

	public static void putDataSource(DynamicDataSourceGlobal dataSource) {
		holder.set(dataSource);
	}

	public static DynamicDataSourceGlobal getDataSource() {
		return holder.get();
	}

	public static void clearDataSource() {
		holder.remove();
	}
}
