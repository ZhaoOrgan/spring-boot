package com.springboot.demo.config.mybatis;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * 多数据源配置
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.springboot.demo.config.mybatis.DynamicDataSource;
import com.springboot.demo.config.mybatis.DynamicDataSourceTransactionManager;
import com.springboot.demo.constants.DynamicDataSourceGlobal;

/**
 * @description: 数据源配置类
 * @author zhaoxuefeng
 * @date 2018年7月18日 下午11:06:25
 */
@Configuration
@PropertySource(value = { "classpath:application-dev.yml" })
public class DynamicDataSourceConfig {

	// 主数据库配置源
	@Bean(name = "writeDataSource", destroyMethod = "close")
	@Primary
	@ConfigurationProperties(prefix = "write.datasource")
	public DataSource writeDataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}

	// 从数据库配置源
	@Bean(name = "readDataSource", destroyMethod = "close")
	@ConfigurationProperties(prefix = "read.datasource")
	public DataSource readDataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}

	// 直接数据源
	@Bean(name = "dataSource")
	public DynamicDataSource getDynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put(DynamicDataSourceGlobal.READ.name(), readDataSource());
		dataSourceMap.put(DynamicDataSourceGlobal.WRITE.name(), writeDataSource());
		// 传入数据源map，AbstractRoutingDataSource将以key来分配数据源
		// dynamicDataSource.setDefaultTargetDataSource(writeDataSource());
		dynamicDataSource.setTargetDataSources(dataSourceMap);
		return dynamicDataSource;
	}

	@Bean
	public DynamicDataSourceTransactionManager getDynamicDataSourceTransactionManager(
			@Qualifier("dataSource") DynamicDataSource dataSource) {
		DynamicDataSourceTransactionManager transactionManager = new DynamicDataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource") DynamicDataSource dataSource) {
		try {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean
	public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
		return template;
	}

	protected SpringApplicationBuilder springApplicationBuilder(SpringApplicationBuilder builder) {
		return builder.sources(DynamicDataSourceConfig.class);
	}

}