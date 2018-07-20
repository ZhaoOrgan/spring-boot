package com.springboot.demo.config.mybatis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.springboot.demo.constants.DynamicDataSourceGlobal;

import groovy.util.logging.Slf4j;

@Aspect
@Component
@Slf4j
/**
 * @description: 默认操作write数据库
 * @author zhaoxuefeng
 * @date 2018年7月18日 下午11:06:25
 */
public class DynamicDataSourceAspect {

	@Before("execution(* com.demo.org.*.mapper..*.find*(..)) or execution(* com.demo.org.*.mapper..*.get*(..)) or execution(* com.demo.org.*.mapper..*.select*(..)) or execution(* com.demo.org.*.mapper..*.query*(..))")
	public void setReadDataSourceHolder() {
		DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.READ);
	}

}