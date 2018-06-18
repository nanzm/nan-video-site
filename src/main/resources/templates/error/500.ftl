<#include "../layout.ftl">
<@head>
<title>500</title>
</@head>

<@body>
    <#include "../includes/head.ftl">

     <div class="container text-center">
         <h1>500</h1>
         <h2>${error}</h2>
         <p><b>类：</b><i>${exception}</i></p>
         <p><b>信息：</b>${message}</p>
     </div>

    <#include "../includes/foot.ftl">
</@body>
