<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<script src="js/home.js"></script>
<!-- in home page we have four tabs one to adding the staff and view and calculate tax then logout by clicking the button this request will go to 

home.js in home.js we have js function it will create a virtual form element and set the task to it then sent it to home servlet

 -->
<button class="homebutton" type="button" onclick="call_task('addstaff')">Add Staff</button>
<button class="homebutton homebutton1" type="button" onclick="call_task('viewstaff')">View Staff</button>
<button class="homebutton homebutton2" type="button" onclick="call_task('calctax')">Calculate tax</button>
<button class="homebutton homebutton3" type="button" onclick="call_task('logout')">logout</button>
</body>
</html>