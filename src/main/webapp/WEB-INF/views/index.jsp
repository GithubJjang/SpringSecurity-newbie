<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>

        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal"/>
            현재 사용자: 
            <sec:authentication property="principal.username"/>
        </sec:authorize>

        Hello index
        <p>
            <a href="/user/login">login</a> <br>
            <a href="/user/join">sign up</a>
        </p>
    </body>

</html>