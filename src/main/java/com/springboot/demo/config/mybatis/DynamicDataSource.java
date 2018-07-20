package com.springboot.demo.config.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.springboot.demo.constants.DynamicDataSourceGlobal;

public class DynamicDataSource extends AbstractRoutingDataSource {

	// 返回分配的数据库的key
	@Override
	protected Object determineCurrentLookupKey() {
		DynamicDataSourceGlobal dynamicDataSourceGlobal = DynamicDataSourceHolder.getDataSource();
		if (dynamicDataSourceGlobal == null || dynamicDataSourceGlobal == DynamicDataSourceGlobal.WRITE) {
			return DynamicDataSourceGlobal.WRITE.name();
		}
		return DynamicDataSourceGlobal.READ.name();
	}

}
