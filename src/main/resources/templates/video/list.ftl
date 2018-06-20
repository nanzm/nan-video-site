<#include "../layout.ftl">

<@head>
<title>列表</title>
</@head>

<@js>
<script>

</script>
</@js>



<@body>
    <#include "../includes/head.ftl">

    <div class="container" style="padding: 100px">
        <h1>视频列表 <a href="/video/save" style="font-size: 14px;font-weight: bold">（去添加）</a></h1>
        <ul class="list-group">
        <#list list as item>
            <li class="list-group-item"><a href="/video/play/${item.id}">${item.name}</a></li>
        </#list>
        </ul>
    </div>

    <#include "../includes/foot.ftl">
</@body>