package com.jb.statistics.webapp.service;

import com.jb.statistics.webapp.view.ClickView;




public interface CountClickService {

	ClickView buildClickView(String startDate, String endDate, String projectId);

}
