<#--head-->
<#macro head>
    <#assign layout_head>
        <#nested />
    </#assign>
</#macro>

<#--js-->
<#macro js>
    <#assign layout_js>
        <#nested />
    </#assign>
</#macro>


<#--body-->
<#macro body>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="nan"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    ${layout_head!}
</head>
<body>
    <#nested />
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
    ${layout_js!}
</body>
</html>
</#macro>
