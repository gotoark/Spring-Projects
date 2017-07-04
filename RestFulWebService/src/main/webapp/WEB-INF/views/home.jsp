<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<center>
<body>
<h1>
	SPRING REST WEBSERVICE  
	
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h2>
	TEST URLS
</h2>
<P>  <a href="http://localhost:8080/restfulwebservice/addEmployee/?emp_AGE=21&emp_PASSWORD=mypassword123&emp_NAME=Rajesh">Add</a>                    - http://localhost:8080/restfulwebservice/addEmployee/?emp_AGE=21&emp_PASSWORD=mypassword123&emp_NAME=Rajesh </P>
<P>  <a  href="http://localhost:8080/restfulwebservice/addEmployee/?emp_AGE=21&emp_PASSWORD=mypassword123&emp_NAME=Rajesh">Update</a>                - http://localhost:8080/restfulwebservice/addEmployee/?emp_AGE=21&emp_PASSWORD=mypassword123&emp_NAME=Rajesh </P>
<P>  <a  href="http://localhost:8080/restfulwebservice/deleteEmployee/?emp_ID=5">DELETE</a>                - http://localhost:8080/restfulwebservice/deleteEmployee/?emp_ID=5 </P>
<P>  <a  href="http://localhost:8080/restfulwebservice/getAllEmployee">GET ALL EMPLOYEE JSON</a> - http://localhost:8080/restfulwebservice/getAllEmployee</P>
<P>  <a  href="http://localhost:8080/restfulwebservice/getAllEmployeeList">GET ALL EMPLOYEE </a>     - http://localhost:8080/restfulwebservice/getAllEmployeeList</P>
<P>  <a  href="http://localhost:8080/restfulwebservice/getEmployee?emp_ID=2">GET EMPLOYEE JSON</a>     - http://localhost:8080/restfulwebservice/getEmployee?emp_ID=2</P>
<P>  <a  href="http://localhost:8080/restfulwebservice/getEmployeeObject?emp_ID=2">GET EMPLOYEE Object</a>   - http://localhost:8080/restfulwebservice/getEmployeeObject?emp_ID=2</P>
</center>
</body>
</html>