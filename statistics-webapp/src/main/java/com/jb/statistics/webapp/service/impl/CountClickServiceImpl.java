package com.jb.statistics.webapp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.statis.entities.ClickBean;
import com.jb.statistics.webapp.service.CountClickService;
import com.jb.statistics.webapp.view.ClickView;
import com.jb.statistics.webapp.view.entities.ClickEntity;

@Service("countClickService")
public class CountClickServiceImpl extends BaseServiceImpl implements CountClickService {

	public ClickView buildClickView(String startDate, String endDate, String projectId) {
		List<ClickBean> list = this.countLogs.countByHour(startDate, endDate, projectId, 0, 0);
		Set<Integer> set = new HashSet<Integer>();
		if (list != null) {
			for (ClickBean cb : list) {
				set.add(new Integer(cb.getTimeSeg()));
			}
		}

		for (int i = 0; i < 24; i++) {
			if (!set.contains(i)) {
				ClickBean cb = new ClickBean();
				cb.setTimes(0);
				cb.setTimeSeg(String.valueOf(i));
				list.add(cb);
			}
		}

		for (ClickBean cb : list) {
			if (cb != null) {
				String ts = cb.getTimeSeg();
				cb.setTimeSeg(ts + ":00-" + ts + ":59");
			}
		}
		
		List<ClickEntity> ll = new ArrayList<ClickEntity>();
		Set<ClickBean> sortSet=new TreeSet<ClickBean>(list);
		for (ClickBean cb:sortSet){
			ClickEntity ce = new ClickEntity();
			BeanUtils.copyProperties(cb, ce);
			ll.add(ce);
		}
		
		ClickView cv = new ClickView();
		cv.setList(ll);
		return cv;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml" });
		if (ac != null) {

			CountClickService logsProxyServer = (CountClickService) ac.getBean("countClickService");

		}
	}

}
