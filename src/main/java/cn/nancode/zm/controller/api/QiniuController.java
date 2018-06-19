package cn.nancode.zm.controller.api;

import cn.nancode.zm.utils.Result;
import cn.nancode.zm.utils.ResultUtil;
import cn.nancode.zm.vo.UploadToken;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/upload")
public class QiniuController {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    private String accessKey = "MIL4HzWtznF-NTISen0enoP7l2MKIbCSB2ID9ugn";
    private String secretKey = "LEPHxmBs05GVwcjPk527OgSNsI_7Rd_4LayKTn0E";
    private String bucket = "cloud";

    @GetMapping("/token")
    public Result uploadToken() {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        return ResultUtil.success(new UploadToken(upToken));
    }

}
