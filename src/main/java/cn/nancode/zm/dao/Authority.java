package cn.nancode.zm.dao;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


/**
 * Created by nan
 * 2018/6/18
 */
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
