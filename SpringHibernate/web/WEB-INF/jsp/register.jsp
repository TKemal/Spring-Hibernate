
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration page</h1>
        <div>
            <form:form name="registerForm" method="POST" action="register" 
                       commandName="newUser">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><form:input path="username" /></td>
                        <td style="color: red; font-style: italic;"><form:errors path="username" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:password path="password" /></td>
                        <td style="color: red; font-style: italic;"><form:errors path="password" /></td>
                    </tr> 
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Register" style="width: 100%;" />
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>


