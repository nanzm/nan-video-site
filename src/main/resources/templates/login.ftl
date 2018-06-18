<#include "layout.ftl">
<@head></@head>

<@js></@js>
<@body>
    <#include "includes/head.ftl">
    <#include "includes/msg.ftl">


    <#if SPRING_SECURITY_LAST_EXCEPTION?exists>
        <div class="alert alert-danger" role="alert">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
    </#if>


    <form class="form-signin" action="/auth/form" method="post">

        <div class="form-group">
            <h1 class="h3 mb-3 font-weight-normal">登录</h1>
        </div>

        <div class="form-group">
            <input type="text" name="username" id="inputEmail" class="form-control" placeholder="请输入邮箱"
                   autofocus="">
        </div>

        <div class="form-group">
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码">
        </div>

        <div class="form-row">
            <div class="form-group col-md-8">
                <input type="text" name="imageCode" class="form-control" placeholder="验证码" >
            </div>
            <div class="form-group col-md-4"><img src="/code/image" alt=""></div>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

    <#include "includes/foot.ftl">
</@body>