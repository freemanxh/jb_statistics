package com.jb.statistics.webapp.view.result.jsonentities;

import java.util.List;

public class NewUserResultView {
	private NewUserJsonEntity allEntities;
	private List<NewUserJsonEntity> detail;

	public NewUserJsonEntity getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(NewUserJsonEntity allEntities) {
		this.allEntities = allEntities;
	}

	public List<NewUserJsonEntity> getDetail() {
		return detail;
	}

	public void setDetail(List<NewUserJsonEntity> detail) {
		this.detail = detail;
	}

}
