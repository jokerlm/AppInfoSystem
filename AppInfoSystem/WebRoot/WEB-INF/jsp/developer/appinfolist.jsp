<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 信息管理维护 <small><i class="fa fa-user"></i>${devUserSession.devName
						}您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				<form id="demo-form2" data-parsley-validate
					class="form-horizontal form-label-left">
					<input type="hidden" name="pageIndex" value="1"/>
					<ul>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="first-name">软件名称 </label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="querySoftwareName"
										name="querySoftwareName" value="${querySoftwareName}"
										class="form-control col-md-7 col-xs-12">
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="last-name">APP状态 </label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="queryStatus" class="form-control">
										<c:if test="${statusList}!=null"></c:if>
										<option value="">--请选择--</option>
										<c:forEach var="dataDictionary" items="${statusList}">
											<option
												<c:if test="${dataDictionary == queryStatus }">selected="selected"</c:if>
												value="dataDictionary.valueId">${dataDictionary.valueName}</option>
										</c:forEach>
									</select>
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="queryFlatformId" class="form-control">
										<c:if test="${flatFormList != null }">
											<option value="">--请选择--</option>
											<c:forEach var="dataDictionary" items="${flatFormList}">
												<option
													<c:if test="${dataDictionary.valueId == queryFlatformId }">selected="selected"</c:if>
													value="${dataDictionary.valueId}">${dataDictionary.valueName}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="queryCategoryLevel1" name="queryCategoryLevel1"
										class="form-control">
										<c:if test="${categoryLevel1List != null }">
											<option value="">--请选择--</option>
											<c:forEach var="appCategory" items="${categoryLevel1List}">
												<option
													<c:if test="${appCategory.id == queryCategoryLevel1 }">selected="selected"</c:if>
													value="${appCategory.id}">${appCategory.categoryName}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="hidden" name="categorylevel2list"
										id="categorylevel2list" /> <select name="queryCategoryLevel2"
										id="queryCategoryLevel2" class="form-control">
										<c:if test="${categoryLevel2List != null }">
											<option value="">--请选择--</option>
											<c:forEach var="appCategory" items="${categoryLevel2List}">
												<option
													<c:if test="${appCategory.id == queryCategoryLevel2 }">selected="selected"</c:if>
													value="${appCategory.id}">${appCategory.categoryName}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="queryCategoryLevel3" id="queryCategoryLevel3"
										class="form-control">
										<c:if test="${categoryLevel3List != null }">
											<option value="">--请选择--</option>
											<c:forEach var="appCategory" items="${categoryLevel3List}">
												<option
													<c:if test="${appCategory.id == queryCategoryLevel3 }">selected="selected"</c:if>
													value="${appCategory.id}">${appCategory.categoryName}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div></li>
						<li>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">查询</button>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</div>
	<div class="x_panel">
		<div class="x_content">
		<a href="" class="btn btn-success">新增APP基础信息</a>
			<table id="datatable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>软件名称</th>
						<th>APK名称</th>
						<th>软件大小（单位：M）</th>
						<th>所属平台</th>
						<th>所属分类</th>
						<th>状态</th>
						<th>下载次数</th>
						<th>最新版本号</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="appinfo" items="${appInfoList}">
						<tr>
							<td>${appinfo.softwareName }</td>
							<td>${appinfo.APKName }</td>
							<td>${appinfo.softwareSize }</td>
							<td>${appinfo.flatformName }</td>
							<td>${appinfo.categoryLevel1Name
								}->${appinfo.categoryLevel2Name }->${appinfo.categoryLevel3Name
								}</td>
							<td>${appinfo.statusName }</td>
							<td>${appinfo.downloads }</td>
							<td>${appinfo.versionNo }</td>
							<td><div class="btn-group">
									<button type="button" class="btn btn-danger">点击操作</button>
									<button type="button" class="btn btn-danger dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="caret"></span> <span class="sr-only">Toggle
											Dropdown</span>
									</button>
									<ul class="dropdown-menu" role="menu">
									<li><c:choose>
										<c:when test="${appinfo.status == 2 || appinfo.status == 5}">
											<a href="#">上架</a>
										</c:when>
										<c:when test="${appinfo.status == 4 || appinfo.status == 5}">
											<a href="#">下架</a>
										</c:when>
									</c:choose></li>
										<li><a href="#">新增版本</a></li>
										<li><a href="#">修改版本</a></li>
										<li><a href="#">修改</a></li>
										<li><a href="#">查看</a></li>
										<li><a href="#">删除</a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div class="row">
					<div class="col-sm-5">
						<div class="dataTables_info" id="datatable-responsive_info"
							role="status" aria-live="polite">共${pages.totalCount }条记录
							${pages.currentPageNo }/${pages.totalPageCount }页</div>
					</div>
					<div class="col-sm-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable-responsive_paginate">
							<ul class="pagination">
								<c:if test="${pages.currentPageNo > 1}">
									<li class="paginate_button previous"><a
										href="javascript:page_nav(document.forms[0],1);"
										aria-controls="datatable-responsive" data-dt-idx="0"
										tabindex="0">首页</a>
									</li>
									<li class="paginate_button "><a
										href="javascript:page_nav(document.forms[0],${pages.currentPageNo-1});"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">上一页</a>
									</li>
								</c:if>
								<c:if test="${pages.currentPageNo < pages.totalPageCount }">
									<li class="paginate_button "><a
										href="javascript:page_nav(document.forms[0],${pages.currentPageNo+1 });"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">下一页</a>
									</li>
									<li class="paginate_button next"><a
										href="javascript:page_nav(document.forms[0],${pages.totalPageCount });"
										aria-controls="datatable-responsive" data-dt-idx="7"
										tabindex="0">最后一页</a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
		<%@include file="common/footer.jsp"%>
		<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>