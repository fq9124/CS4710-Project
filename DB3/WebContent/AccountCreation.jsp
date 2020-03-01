<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <center>
        <h1>Free Sign Up!</h1>
        <h2>
            <a href="PeopleForm.jsp">Login</a>
      
        </h2>
    </center>
    <div align="center">
        <c:if test="${people != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${people == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="2">
                <c:if test="${people != null}">
                    <input type="hidden" name="username" value="<c:out value='${people.username}' />" />
                </c:if>           
            <tr>
                            <th>Username: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${people.username}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="46"
                            value="<c:out value='${people.password}' />"
                            
                    />
                 
                    
                </td>
            </tr>
                        <tr>
                <th>Confirm Password: </th>
                <td>
                    <input type="password" name="password" size="46"
                            value="<c:out value='${people.password}' />"
                    />
                </td>
            </tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="first" size="45"
                            value="<c:out value='${people.first}' />"
                        />
                </td>
            </tr>
                <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last" size="45"
                            value="<c:out value='${people.last}' />"
                        />
                </td>
                
            </tr>
                <tr>
                                <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${people.email}' />"
                        />
                </td>
                
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Sign Up!" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>