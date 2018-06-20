package cn.nancode.zm.dao;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

// 实体
@Entity
@Data
public class Vote implements Serializable {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @CreationTimestamp  // 由数据库自动创建时间
    private Timestamp createTime;

    public Vote() {
    }

    public Vote(User user) {
        this.user = user;
    }
}