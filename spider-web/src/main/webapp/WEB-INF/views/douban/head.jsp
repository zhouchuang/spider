<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse">
		  <div class="navbar-inner">
		   <div class="container-fluid">
			  <a class="brand" href="#"><small><i class="icon-leaf"></i> 豆瓣大数据分析</small> </a>
			  <ul class="nav ace-nav pull-right">
					<li class="grey">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-tasks"></i>
							<span class="badge">4</span>
						</a>
						<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
							<li class="nav-header">
								<i class="icon-ok"></i> 4 项任务正在进行
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left">豆瓣读书（小说）</span>
										<span class="pull-right">65%</span>
									</div>
									<div class="progress progress-mini"><div class="bar" style="width:65%"></div></div>
								</a>
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left">豆瓣读书（历史）</span>
										<span class="pull-right">35%</span>
									</div>
									<div class="progress progress-mini progress-danger"><div class="bar" style="width:35%"></div></div>
								</a>
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left">豆瓣读书（哲学）</span>
										<span class="pull-right">15%</span>
									</div>
									<div class="progress progress-mini progress-warning progress-striped active" ><div class="bar" style="width:15%"></div></div>
								</a>
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left">豆瓣读书（职场）</span>
										<span class="pull-right">90%</span>
									</div>
									<div class="progress progress-mini progress-success progress-striped active"><div class="bar" style="width:90%"></div></div>
								</a>
							</li>
						</ul>
					</li>
			  		<li class="light-blue user-profile">
						<a class="user-menu dropdown-toggle" href="#" data-toggle="dropdown">
							<img alt="Jason's Photo" src="${ctx}/static/ace/avatars/user.jpg" class="nav-user-photo" />
							<span id="user_info">
								<small>欢迎,</small> 周创
							</span>
							<i class="icon-caret-down"></i>
						</a>
						<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
							<li><a href="#"><i class="icon-cog"></i> Settings</a></li>
							<li><a href="#"><i class="icon-user"></i> Profile</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="icon-off"></i> Logout</a></li>
						</ul>
					</li>
			  </ul><!--/.ace-nav-->
		   </div><!--/.container-fluid-->
		  </div><!--/.navbar-inner-->
		</div><!--/.navbar-->
		