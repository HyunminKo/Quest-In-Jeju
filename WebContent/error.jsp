<%--
  User: hyunminko
  Date: 2019-08-06
  Time: 02:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Exception error = (Exception) session.getAttribute("error");
    StackTraceElement[] elements = error.getStackTrace();
    for(StackTraceElement elem : elements){
        out.println(elem);
        out.println("<br/>");
    }
    session.removeAttribute("error");
%>
