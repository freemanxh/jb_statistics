package com.jb.statistics.webapp.view;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class JsonModelAndView extends ModelAndView {

	public JsonModelAndView(Map<String, ?> model) {
		super(new JsonTextView(), model);
	}

	public JsonModelAndView(String modelName, Object modelObject) {
		super(new JsonTextView(), modelName, modelObject);
	}

	public JsonModelAndView() {
		super(new JsonTextView());
	}

	public JsonModelAndView(Object jsonBean) {
		super(new JsonTextView());
		getModelMap().put(JsonTextView.KEY_BEAN_DATA, jsonBean);
	}

}
