package com.jb.statistics.webapp.view;

import java.util.List;

import com.jb.statistics.webapp.view.entities.UserCountEntity;

public class NewUserView extends BaseView {
	/**
	 * 所有的用户统计
	 */
	private UserCountEntity allUserCountEntity;

	/**
	 * 各个项目的统计列表
	 */
	private List<UserCountEntity> listUserCountEntity;

	public UserCountEntity getAllUserCountEntity() {
		return allUserCountEntity;
	}

	public void setAllUserCountEntity(UserCountEntity allUserCountEntity) {
		this.allUserCountEntity = allUserCountEntity;
	}

	public List<UserCountEntity> getListUserCountEntity() {
		return listUserCountEntity;
	}

	public void setListUserCountEntity(List<UserCountEntity> listUserCountEntity) {
		this.listUserCountEntity = listUserCountEntity;
	}

}
