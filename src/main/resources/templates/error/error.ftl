<#include "../layout.ftl">
<@head>
<title>exception</title>
</@head>

<@body>
    <#include "../includes/head.ftl">

    <div class="container text-center">
        <h1>自定义错误处理</h1>
        <h2>${url}</h2>
        <p><b>信息：</b>${exception}</p>
    </div>

    <#include "../includes/foot.ftl">
</@body>
