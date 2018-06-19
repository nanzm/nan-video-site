package cn.nancode.zm.vo;

import lombok.Data;

@Data
public class UploadToken {

    private String Token = "";

    public UploadToken(String token) {
        Token = token;
    }
}
