<#include "layout.ftl">
<@head></@head>

<@js></@js>
<@body>
    <#include "includes/head.ftl">
    <#include "includes/msg.ftl">

    <form class="form-signin" action="/auth/form" method="post">
        <h1 class="h3 mb-3 font-weight-normal">登录</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Email address" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

    <#include "includes/foot.ftl">
</@body>