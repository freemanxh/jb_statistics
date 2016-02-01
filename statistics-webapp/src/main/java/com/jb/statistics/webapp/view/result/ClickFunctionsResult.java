package com.jb.statistics.webapp.view.result;

import java.util.List;

import com.jb.statistics.webapp.view.result.jsonentities.ClickFunctionsJsonEntity;

public class ClickFunctionsResult extends ResultView {
	private List<ClickFunctionsJsonEntity> result;

	public List<ClickFunctionsJsonEntity> getResult() {
		return result;
	}

	public void setResult(List<ClickFunctionsJsonEntity> result) {
		this.result = result;
	}

}
