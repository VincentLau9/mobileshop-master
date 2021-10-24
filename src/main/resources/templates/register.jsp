<%-- 
    Document   : register
    Created on : Oct 6, 2021, 9:42:28 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Cascading Style Sheets/register.css">
    </head>
    <body>
        <div class="container">
            <div class="title">
                <h1>REGISTRATION FORM</h1>
            </div>  
            <div class="form-regis">
                <c:set value="${requestScope.ERROR}" var="error"/>
                <form action="Controller?url=CreateUser" method="POST">
                    <div class="input-box">
                        <lable class="details">Full Name</lable>
                        <input class="input" type="text" name="fullName" placeholder="Enter your name" required=""/>
                    </div>
                    <p class="error">${error.fullNameErr}</p>
                    <div class="input-box">
                        <lable class="details">User Name</lable>
                        <input class="input" type="text" name="userID" placeholder="Enter User name" required/>
                    </div>
                    <p class="error">${error.userIDErr}</p>
                    <div class="input-box">
                        <lable class="details">Email</lable>
                        <input class="input" type="text" name="email" placeholder="Enter your email" required=/>
                    </div>
                    <p class="error">${error.email}</p>
                    <div class="input-box">
                        <lable class="details">Phone Number</lable>
                        <input class="input" type="text" name="phone" placeholder="Enter Phone Number" required/>
                    </div>
                    <p class="error">${error.phoneErr}</p>
                    <div class="input-box">
                        <lable class="details">Password</lable>
                        <input class="input" type="password" name="password" placeholder="Enter Password" required/>
                    </div>
                    <div class="input-box">
                        <lable class="details">Confirm Password</lable>
                        <input class="input" type="password" name="confirm" placeholder="Enter Password Again" required />
                    </div>
                    <p class="error">${error.password}</p>
                    <div class="input-box">
                        <button class="btn" type="submit" value="CreateUser" name="action">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
