<link rel="stylesheet" href="style.css" >

<form action="${pageContext.request.contextPath}/signUp" method="post" style="width : 320px;" >
    <h2><span class="entypo-login"><i class="fa fa-sign-in"></i></span> SignUp</h2>

    <span class="entypo-user inputUserIcon">
     <i class="fa fa-user"></i>
   </span>
    <input type="text" name="user_name" class="name" placeholder="username"/>
    <input type="email" name="email" class="email" placeholder="email"/>
    <span class="entypo-key inputPassIcon">
     <i class="fa fa-key"></i>
   </span>
    <input type="password" name ="password" class="pass"placeholder="password"/>
    <input type="password" name = "confPassword" class="pass"placeholder="confirm password"/>
    <button class="submit" type="submit"></button>
</form>>