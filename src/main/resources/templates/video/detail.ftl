<#include "../layout.ftl">

<@head>
<title>播放</title>
<link rel="stylesheet" href="/lib/DPlayer.min.css">
<script src="/lib/DPlayer.min.js"></script>
<script src="/lib/flv.min.js"></script>
<style>
    .play-box {
    }
</style>
</@head>

<@js>
<script>
    var url = "${video.url}";

    $(function () {
        var dp = new DPlayer({
            container: document.getElementById('dplayer'),
            theme: '#2780E3',
            autoplay: true,
            video: {
                url: url,
                // url: 'http://cloud.nancode.cn/cookie-session.flv',
            },
            contextmenu: [{
                text: 'Video info',
                click: function (player) {
                    player.infoPanel.triggle();
                }
            }]
        });

        console.log(dp)
    })
</script>
</@js>

<@body>
    <#include "../includes/head.ftl">

    <div class="container" style="padding: 100px;">

        <h1>${video.name}</h1>
        <div class="play-box">
            <div id="dplayer"></div>
        </div>
    </div>

    <#include "../includes/foot.ftl">
</@body>
