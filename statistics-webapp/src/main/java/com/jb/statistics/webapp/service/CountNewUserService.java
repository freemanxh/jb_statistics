package com.jb.statistics.webapp.service;

import com.jb.statistics.webapp.view.NewUserView;

public interface CountNewUserService {

	NewUserView buildNewUserView(String startDate, String endDate, String projectId);

}
