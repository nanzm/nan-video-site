<#include "layout.ftl">
<@head>
    <title>个人信息</title>
</@head>

<@js></@js>
<@body>
    <#include "includes/head.ftl">
    <#include "includes/msg.ftl">

    <div class="container">
        <form>
            <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">用户名：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail"
                           value="${userInfo.name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword" class="col-sm-2 col-form-label">邮箱账号：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail"
                           value="${userInfo.email}">
                </div>
            </div>

            <div class="form-group row">
                <label for="inputPassword" class="col-sm-2 col-form-label">角色：</label>
                <div class="col-sm-10">
                    <span ><#list userInfo.authorities as role>${role.authority}</#list></span>
                </div>
            </div>
        </form>
    </div>

    <#include "includes/foot.ftl">
</@body>