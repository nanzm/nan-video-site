package cn.nancode.zm.service;

import cn.nancode.zm.dao.Video;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoService {

    Video saveVideo(Video catalog);

    void removeVideo(Long id);

    Video getVideoById(Long id);

    List<Video> listVideos();
}
