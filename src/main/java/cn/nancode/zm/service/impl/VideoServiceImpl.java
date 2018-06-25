package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.Video;
import cn.nancode.zm.repository.VideoRepository;
import cn.nancode.zm.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sufun
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void removeVideo(Long id) {
        videoRepository.delete(id);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoRepository.findOne(id);
    }

    @Override
    public List<Video> listVideos() {
        return videoRepository.findAll();
    }
}
