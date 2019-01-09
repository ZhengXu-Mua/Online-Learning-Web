<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学码网</title>
		<link rel="stylesheet" type="text/css" href="../css/index.css">
		<link rel="stylesheet" type="text/css" href="../css/comm.css">
		<link rel="stylesheet" type="text/css" href="../css/course.css">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/course.js"></script>
		<script type="text/javascript" src="../js/index.js"></script>
		<script type="text/javascript">
			function findCourse(courseDirectionId,courseContentId){
				document.location.href = "/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId="+courseDirectionId+"&courseContentId="+courseContentId+"&page=1";
			};
		</script>
	</head>
	<body id="body">
		<!-- 引入头部start -->
		<%@ include file="head.jsp" %>
		<!-- 引入头部end -->
	
		<div class="category">
			<div class="auto">
				<ul>
					<li>
						<label class="direction">方向:</label>
						<span <c:if test="${courseDirectionId==0}">class="current"</c:if>onclick="findCourse(0,0);">全部</span>
						<c:forEach items="${courseDirections}" var="courseDirection">
							<c:choose>
								<c:when test="${param.courseDirectionId==courseDirection.id}">
									<span class="current">${courseDirection.name}</span>
								</c:when>
								<c:otherwise>
									<span onclick="findCourse(${courseDirection.id},0);" >${courseDirection.name}</span>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</li>
					<li>
						<label class="content">内容:</label>
						<c:if test="${param.courseContentId==0}">
							<span class="current" >全部</span>
						</c:if>
						<c:if test="${param.courseContentId!=0}">
							<span onclick="findCourse(${param.courseDirectionId},0);">全部</span>
						</c:if>
						<c:forEach items="${courseContents}" var="courseContent">
							<c:choose>
								<c:when test="${param.courseContentId==courseContent.id}">
									<span class="current">${courseContent.name}</span>
								</c:when>
								<c:otherwise>
									<span onclick="findCourse(${param.courseDirectionId},${courseContent.id});" >${courseContent.name}</span>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</li>
				</ul>
			</div>
		</div>
		<!-- course_box -->
		<div class="course_box autoH">
			<div class="auto courses">
				<c:forEach items="${courses}" var="course">
					<a href="/XMSCode_SSM_V1/main/toVideo.do?courseId=${course.id}">
						<div class="course c_1">
							<img src="${course.picture_url}">
							<!--  
							<h3>设计工具</h3>
							-->
							<div>
								<p class="p1">${course.name}</p>
								<p class="p2">${course.description}</p>
								<p class="p2 p3">初级.4人在学</p>
							</div>
						</div>
					</a>
				</c:forEach>
	
			</div>
			<!--分页-->
			<!--<div class="Page navigation">
                <div class="pagination">
                        
                </div>
            </div>
			-->
			<div id="pages" class="pages">
				
					<span class="prev"><a <c:if test="${page>1}">href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${page-1}"</c:if>>上一页</a></span>
				
					    <c:if  test="${pages<=5}">
					    	<c:forEach begin="1" end = "${pages}" step = "1" var="i">
					    		<c:choose>
					    				<c:when test="${i==page}">
					    					<span class="current_page">${i}</span>
					    				</c:when>
					    				<c:otherwise>
					    					<li><span><a href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${i}">${i}</a></span></li>
										</c:otherwise>
					    			</c:choose>
					    	</c:forEach>
					    </c:if>
					 	
					 	<c:if  test="${pages>5}">
					 		<c:choose>
					 		<c:when  test="${page<3}">
					    		<c:forEach begin="1" end = "5" step = "1" var="i">
					    			<c:choose>
					    				<c:when test="${i==page}">
					    					<span class="current_page">${i}</span>
					    				</c:when>
					    				<c:otherwise>
					    					<li><span><a href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${i}">${i}</a></span></li>
										</c:otherwise>
										
					    			</c:choose>
					    		</c:forEach>
					 		</c:when>
					 		<c:when  test="${page>pages-3}">
					    		<c:forEach begin="${pages-4}" end = "${pages}" step = "1" var="i">
					    			<c:choose>
					    				<c:when test="${i==page}">
					    					<span class="current_page">${i}</span>
					    				</c:when>
					    				<c:otherwise>
					    					<li><span><a href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${i}">${i}</a></span></li>
										</c:otherwise>
					    			</c:choose>
					    		</c:forEach>
					 		</c:when>
					 		<c:otherwise>
					    		<c:forEach begin="${page-2}" end = "${page+2}" step = "1" var="i">
					    			<c:choose>
					    				<c:when test="${i==page}">
					    					<span class="current_page">${i}</span>
					    				</c:when>
					    				<c:otherwise>
					    				
					    					<span><a href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${i}">${i}</a></span>
										</c:otherwise>
					    			</c:choose>
					    		</c:forEach>
					 		</c:otherwise>
					 		</c:choose>
					 	</c:if>
					    <span class="next"><a <c:if test="${page<pages}">href="/XMSCode_SSM_V1/main/toCourse.do?courseDirectionId=${courseDirectionId}&courseContentId=${courseContentId}&page=${page+1}"</c:if>>下一页</a></span>
			</div>
		</div>
		<!-- foot -->
		<div class="foot foot_blue">
			<a href="#">关于我们</a>
			<a href="#">最新动态</a>
			<a href="#">代理合作</a>
			<span>南京学码思科技教育有限公司</span>       
			<span>@2017</span> 
			<span>京ICP备</span>
			<span>1234567号</span>      
		</div>
	
	
	
	</body>
</html>