<#include "layout.ftl">
<@head>
<title>test</title>
<link rel="stylesheet" href="/lib/DPlayer.min.css">
<script src="/lib/DPlayer.min.js"></script>
<script src="/lib/flv.min.js"></script>
<style>
    .play-box {
        width: 800px;
    }
</style>
</@head>

<@js>
<script>
    $(function () {
        var dp = new DPlayer({
            container: document.getElementById('dplayer'),
            theme: '#2780E3',
            video: {
                url: 'http://cloud.nancode.cn/oceans.mp4',
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
    <#include "includes/head.ftl">

    <div class="container">
        <div class="play-box">
            <div id="dplayer"></div>
        </div>
    </div>

    <#include "includes/foot.ftl">
</@body>
