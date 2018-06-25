package cn.nancode.zm.utils;

import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author nan
 * @time 2018/6/21
 */
public class Qiniu {

    private static String accessKey = "MIL4HzWtznF-NTISen0enoP7l2MKIbCSB2ID9ugn";
    private static String secretKey = "LEPHxmBs05GVwcjPk527OgSNsI_7Rd_4LayKTn0E";
    private static String bucketDefault = "cdn-block1";

    private Logger logger = LoggerFactory.getLogger((getClass()));


    public static Auth getAuth() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth;
    }

    public static String getUpToken() {
        Auth auth = getAuth();
        String upToken = auth.uploadToken(bucketDefault);
        return upToken;
    }


}
