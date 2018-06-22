package cn.nancode.zm.dao;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author sufun
 */
@Entity
@Data
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "名称不能为空")
    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Catalog() {
    }

    public Catalog(User user, String name) {
        this.name = name;
        this.user = user;
    }
}
