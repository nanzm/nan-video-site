package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.Video;
import cn.nancode.zm.repository.VideoRepository;
import cn.nancode.zm.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
    public List<Video> listVideos(Pageable pageable) {
        return (List<Video>) videoRepository.findAll(pageable);
    }
}
