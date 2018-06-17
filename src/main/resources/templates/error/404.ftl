<#include "../layout.ftl">
<@head>
<title>400</title>
</@head>


<@body>
    <#include "../includes/head.ftl">

    <div class="container text-center">
        <h1>404</h1>
        <h2>${error}</h2>
        <p><b>信息：</b>${message}</p>
    </div>

    <#include "../includes/foot.ftl">
</@body>