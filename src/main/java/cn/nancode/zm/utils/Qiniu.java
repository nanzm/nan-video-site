package cn.nancode.zm.utils;

import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author nan
 * @time 2018/6/21
 */
public class Qiniu {

    private final String accessKey = "MIL4HzWtznF-NTISen0enoP7l2MKIbCSB2ID9ugn";
    private final String secretKey = "LEPHxmBs05GVwcjPk527OgSNsI_7Rd_4LayKTn0E";
    private final String bucketDefault = "cdn-block1";

    private Logger logger = LoggerFactory.getLogger((getClass()));


    public String getUpToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucketDefault);
        return upToken;
    }
}
