<#include "layout.ftl">
<@head></@head>

<@js></@js>
<@body>
    <#include "includes/head.ftl">
    <#include "includes/msg.ftl">



    <form class="form-signin" action="/register" method="post">
        <h1 class="h3 mb-3 font-weight-normal">注册</h1>

        <label for="inputName" class="sr-only">昵称</label>
        <input type="text" name="name" id="inputName" class="form-control" placeholder="昵称" autofocus="">

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="邮箱">

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">


        <button class="btn btn-lg btn-primary btn-block" type="submit">确认</button>
    </form>

    <#include "includes/foot.ftl">
</@body>