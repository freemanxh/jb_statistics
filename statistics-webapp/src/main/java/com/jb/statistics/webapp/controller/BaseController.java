package com.jb.statistics.webapp.controller;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

//	protected ModelAndView successMessageMav(String msg) {
//		return this.messageMav(msg, 0);
//	}
//
//	protected ModelAndView successMav() {
//		return this.messageMav("ok", 0);
//	}
//
//
////	protected ModelAndView codeMav(int code) {
////		ResultView rv = new ResultView();
////		rv.setCode(code);
////		return new JsonModelAndView(rv);
////	}
//
//	protected String[] split(String codeAndMsg) {
//		if (!codeAndMsg.contains("|")) {
//			throw new RuntimeException("codeAndMsg must has |");
//		}
//		String[] ss = codeAndMsg.split("\\|");
//		return ss;
//	}
//
//	protected ModelAndView errorMavMsg(String msg) {
//		String[] ss = this.split(msg);
//		Integer code = Integer.parseInt(ss[0], 16);
//		String f = ss[2];
//		if ("show".equals(f)) {
//			code |= 0x00020000;
//		} else if ("show_mt".equals(f)) {
//			code |= 0x00030000;
//		} else if ("mt".equals(f) || "system_mt".equals(f)) {
//			code |= 0x00010000;
//		}
//		return this.messageMav(ss[1], code);
//	}
//
////	protected ModelAndView errorMav(String codeAndMsg) {
////		String[] ss = this.split(eCode.get(codeAndMsg));
////		Integer code = Integer.parseInt(ss[0], 16);
////		String f = ss[2];
////		if ("show".equals(f)) {
////			code |= 0x00020000;
////		} else if ("show_mt".equals(f)) {
////			code |= 0x00030000;
////		} else if ("mt".equals(f) || "system_mt".equals(f)) {
////			code |= 0x00010000;
////		}
////		return this.messageMav(ss[1], code);
////	}
////
////	protected ModelAndView errorMav(String codeAndMsg, String msg) {
////		String[] ss = this.split(eCode.get(codeAndMsg));
////		Integer code = Integer.parseInt(ss[0], 16);
////		String f = ss[2];
////		if ("show".equals(f)) {
////			code |= 0x00020000;
////		} else if ("show_mt".equals(f)) {
////			code |= 0x00030000;
////		} else if ("mt".equals(f) || "system_mt".equals(f)) {
////			code |= 0x00010000;
////		}
////		return this.messageMav(msg, code);
////	}
//
//
//
//	protected ModelAndView messageMav(String msg, int code) {
//		ResultView rv = new ResultView();
//		rv.setCode(code);
//		rv.setMessage(msg);
//		return new JsonModelAndView(rv);
//	}
//
//	protected ModelAndView errorObjectMav(ErrorView ev) {
//		ResultView rv = new ResultView();
//		rv.setCode(ev.getCode());
//		rv.setMessage("");
//		rv.setObject(ev);
//
//		return new JsonModelAndView(rv);
//	}
//
//	protected ModelAndView successObjectMav(View view) {
//		ResultView rv = new ResultView();
//		rv.setObject(view);
//		return new JsonModelAndView(rv);
//	}
//
//	protected ModelAndView successObjectMav(TBase tBase) {
//		return new JsonModelAndView(tBase);
//	}
//
//	protected ModelAndView successObjectMav(Collection<TBase> coll) {
//		return new JsonModelAndView(coll);
//	}
//
//	protected ModelAndView successObjectMav(String s) {
//		return new JsonModelAndView(s);
//	}
//
//	protected ModelAndView errorObjectMav(String msg) {
//		return errorMavMsg(msg);
//	}
//
//	protected ModelAndView errorObjectMav(int code, View view) {
//		ResultView rv = new ResultView();
//		rv.setObject(view);
//		rv.setCode(code);
//		return new JsonModelAndView(rv);
//	}
}
