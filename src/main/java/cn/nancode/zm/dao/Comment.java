package cn.nancode.zm.dao;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author sufun
 */
@Entity
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "评论内容不能为空")
    @Size(min = 2, max = 500)
    @Column(nullable = false)
    private String content;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createTime;

    public Comment() {
    }

    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
    }
}