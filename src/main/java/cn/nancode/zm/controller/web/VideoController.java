package cn.nancode.zm.controller.web;

import cn.nancode.zm.dao.Video;
import cn.nancode.zm.service.VideoService;
import cn.nancode.zm.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Created by nan
 * 2018/6/20
 */

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoServiceImpl videoService;

    @GetMapping
    public String list(Pageable pageable, Model model) {
        List<Video> list = videoService.listVideos();
        model.addAttribute("list", list);
        return "video/list";
    }

    @GetMapping("/play/{id}")
    public String play(@PathVariable("id") long id, Model model) {
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        return "video/detail";
    }

    @GetMapping("/save")
    public String save() {
        return "video/save";
    }

    @PostMapping("/save/form")
    public String saveForm(Video video) {
        videoService.saveVideo(video);
        return "redirect:/video";
    }
}
