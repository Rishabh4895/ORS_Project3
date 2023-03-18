<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sunilOS.ORSProject3.ctl.ORSView"%>
<%@page import="com.sunilOS.ORSProject3.model.ModelFactory"%>
<%@page import="com.sunilOS.ORSProject3.model.RoleModelInt"%>
<%@page import="com.sunilOS.ORSProject3.ctl.BaseCtl"%>
<%@page import="com.sunilOS.ORSProject3.ctl.UserCtl"%>
<%@page import="com.sunilOS.ORSProject3.ctl.UserListCtl"%>
<%@page import="com.sunilOS.ORSProject3.dto.UserDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sunilOS.ORSProject3.util.ServletUtility"%>
<%@page import="com.sunilOS.ORSProject3.util.DataUtility"%>
<%@page import="com.sunilOS.ORSProject3.util.HTMLUtility"%>
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
	<form action="<%=ORSView.USER_LIST_CTL%>" method="post">
		<%@include file="Header.jsp"%>
		<jsp:useBean id="dto" class="com.sunilOS.ORSProject3.dto.UserDTO"
			scope="request"></jsp:useBean>

		<div>
			<center>
				<br>
				<h2 style="text-shadow: #343a40;">
					<u><b>User List</b></u>
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
					List roleList = (List) request.getAttribute("roleList");
				%>
				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;
					int nextPageSize = DataUtility.getInt(request.getAttribute("nextUserListSize").toString());
					RoleDTO roleDTO = new RoleDTO();
					RoleModelInt roleModel = ModelFactory.getInstance().getRoleModel();

					List userList = ServletUtility.getList(request);
					Iterator<UserDTO> it = userList.iterator();
					if (userList.size() != 0) {
				%>

				<br>
				<table>
					<tr>
						<td><input type="text" name="firstName"
							placeholder="Enter First Name"
							value="<%=ServletUtility.getParameter("firstName", request)%>"
							class="form-control" style="width: 5.5cm;">
						<td>
						<td><input type="text" name="lastName"
							placeholder="Enter Last Name"
							value="<%=ServletUtility.getParameter("lastName", request)%>"
							class="form-control" style="width: 5.5cm;">
						<td>
						<td><%=HTMLUtility.getList("roleId", String.valueOf(dto.getRoleId()), roleList, "Select Role")%>
						<td>
						<td><input type="submit" name="operation"
							class="btn btn-primary" value="<%=UserListCtl.OP_SEARCH%>"
							class="srpnbtn">
						<td>
						<td><input type="submit" name="operation"
							class="btn btn-secondary" value="<%=UserListCtl.OP_RESET%>"
							class="srpnbtn">
						<td>
					</tr>
				</table>

				<br>
				<table class="table table-sm table-hover" border="4"
					style="width: 80%;">
					<thead>
						<tr style="background-color: #343a40; color: white;">
							<th><input type="checkbox" id="select_all" name="select">Select
						All</th>
							<th scope="col">S.No.</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email Id</th>
							<th scope="col">Role</th>
							<th scope="col">Date of Birth</th>
							<th scope="col">Gender</th>
							<th scope="col">Edit</th>
						</tr>
					</thead>

					<%
						while (it.hasNext()) {
								UserDTO userDTO = (UserDTO) it.next();
					%>
					<tbody>
						<tr style="background-color: white">
							<td><input type="checkbox" class="checkbox" name="ids"
								value="<%=userDTO.getId()%>"
									<%if (userDTO.getRoleId() == RoleDTO.ADMIN) {%>
						<%="disabled"%> <%}%>></td>
							<td><%=index++%></td>
							<td><%=userDTO.getFirstName()%></td>
							<td><%=userDTO.getLastName()%></td>
							<td><%=userDTO.getEmail()%></td>
							<td><%=roleModel.findByPK(userDTO.getRoleId()).getRoleName()%></td>
							<td><%=DataUtility.getDateToString(userDTO.getDob())%></td>
							<td><%=userDTO.getGender()%></td>
							<td><button type="button" name="operation"
									value="<%=UserListCtl.OP_EDIT%>"
									onclick="location.href='UserCtl?id=<%=userDTO.getId()%>'"
									<%=(userDTO.getRoleId() == RoleDTO.ADMIN) ? "disabled" : ""%>
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
				type="submit" name="operation" value="<%=UserListCtl.OP_DELETE%>"
				class="fa fa-trash-alt <!-- btn btn-danger --> "></button>
                    
			<input type="submit" name="operation" class="btn btn-dark"
				value="<%=UserListCtl.OP_PREVIOUS%>"
				<%=(pageNo > 1) ? "" : "disabled"%> class="srpnbtn"> 
		    
		    <input type="submit" name="operation" class="btn btn-light"
				value="<%=UserListCtl.OP_NEXT%>"
				<%=(nextPageSize != 0) ? "" : "disabled"%> class="srpnbtn">

			<input style="margin-right: 6%; margin-left: 26%;" type="submit"
				class="btn btn-info" name="operation"
				value="<%=UserListCtl.OP_NEW%>" class="srpnbtn">

			<%
				}
				if (userList.size() == 0) {
			%>
			<br> <br> <input type="submit" name="operation"
				class="btn btn-dark" value="<%=UserListCtl.OP_BACK%>"
				class="srpnbtn">

			<%
				}
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
		</div>
		<br> <br>
		<%@include file="Footer.jsp"%>
	</form>
</body>
</html>