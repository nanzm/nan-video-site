package cn.nancode.zm.repository;


import cn.nancode.zm.dao.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}