<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Adorbs Adoption</title>
</head>
<body>
    <center>
        <h1>Welcome to Adorbs Adoption!</h1>
        <h2>
            <a href="AccountCreation.jsp">Sign Up</a>
            &nbsp;&nbsp;&nbsp;
            <a href="PeopleList.jsp">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${people != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${people == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="3" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${people != null}">
                        Edit People
                    </c:if>
                    <c:if test="${people == null}">
                        Login
                    </c:if>
                </h2>
            </caption>
                <c:if test="${people != null}">
                    <input type="hidden" name="id" value="<c:out value='${people.id}' />" />
                </c:if>           
            <tr>
                <th>Username: </th>
                <td>
                    <input type="text" name="username" size="45"
                            value="<c:out value='${people.username}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${people.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Login" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>