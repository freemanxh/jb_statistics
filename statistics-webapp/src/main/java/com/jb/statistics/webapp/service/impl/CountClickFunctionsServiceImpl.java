package com.jb.statistics.webapp.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.statis.entities.ClickFunctionBean;
import com.jb.statistics.webapp.service.CountClickFunctionsService;
import com.jb.statistics.webapp.view.ClickFunctionsView;
import com.jb.statistics.webapp.view.entities.ClickFunctionEntity;

@Service("countClickFunctionsService")
public class CountClickFunctionsServiceImpl extends BaseServiceImpl implements CountClickFunctionsService {

	public static final String[] FUNC_NAMES = { "", "一键开门", "小区公告", "在线报修", "在线缴费", "物业投诉", "我的邮包", "便名服务", "房屋租售", "专属客服", "拎包入住", "生活家", "邻里", "实惠", "我的", "小区消息", "轮播广告", "热门团购", "优质商家", "精选商品", "热门活动" };

	public ClickFunctionsView buildClickFuncitonsView(String startDate, String endDate, String projectId) {

		ClickFunctionsView view = new ClickFunctionsView();

		List<ClickFunctionBean> list = this.countLogs.countByDayByProject(startDate, endDate, projectId);

		int sumClick = 0;

		Set<Integer> set = new HashSet<Integer>();
		if (list != null) {
			for (ClickFunctionBean cfb : list) {
				if (cfb != null) {
					set.add(Integer.parseInt(cfb.getFunctionType()));
				}
			}
		}

		for (int i = 1, s = FUNC_NAMES.length; i <= s; i++) {
			if (!set.contains(i)) {
				ClickFunctionBean cfBean = new ClickFunctionBean();
				cfBean.setFunctionType(String.valueOf(i));
				cfBean.setTimes(0);
				cfBean.setUsers(0);
				list.add(cfBean);
			}
		}

		for (ClickFunctionBean cfb : list) {
			if (cfb != null) {
				sumClick += cfb.getTimes();
			}
		}

		NumberFormat nf = new DecimalFormat("0.00");
		List<ClickFunctionEntity> ll = new ArrayList<ClickFunctionEntity>();
		for (ClickFunctionBean cfb : list) {
			if (cfb != null) {
				if (Integer.parseInt(cfb.getFunctionType()) >= FUNC_NAMES.length) {
					continue;
				}
				int clicks = cfb.getTimes();
				if (sumClick > 0) {
					float persent = clicks / (float) sumClick;
					persent *= 100;
					cfb.setPercent(nf.format(persent));
				}
				else{
					cfb.setPercent("0.00");
				}

				cfb.setFunctionName(FUNC_NAMES[Integer.parseInt(cfb.getFunctionType())]);
				ClickFunctionEntity cfe = new ClickFunctionEntity();
				BeanUtils.copyProperties(cfb, cfe);
				ll.add(cfe);
			}
		}

		Set<ClickFunctionEntity> sortSet = new TreeSet<ClickFunctionEntity>(ll);
		List<ClickFunctionEntity> ll2 = new ArrayList<ClickFunctionEntity>(sortSet);
		view.setFunctionList(ll2);
		return view;

	}

}
