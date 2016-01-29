package com.jb.statistics.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeanUtils;

public class BaseEntity implements Cloneable {

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void propertyToString(StringBuilder sb, Field f) throws Exception {
		Object o = f.get(this);
		if (o != null && o instanceof BaseEntity) {
			sb.append(f.getName()).append("=").append(o.getClass().getName())
					.append("@").append(Integer.toHexString(o.hashCode()));
		} else {
			sb.append(f.getName()).append("=").append(o);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			boolean isFirst = true;
			sb.append(getClass().getSimpleName()).append("@")
					.append(Integer.toHexString(hashCode())).append(":{");
			Class<?> cls = getClass();
			while (cls != null) {
				Field[] fs = cls.getDeclaredFields();
				for (Field f : fs) {
					if (!Modifier.isStatic(f.getModifiers())) {
						if (!isFirst) {
							sb.append(",");
						}
						f.setAccessible(true);
						this.propertyToString(sb, f);
						isFirst = false;
					}
				}
				cls = cls.getSuperclass();
			}
			sb.append("}");
		} catch (Exception e) {
			e.printStackTrace();
			return super.toString();
		}

		return sb.toString();
	}

	public void copyTo(Object target) {
		BeanUtils.copyProperties(this, target);
		// try {
		// org.apache.commons.beanutils.BeanUtils.copyProperties(target, this);
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// e.printStackTrace();
		// }
	}

	public void copyFrom(Object source) {
		BeanUtils.copyProperties(source, this);
		// try {
		// org.apache.commons.beanutils.BeanUtils.copyProperties(this, source);
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// e.printStackTrace();
		// }
	}

}
