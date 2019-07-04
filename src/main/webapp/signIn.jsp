<link rel="stylesheet" href="style.css">
<form action="${pageContext.request.contextPath}/signIn" method="post" style="width : 320px;">
    <h2 class="login" class="fa fa-sign-in"> Login</h2>
    <input type="text" name="user_name" class="user" placeholder="ursername"/>

    </span>
    <input type="password" name="password" class="pass" placeholder="password"/>
    <button class="submit"><a href="${pageContext.request.contextPath}/blog"></a></button>
</form>