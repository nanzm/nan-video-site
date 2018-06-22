package cn.nancode.zm.dao;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @author sufun
 */
@Entity
@Data
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createTime;

    public Vote() {
    }

    public Vote(User user) {
        this.user = user;
    }
}