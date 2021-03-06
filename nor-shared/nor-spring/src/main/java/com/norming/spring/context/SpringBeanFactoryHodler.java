package com.norming.spring.context;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * SpringBeanFactory对象持有者.
 * @author lh.jia
 *
 */
public class SpringBeanFactoryHodler {
    
	private static ConfigurableListableBeanFactory beanFactory;
	
	public static void setBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		SpringBeanFactoryHodler.beanFactory = beanFactory;
	}
	
	public static ConfigurableListableBeanFactory getBeanFactory() {
		checkBeanFactory();
		return beanFactory;
	}
	
	/**
	 * 清除beanFactory静态变量.
	 */
	public static void cleanBeanFactory() {
		beanFactory = null;
	}
	
	public static boolean isContextReady() {
		return beanFactory != null;
	}
	
	private static void checkBeanFactory() {
		if (beanFactory == null) {
			throw new IllegalStateException("beanFactory未设置");
		}
	}
}
