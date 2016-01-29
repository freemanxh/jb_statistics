package com.jb.statistics.webapp.view;

import java.util.List;

import com.jb.statistics.webapp.view.entities.ClickFunctionEntity;

public class ClickFunctionsView extends BaseView {
	List<ClickFunctionEntity> functionList;

	public List<ClickFunctionEntity> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<ClickFunctionEntity> functionList) {
		this.functionList = functionList;
	}

}
