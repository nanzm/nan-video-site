package cn.nancode.zm.dao;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "标题")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @NotEmpty(message = "视频链接不能空")
    @Size(max = 50)
    @Column(nullable = false, length = 50, unique = true)
    private String url;

    public Video() {
    }

    public Video(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
