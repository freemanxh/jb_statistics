package com.jb.statistics.common.dao;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jb.statistics.common.utils.Constants;
import com.jb.statistics.common.utils.ReflectionUtils;

/**
 * 封装Hibernate原生API的DAO泛型基类.
 * <p/>
 * 可在Service层直接使用, 也可以扩展泛型DAO子类使用, 见两个构造函数的注释. 参考Spring2.5自带的Petlinc例子,
 * 取消了HibernateTemplate, 直接使用Hibernate原生API.
 * 
 * @param <T>
 *            DAO操作的对象类型
 * @author cjp
 */
@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> {

	@Autowired
	protected Constants daoConstants;

//	@Autowired
//	protected TaskThread taskExecutor; 
	// =TaskThreadImpl.getInstance();

	protected Class<T> entityClass;

	protected Map<String, Method> mapMethods = new HashMap<String, Method>();

	/**
	 * 用于Dao层子类使用的构造函数. 通过子类的泛型定义取得对象类型Class. eg. public class UserDao extends
	 * BaseDao<User>
	 */
	public BaseDAO() {
		entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
		Method[] methods = entityClass.getMethods();
		if (methods != null) {
			for (Method m : methods) {
				if (m != null) {
					String name = m.getName();
					if ((name.startsWith("set") || name.startsWith("get")) && !name.contains("IsSet") && !name.contains("FieldValue") && !name.contains("getClass") && !name.endsWith("Iterator")) {
						mapMethods.put(m.getName(), m);
					}
				}
			}
		}
	}

}