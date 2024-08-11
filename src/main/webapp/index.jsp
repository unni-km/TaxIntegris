<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Design by foolishdeveloper.com -->
    <title>Login</title>
 <%--this is the login page here user can login if a new user then can go to registration form by using registration button --%>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <form method="POST" action="login">
        <h3>Login</h3>

        <label for="username">Username</label>
        <input type="text" name="user" placeholder="Email or Phone" id="username">

        <label for="password">Password</label>
        <input type="password" name="pass" placeholder="Password" id="password">

        <button>Log In</button>
        <div >
  <input formaction="login"   formmethod="get" type="submit" value="register"> <%--after submitting the form this will go to submit --%>
        </div>
    </form>
    
    
<!--         <input formaction="submit"   formmethod="get" type="submit" value="register"> -->
  
</body>
</html>
