<#include "layout.ftl">
<@head>
    <title>个人信息</title>
</@head>

<@js></@js>
<@body>
    <#include "includes/head.ftl">
    <#include "includes/msg.ftl">

    <div class="container">
        <p>用户名：${userInfo.name}</p>
        <p>邮箱（账号）：${userInfo.email}</p>
    </div>

    <#include "includes/foot.ftl">
</@body>