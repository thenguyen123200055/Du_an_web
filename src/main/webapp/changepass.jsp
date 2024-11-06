<%-- 
    Document   : changepass
    Created on : Nov 6, 2024, 7:43:25 PM
    Author     : MSI_PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="shared/header.jsp" />
<jsp:include page="shared/nav.jsp" />
<div class="container">
    <form action="ChangepassServlet" method="post" >
        <h2>Change Password</h2>
        <div>
            <label>Old Password</label>
            <input type="password" name="oldpassword" required="" class="form-control">
        </div>
        <div >
            <label>New Password</label>
            <input type="password" name="newpass" required="" class="form-control">
        </div>
        <div >
            <label>Confirm New Password</label>
            <input type="password" name="confirmpass" required="" class="form-control">
        </div>
        <div class="mt-2">
            <button class="btn btn-primary" type="submit" > Xác Nhận </button>
        </div>
        <%
            if (request.getAttribute("error") != null) {
        %>
        <div class="text-danger mb-3">
            <%=request.getAttribute("error")%>
        </div>
        <%
            }
        %>
    </form>
</div>
<jsp:include page="shared/footer.jsp" />
