package com.norming.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.norming.spring.context.SpringBeanFactoryHodler;
import com.norming.spring.context.SpringContextHolder;


public class SpringInitializer implements ApplicationContextAware, BeanFactoryPostProcessor {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.setContext(applicationContext);
	}

	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		SpringBeanFactoryHodler.setBeanFactory(beanFactory);
	}
}