<%@ page contentType="text/html; charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %><%
	String basePath = request.getContextPath();
%><!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
	<meta charset="utf-8" />
	<title>用户行为分析系统·嘉宝生活家</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<link href="<%=basePath%>/resources/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL STYLES -->
	<link href="<%=basePath%>/resources/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="<%=basePath%>/resources/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
	<!-- END THEME GLOBAL STYLES -->
	<!-- BEGIN THEME LAYOUT STYLES -->
	<link href="<%=basePath%>/resources/layouts/layout4/css/layout.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/resources/layouts/layout4/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
	<link href="<%=basePath%>/resources/layouts/layout4/css/custom.css" rel="stylesheet" type="text/css" />
	<!-- END THEME LAYOUT STYLES -->
	<link rel="shortcut icon" href="favicon.ico" /> </head>
<!-- END HEAD -->

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner ">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html">
				<img src="<%=basePath%>/resources/layouts/layout4/img/logo-big.png" alt="logo" class="logo-default" /> </a>
			<div class="menu-toggler sidebar-toggler">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->

		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			<!-- BEGIN HEADER SEARCH BOX -->
			<!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
			<form class="search-form" action="page_general_search_2.html" method="GET">
				<div class="input-group">
					<input type="text" class="form-control input-sm" placeholder="搜索..." name="query">
                            <span class="input-group-btn">
                                <a href="javascript:;" class="btn submit">
									<i class="icon-magnifier"></i>
								</a>
                            </span>
				</div>
			</form>
			<!-- END HEADER SEARCH BOX -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide"> </li>

					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
							<span class="username username-hide-on-mobile"> 管理员 </span>
							<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
							<img alt="" class="img-circle" src="<%=basePath%>/resources/layouts/layout4/img/avatar9.jpg" /> </a>
						<ul class="dropdown-menu dropdown-menu-default">
							<%--<li>
                                <a href="page_user_profile_1.html">
                                    <i class="icon-user"></i> My Profile </a>
                            </li>
                            <li>
                                <a href="app_calendar.html">
                                    <i class="icon-calendar"></i> My Calendar </a>
                            </li>
                            <li>
                                <a href="app_inbox.html">
                                    <i class="icon-envelope-open"></i> My Inbox
                                    <span class="badge badge-danger"> 3 </span>
                                </a>
                            </li>
                            <li>
                                <a href="app_todo_2.html">
                                    <i class="icon-rocket"></i> My Tasks
                                    <span class="badge badge-success"> 7 </span>
                                </a>
                            </li>
                            <li class="divider"> </li>
                            <li>
                                <a href="page_user_lock_1.html">
                                    <i class="icon-lock"></i> Lock Screen </a>
                            </li>--%>
							<li>
								<a href="page_user_login_1.html">
									<i class="icon-key"></i> 退出系统 </a>
							</li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->

				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<!-- BEGIN HEADER & CONTENT DIVIDER -->
<div class="clearfix"> </div>
<!-- END HEADER & CONTENT DIVIDER -->
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- BEGIN SIDEBAR -->
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
			<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
			<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
			<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<ul class="page-sidebar-menu   " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="nav-item start active open">
					<a href="javascript:;" class="nav-link nav-toggle">
						<i class="icon-home"></i>
						<span class="title">基础统计</span>
						<span class="selected"></span>
						<span class="arrow open"></span>
					</a>
					<ul class="sub-menu">
						<li class="nav-item start">
							<a href="<%=basePath%>/userlogs/click.do" class="nav-link ">
								<i class="icon-bar-chart"></i>
								<span class="title">点击时段</span>
								<span class="selected"></span>
							</a>
						</li>
						<li class="nav-item  active open">
							<a href="<%=basePath%>/userlogs/clickFunctions.do" class="nav-link ">
								<i class="icon-bulb"></i>
								<span class="title">热点功能</span>
							</a>
						</li>
						<li class="nav-item start ">
							<a href="<%=basePath%>/userlogs/newUsers.do" class="nav-link ">
								<i class="icon-graph"></i>
								<span class="title">用户数统计</span>
							</a>
						</li>
					</ul>
				</li>



			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<!-- BEGIN CONTENT BODY -->
		<div class="page-content">
			<!-- BEGIN PAGE HEAD-->
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>热点功能
						<small>用户热点功能统计</small>
					</h1>
				</div>
				<!-- END PAGE TITLE -->
				<!-- BEGIN PAGE TOOLBAR -->
				<div class="page-toolbar">

				</div>
				<!-- END PAGE TOOLBAR -->
			</div>
			<!-- END PAGE HEAD-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li>
					<a href="index.html">首页</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<span class="active">热点功能</span>
				</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE BASE CONTENT -->
			<!-- BEGIN DASHBOARD STATS 1-->
			<%-- <div class="row">
                 <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                     <div class="dashboard-stat blue">
                         <div class="visual">
                             <i class="fa fa-comments"></i>
                         </div>
                         <div class="details">
                             <div class="number">
                                 <span data-counter="counterup" data-value="1349">0</span>
                             </div>
                             <div class="desc"> 新增用户 </div>
                         </div>
                         <a class="more" href="javascript:;"> 更多
                             <i class="m-icon-swapright m-icon-white"></i>
                         </a>
                     </div>
                 </div>
                 <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                     <div class="dashboard-stat red">
                         <div class="visual">
                             <i class="fa fa-bar-chart-o"></i>
                         </div>
                         <div class="details">
                             <div class="number">
                                 <span data-counter="counterup" data-value="12,5">0</span></div>
                             <div class="desc"> 活跃用户 </div>
                         </div>
                         <a class="more" href="javascript:;"> 更多
                             <i class="m-icon-swapright m-icon-white"></i>
                         </a>
                     </div>
                 </div>
                 <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                     <div class="dashboard-stat green">
                         <div class="visual">
                             <i class="fa fa-shopping-cart"></i>
                         </div>
                         <div class="details">
                             <div class="number">
                                 <span data-counter="counterup" data-value="549">0</span>
                             </div>
                             <div class="desc"> 累计用户 </div>
                         </div>
                         <a class="more" href="javascript:;"> 更多
                             <i class="m-icon-swapright m-icon-white"></i>
                         </a>
                     </div>
                 </div>

             </div>
             <div class="clearfix"></div>--%>
			<!-- END DASHBOARD STATS 1-->

			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="portlet light tasks-widget bordered">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-share font-green-haze hide"></i>
								<span class="caption-subject font-green bold uppercase">热点功能</span>
								<span class="caption-helper">用户热点功能</span>
							</div>
							<div class="actions">
								<div class="btn-group">
									<div id="dashboard-report-range" class="pull-right tooltips btn btn-fit-height green" data-placement="top" data-original-title="修改查看时间区间">
										<i class="icon-calendar"></i>&nbsp;
										<span class="thin uppercase hidden-xs"></span>&nbsp;
										<i class="fa fa-angle-down"></i>
									</div>
								</div>
								<div class="btn-group">
									<select id="projectId" class="form-control select2">
										<option value="0"  <c:if test="${projectId==0}">selected</c:if>>全部项目</option>
										<c:forEach items="${projects}" var="item" varStatus="vs">
											<option value="${item.projectId }" <c:if test="${projectId==item.projectId}">selected</c:if>> ${item.projectName } </option>
										</c:forEach>
									</select>

									<%--<a class="btn green btn-circle btn-sm" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> 项目
                                        <i class="fa fa-angle-down"></i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li>
                                            <a href="javascript:;"> 全部项目 </a>
                                        </li>
                                        <li class="divider"> </li>
                                        <c:forEach items="${projects}" var="item" varStatus="vs">
                                            <option value="${item.projectId }" <c:if test="${projectId==item.projectId}">selected</c:if> ></option>
                                            <li>
                                                <a href="javascript:;" data-key="${item.projectId }"> ${item.projectName } </a>
                                            </li>
                                        </c:forEach>

                                    </ul>--%>
								</div>

								<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;" data-original-title="全屏" title=""> </a>

							</div>
						</div>
						<div class="portlet-body">
							<div id="site_statistics_loading">
								<img src="<%=basePath%>/resources/global/img/loading.gif" alt="loading" /> </div>
							<div class="row">
								<div class=" col-md-6 col-sm-6">
									<div class="table-scrollable table-scrollable-borderless" id="site_statistics_table">
										<table class="table table-striped table-bordered table-advance table-hover">
											<thead>
											<tr class="uppercase">
												<th> 功能 </th>
												<th> 点击数 </th>
											</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
								</div>

								<div class="col-md-6">
									<div id="donut" class="chart"> </div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
			<!-- END PAGE BASE CONTENT -->
		</div>
		<!-- END CONTENT BODY -->
	</div>
	<!-- END CONTENT -->

</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
	<div class="page-footer-inner"> 2014 &copy; 嘉宝集团.</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<!-- END FOOTER -->
<!--[if lt IE 9]>
<script src="<%=basePath%>/resources/global/plugins/respond.min.js"></script>
<script src="<%=basePath%>/resources/global/plugins/excanvas.min.js"></script>
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script>var basicPath = '<%=basePath%>';</script>
<script src="<%=basePath%>/resources/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<%=basePath%>/resources/global/plugins/moment.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>

<script src="<%=basePath%>/resources/global/plugins/echarts/echarts-all.js" type="text/javascript"></script>

<%--
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.stack.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.crosshair.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/flot/jquery.flot.axislabels.js" type="text/javascript"></script>
--%>


<script src="<%=basePath%>/resources/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/scripts/datatable.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/resources/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="<%=basePath%>/resources/global/scripts/app.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=basePath%>/resources/pages/scripts/charts-echarts.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="<%=basePath%>/resources/layouts/layout4/scripts/layout.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
</body>

</html>

