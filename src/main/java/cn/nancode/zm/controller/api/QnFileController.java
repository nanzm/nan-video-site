package cn.nancode.zm.controller.api;

import cn.nancode.zm.utils.Qiniu;
import cn.nancode.zm.utils.Result;
import cn.nancode.zm.utils.ResultUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.processing.OperationStatus;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import com.qiniu.util.UrlSafeBase64;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nan
 * @time 2018/6/24
 */
@RestController
@RequestMapping(value = "/api/")
public class QnFileController {

    /**
     * 默认 bucket
     */
    private String bucket = "cdn-block1";

    /**
     * 华东
     */
    private Configuration cfg = new Configuration(Zone.zone0());

    /**
     * 获取文件列表
     */
    @GetMapping("/qn/listFiles")
    public Result list(@RequestParam(value = "marker", required = false) String marker,
                       @RequestParam(value = "prefix", required = false) String prefix,
                       @RequestParam(value = "delimiter", required = false) String delimiter,
                       @RequestParam(value = "limit", required = false, defaultValue = "20") int limit) throws QiniuException {
        Auth auth = Qiniu.getAuth();
        BucketManager bucketManager = new BucketManager(auth, cfg);
        FileListing fileListing = bucketManager.listFiles(bucket, prefix, marker, limit, delimiter);
        return ResultUtil.success(fileListing);
    }

    /**
     * 删除文件
     */
    @GetMapping("/qn/delete")
    public Result delete(@RequestParam(value = "key") String key) {
        BucketManager bucketManager = new BucketManager(Qiniu.getAuth(), cfg);
        try {
            Response res = bucketManager.delete(bucket, key);
            return ResultUtil.success(res);
        } catch (QiniuException ex) {
            return ResultUtil.error(ex.code(), ex.response.toString());
        }
    }

    /**
     * 抓取网络资源到空间
     */
    @GetMapping("/qn/fetch")
    public Result fetch(@RequestParam(value = "url") String url,
                        @RequestParam(value = "key") String key) {
        BucketManager bucketManager = new BucketManager(Qiniu.getAuth(), cfg);
        try {
            FetchRet fetchRet = bucketManager.fetch(url, bucket, key);
            return ResultUtil.success(fetchRet);
        } catch (QiniuException ex) {
            return ResultUtil.error(ex.code(), ex.response.toString());
        }
    }

    /**
     * 持久化数据处理
     */
    @GetMapping("/qn/trans")
    public Result trans(@RequestParam(value = "key") String key) {

        //数据处理指令，支持多个指令
        String saveMp4Entry = String.format("%s:avthumb_test_target.mp4", bucket);
        String avthumbMp4Fop = String.format("avthumb/mp4|saveas/%s", UrlSafeBase64.encodeToString(saveMp4Entry));

        //将多个数据处理指令拼接起来
        String persistentOpfs = StringUtils.join(new String[]{avthumbMp4Fop}, ";");
        //数据处理队列名称，必须
        String persistentPipeline = "tomp4";
        //数据处理完成结果通知地址
        String persistentNotifyUrl = "http://www.nancode.cn/api/qn/notify";

        //...其他参数参考类注释
        //构建持久化数据处理对象
        OperationManager operationManager = new OperationManager(Qiniu.getAuth(), cfg);
        try {
            String persistentId = operationManager.pfop(bucket, key, persistentOpfs, persistentPipeline, persistentNotifyUrl, true);
            //可以根据该 persistentId 查询任务处理进度
            System.out.println(persistentId);
//            OperationStatus operationStatus = operationManager.prefop(persistentId);
            //解析 operationStatus 的结果


        } catch (QiniuException e) {
            System.err.println(e.response.toString());
        }
        return null;
    }


    @PostMapping("/qn/notify")
    public Result qnback(HttpServletRequest request) {
        System.out.println(".--.--.--.-成功-.--.---");
        return null;
    }
}
