<div class="container">
    <#if msg?exists>
    <div class="alert alert-success" role="alert">${msg}</div>
    </#if>

    <#if error?exists>
        <div class="alert alert-danger" role="alert">${error}</div>
    </#if>

    <#if info?exists>
        <div class="alert alert-warning" role="alert">${info}</div>
    </#if>
</div>