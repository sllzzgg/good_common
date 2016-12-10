package com.dshl.commons.utlis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源配置
 * 
 * @author zhouguojun
 *
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

	public static void setDataSourceKey(String dataSource) {
		dataSourceKey.set(dataSource);
	}

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return dataSourceKey.get();
	}

}
