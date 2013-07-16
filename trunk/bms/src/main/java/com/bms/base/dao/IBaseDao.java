package com.bms.base.dao;

import java.util.List;

public interface IBaseDao<T> {

	int insert(T t);
	
	int update(T t);
	
	int deleteById(Integer id);
	
	List<T> findList();
	
	List<T> findList(T t);

	List<T> findList(String sql, Object... args);
	
	T findById(Integer id);
	
	T findBean(T t);
	
	T findBean(String sql, Object... args);
}