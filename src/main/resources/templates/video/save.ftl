<#include "../layout.ftl">

<@head>
<title>保存</title>
<script src="/lib/qiniu.min.js"></script>
<style></style>
</@head>

<@js>
<script src="https://cdn.bootcss.com/moment.js/2.22.1/moment.min.js"></script>
<script>

    $(function () {
        var token;

        $.get("/api/upload/token", function (res) {
            console.log(res);
            if (res.code == 0) {
                token = res.data.token;
            }
        });

        function uploadItem(files) {
            var file = files[0];
            var name = files[0].name;
            var key = Date.now() + "." + getFileExtension(name);

            var putExtra = {fname: "", params: {}, mimeType: null};
            // ['video/x-ms-wmv', 'video/x-flv', 'video/mp4']
            var observable = qiniu.upload(file, key, token, putExtra, {});


            $("#info").removeClass("d-none");

            var subscription = observable.subscribe({
                next(e) {
                    $("#info").html("上传中：" + e.total.percent);
                },
                error(err) {
                    console.error(err);
                },
                complete(res) {
                    console.log(res);

                    if (res.key) {
                        $("#info").html("上传成功");

                        $("#videoVal").val("http://cloud.nancode.cn/" + res.key)
                    } else {
                        alert("上传失败")
                    }
                }
            });
            // subscription.unsubscribe() // 上传取消
        }


        $("#video").on('change', function (e) {
            uploadItem(this.files)
            // console.log(this.files);
        });


    })
</script>
</@js>



<@body>
    <#include "../includes/head.ftl">
    <div id="info" class="d-none alert alert-success" role="alert"></div>

    <div class="container" style="padding: 100px 100px;">
        <h1>添加视频</h1>

        <form action="/video/save/form" method="post">
            <div class="form-group">
                <input type="text" name="name" class="form-control" id="videoName" placeholder="">
            </div>

            <div class="form-group">
                <input type="file" id="video" placeholder="上传">
                <input type="text" name="url" id="videoVal" hidden placeholder="url">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </form>
    </div>


    <#include "../includes/foot.ftl">
</@body>