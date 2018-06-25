package cn.nancode.zm.dao.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface VideoMapper {

    @Insert("insert into video(name,url) values (#{name,jdbcType=VARCHAR},#{url,jdbcType=VARCHAR})")
    int insertByMapper(Map<String, Object> map);
}
