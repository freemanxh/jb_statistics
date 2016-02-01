package com.jb.statistics.webapp.view;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.view.AbstractView;

public class JsonTextView extends AbstractView {

	private static final Log log = LogFactory.getLog(JsonTextView.class);

	public static final String KEY_BEAN_DATA = "MsgRespView.KEY_BEAN_DATA";

	protected String characterEncoding = "UTF-8";

	private static ObjectMapper jsonObj = new ObjectMapper();
	static {
		jsonObj.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
		// jsonObj.setSerializationInclusion(Inclusion.NON_EMPTY);
		// jsonObj.setSerializationInclusion(Inclusion.NON_NULL);
		// jsonObj.setSerializationInclusion(incl)
	}

	public static final String TYPE_REQ_JSON = "json";

	public static final String TYPE_REQ_XML = "xml";

	public JsonTextView() {
		super();
		setContentType("text/plain; charset=UTF-8");
	}

	public static String toJsonStr(Object bean) {
		try {
			String s = jsonObj.writeValueAsString(fix(bean));
			return s;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.reset();
		response.setContentType(getContentType());
		response.setCharacterEncoding(characterEncoding);
		//
		Object bean = model.get(KEY_BEAN_DATA);
		if (bean == null) {
			bean = request.getAttribute(KEY_BEAN_DATA);
		}
		if (bean == null) {
			bean = model;
		}
		String type = this.determineReqType(request, model);
		if (TYPE_REQ_JSON.equalsIgnoreCase(type)) {
			jsonObj.writeValue(response.getWriter(), fix(bean));
		} else if (TYPE_REQ_XML.equalsIgnoreCase(type)) {
			log.error("The 'xml' type for response has not been implemented!");
			throw new RuntimeException("The 'xml' type for response has not been implemented!");
		} else {
			log.error("It is not support type of " + type + " for response !");
			throw new RuntimeException("It is not support type of " + type + " for response !");
		}
	}

	/**
	 * 分析期望请求返回JSON数据还是XML数据
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	private String determineReqType(HttpServletRequest request, Map<String, Object> model) {
		return TYPE_REQ_JSON;
	}

	private static Object fix(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
		if (fields != null) {
			for (Field f : fields) {
				f.setAccessible(true);
				try {
					Object o = f.get(object);
					if (o == null) {
						// String s=f.getClass().getSimpleName();
						String s = f.getType().getSimpleName();
						// System.out.println(s);
						if (s.equals("String")) {
							f.set(object, "");
						} else if (s.equals("Integer")) {
							f.set(object, 0);
						} else if (s.equals("Long")) {
							f.set(object, o);
						} else if (s.equals("Object")) {
							f.set(object, new Object());
						} else if (s.equals("List")) {
							f.set(object, new ArrayList());
						} else if (s.equals("Set")) {
							f.set(object, new HashSet());
						} else if (s.equals("Map")) {
							f.set(object, new HashMap());
						} else if (s.equals("String[]")) {
							f.set(object, new String[] {});
						}
					}

					// else {
					// if (o instanceof View) {
					// o = fix(o);
					// } else if (o instanceof Collection) {
					// Collection<?> coll = (Collection<?>) o;
					// for (Iterator<?> it = coll.iterator(); it.hasNext();) {
					// Object o2 = it.next();
					// if (o2 != null && o2 instanceof View) {
					// o2 = fix(o2);
					// }
					// }
					// }
					// }
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return object;
	}
}
