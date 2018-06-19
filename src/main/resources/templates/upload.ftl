<#include "layout.ftl">
<@head>
<title>test</title>
<script src="/lib/qiniu.min.js"></script>
<style></style>
</@head>

<@js>
<script>
    $(function () {
        var token;

        $.get("/api/upload/token", function (res) {
            console.log(res);
            if (res.code == 0) {
                token = res.data.token;
            }
        });

        function upload(file, key) {
            var putExtra = {fname: "", params: {}, mimeType: null};
            var observable = qiniu.upload(file, key, token, putExtra, {});

            var subscription = observable.subscribe({
                next(e) {
                    console.log(e.total.percent);
                },
                error(err) {
                    console.error(err);
                },
                complete(res) {
                    console.log(res);
                }
            });
            // subscription.unsubscribe() // 上传取消
        }


        $("#video").on('change', function (e) {
            var file = this.files[0];
            upload(file, "mimimi");
        });

    })
</script>
</@js>

<@body>
    <#include "includes/head.ftl">

    <div class="container">
        <input type="file" name="video" id="video">
    </div>

    <#include "includes/foot.ftl">
</@body>
