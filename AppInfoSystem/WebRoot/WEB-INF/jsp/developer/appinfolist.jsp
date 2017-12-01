<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 信息管理维护 <small><i class="fa fa-user"></i>${devUserSession.devName }您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				<form id="demo-form2" data-parsley-validate
					class="form-horizontal form-label-left">
					<ul>
					<li>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">软件名称  
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="querySoftwareName" name="querySoftwareName" value="${querySoftwareName}"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>
					</li>
					<li>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="last-name">APP状态  
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<select name="queryStatus" class="form-control">
								<c:if test="${statusList}!=null"></c:if>
								<option value="">--请选择--</option>
								<c:forEach var="dataDictionary" items="${statusList}">
									<option <c:if test="${dataDictionary == queryStatus }">selected="selected"</c:if> value="dataDictionary.valueId" >${dataDictionary.valueName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					</li>
					<li>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<select name="queryFlatformId" class="form-control">
								<c:if test="${flatFormList != null }">
									<option value="">--请选择--</option>
									<c:forEach var="dataDictionary" items="${flatFormList}">
									    	<option <c:if test="${dataDictionary.valueId == queryFlatformId }">selected="selected"</c:if>
										value="${dataDictionary.valueId}">${dataDictionary.valueName}</option>
									</c:forEach>
								</c:if>
        					</select>
						</div>
					</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="queryCategoryLevel1" name="queryCategoryLevel1" class="form-control">
									<c:if test="${categoryLevel1List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel1List}">
									   		<option <c:if test="${appCategory.id == queryCategoryLevel1 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
        						<select name="queryCategoryLevel2" id="queryCategoryLevel2" class="form-control">
        							<c:if test="${categoryLevel2List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel2List}">
									   		<option <c:if test="${appCategory.id == queryCategoryLevel2 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
        						<select name="queryCategoryLevel3" id="queryCategoryLevel3" class="form-control">
        							<c:if test="${categoryLevel3List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel3List}">
									   		<option <c:if test="${appCategory.id == queryCategoryLevel3 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">查询</button>
					</div>
				</ul>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp"%>