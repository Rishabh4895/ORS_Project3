<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sunilOS.ORSProject3.ctl.ORSView"%>
<%@page import="com.sunilOS.ORSProject3.ctl.BaseCtl"%>
<%@page import="com.sunilOS.ORSProject3.ctl.RoleCtl"%>
<%@page import="com.sunilOS.ORSProject3.ctl.RoleListCtl"%>
<%@page import="com.sunilOS.ORSProject3.dto.RoleDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sunilOS.ORSProject3.util.ServletUtility"%>
<%@page import="com.sunilOS.ORSProject3.util.DataUtility"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Rays Technologies</title>
<link href="<%=ORSView.APP_CONTEXT%>/img/title.png" rel="icon"
	type="icon">
<link rel="stylesheet" href="<%=ORSView.APP_CONTEXT%>/css/FormView.css">
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script src="<%=ORSView.APP_CONTEXT%>/js/Checkbox11.js"></script>
<style>
.p1 {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/databg.jpg');
	background-size: 100%;
}
</style>
</head>
<body class="p1">
	<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">
		<%@include file="Header.jsp"%>

		<div>
			<center>
				<br>
				<h2 style="text-shadow: #343a40;">
					<u><b>Role List</b></u>
				</h2>

				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>
				<H6 align="center" style="width: 11.7cm; height: .5cm;">
					<div class="alert alert-success alert-dismissible">
						<%=ServletUtility.getSuccessMessage(request)%><button
							type="button" class="close" data-dismiss="alert">&times;</button>
					</div>
				</H6>
				<%
					}
				%>
				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<H6 align="center" style="width: 11.7cm; height: .5cm;">
					<div class="alert alert-danger alert-dismissible">
						<%=ServletUtility.getErrorMessage(request)%><button type="button"
							class="close" data-dismiss="alert">&times;</button>
					</div>
				</H6>
				<%
					}
				%>

				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;
					int nextPageSize = DataUtility.getInt(request.getAttribute("nextRoleListSize").toString());
					List roleList = ServletUtility.getList(request);
					Iterator<RoleDTO> it = roleList.iterator();
					if (roleList.size() != 0) {
				%>


				<br>
				<table>
					<tr>
						<td><input type="text" name="roleName"
							value="<%=ServletUtility.getParameter("roleName", request)%>"
							class="form-control" placeholder="Enter Role Name"
							style="width: 5.5cm;"></td>
						<td><input type="submit" name="operation"
							value="<%=RoleListCtl.OP_SEARCH%>" class="srpnbtn"></td>
						<td><input type="submit" name="operation"
							value="<%=RoleListCtl.OP_RESET%>" class="srpnbtn"></td>
					</tr>
				</table>

				<br>
				<table class="table table-sm table-hover" border="4"
					style="width: 80%;">
					<thead>
						<tr style="background-color: #343a40; color: white;">
							<th scope="col"><input type="checkbox" id="select_all"
								name="select"> Select All</th>
							<th scope="col">S.No</th>
							<th scope="col">Role Name</th>
							<th scope="col">Description</th>
							<th scope="col">Edit</th>
						</tr>
					</thead>

					<%
						while (it.hasNext()) {
								RoleDTO roleDTO = (RoleDTO) it.next();
					%><tbody>
						<tr style="background-color: white">
							<td><input type="checkbox" class="checkbox" name="ids"
								value="<%=roleDTO.getId()%>"
								<%if (roleDTO.getId() == RoleDTO.ADMIN) {%>
						<%="disabled"%> <%}%>></td>
							<td><%=index++%></td>
							<td><%=roleDTO.getRoleName()%></td>
							<td><%=roleDTO.getDescription()%></td>
							<td><button type="button" value="<%=RoleCtl.OP_EDIT%>"
									onclick="location.href='RoleCtl?id=<%=roleDTO.getId()%>'"
									<%=(roleDTO.getId() == RoleDTO.ADMIN ) ? "disabled"
										: ""%>
									class="fas fa-user-edit"></button></td>

						</tr>
						<%
							}
						%>
					</tbody>
				</table>

			</center>
			<button
				style="width: 1cm; height: 1cm; margin-right: 32%; margin-left: 11%; background-color: red;"
				type="submit" name="operation" value="<%=RoleListCtl.OP_DELETE%>"
				class="fa fa-trash-alt btn"></button>

			<input type="submit" name="operation"
				value="<%=RoleListCtl.OP_PREVIOUS%>"
				<%=(pageNo == 1) ? "disabled" : ""%> class="srpnbtn"> <input
				type="submit" name="operation" value="<%=RoleListCtl.OP_NEXT%>"
				<%=(nextPageSize != 0) ? "" : "disabled"%> class="srpnbtn">

			<input style="margin-right: 6%; margin-left: 26%;" type="submit"
				name="operation" value="<%=RoleListCtl.OP_NEW%>" class="srpnbtn">

			<%
				}
				if (roleList.size() == 0) {
			%>
			<br> <br> <input type="submit" name="operation"
				value="<%=RoleListCtl.OP_BACK%>" class="srpnbtn">

			<%
				}
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
		</div>
		<%@include file="Footer.jsp"%>
		<br> <br>
	</form>
</body>
</html>