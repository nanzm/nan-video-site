package cn.nancode.zm.controller.api;

import cn.nancode.zm.utils.Qiniu;
import cn.nancode.zm.utils.Result;
import cn.nancode.zm.utils.ResultUtil;
import cn.nancode.zm.vo.UploadToken;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author nan
 * @time 2018/6/21
 */
@RestController
@RequestMapping(value = "/api/upload")
public class QiniuController {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    @GetMapping("/token")
    public Result uploadToken() {
        String upToken = new Qiniu().getUpToken();

        return ResultUtil.success(new UploadToken(upToken));
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("key") String key,
                         @RequestParam("file") MultipartFile file) {
        //token
        String upToken = new Qiniu().getUpToken();

        //自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);


        try {
            //调用put方法上传
            Response res = uploadManager.put(file.getBytes(), key, upToken);
            System.out.println(res.bodyString());


        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultUtil.success();
    }

}
