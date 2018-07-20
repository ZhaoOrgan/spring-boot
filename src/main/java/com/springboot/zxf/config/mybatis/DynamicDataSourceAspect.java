package com.springboot.zxf.config.mybatis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.springboot.zxf.constants.DynamicDataSourceGlobal;

import groovy.util.logging.Slf4j;

@Aspect
@Component
@Slf4j
/**
 * 默认操作write数据库
 * 
 * @author zhaoxuefeng
 */
public class DynamicDataSourceAspect {

	@Before("execution(* com.zxf.org.*.mapper..*.find*(..)) or execution(* com.zxf.org.*.mapper..*.get*(..)) or execution(* com.zxf.org.*.mapper..*.select*(..)) or execution(* com.zxf.org.*.mapper..*.query*(..))")
	public void setReadDataSourceHolder() {
		DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.READ);
	}

}