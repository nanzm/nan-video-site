<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Nanzm</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">主页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/videos">视频</a>
            </li>
        </ul>

    <#--<form class="form-inline my-2 my-lg-0">-->
    <#--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
    <#--<button class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>-->
    <#--</form>-->


    <#if SPRING_SECURITY_USER?exists>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="/info">${SPRING_SECURITY_USER.name}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">退出</a>
            </li>
        </ul>
    <#else>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="/login">登录</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/register">注册</a>
            </li>
        </ul>
    </#if>
    </div>
</nav>