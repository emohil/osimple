package com.norming.ess.base.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class BaseDto extends HashMap<String, Object> implements Dto {

	private static final long serialVersionUID = 1L;

	public BaseDto() {
		super();
	}

	public BaseDto(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public BaseDto(int initialCapacity) {
		super(initialCapacity);
	}

	public BaseDto(Map<String, Object> m) {
		super(m);
	}

	@Override
	public String getString(String key) {
		return ObjectUtils.toString(this.get(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key) {
		Object o = this.get(key);
		if (o instanceof List) {
			return (List<T>) o;
		}
		return new ArrayList<>();
	}
	
	@Override
	public int getInt(String key) {
		Object value = this.get(key);
		if (value instanceof Integer) return (Integer) value;
		return NumberUtils.toInt(ObjectUtils.toString(value));
	}
	
	@Override
	public double getDouble(String key) {
		Object value = this.get(key);
		if (value instanceof Number) return ((Number) value).doubleValue();
		return NumberUtils.toDouble(ObjectUtils.toString(value));
	}
	
	@Override
	public BigDecimal getDecimal(String key) {
		String str = this.getString(key);
		if (StringUtils.isEmpty(str)) {
			return BigDecimal.ZERO;
		}
		return NumberUtils.createBigDecimal(str);
	}
	
	@Override
	public Date getDate(String key) {
		Object value = this.get(key);
		if (value instanceof Date) return (Date) value;
		return DateUtil.parse(value);
	}
}