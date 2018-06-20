package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.Authority;
import cn.nancode.zm.repository.AuthorityRepository;
import cn.nancode.zm.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }

}