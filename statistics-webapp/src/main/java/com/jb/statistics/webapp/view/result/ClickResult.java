package com.jb.statistics.webapp.view.result;

import java.util.List;

import com.jb.statistics.webapp.view.result.jsonentities.ClickJsonEntity;

public class ClickResult extends ResultView {
	private List<ClickJsonEntity> result;

	public List<ClickJsonEntity> getResult() {
		return result;
	}

	public void setResult(List<ClickJsonEntity> result) {
		this.result = result;
	}

}
