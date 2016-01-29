package com.jb.statistics.webapp.service;

import com.jb.statistics.webapp.view.ClickFunctionsView;

public interface CountClickFunctionsService {

	ClickFunctionsView buildClickFuncitonsView(String startDate, String endDate, String projectId);

}
