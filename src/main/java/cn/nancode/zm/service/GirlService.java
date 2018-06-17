package cn.nancode.zm.service;

import cn.nancode.zm.dataobject.Girl;
import cn.nancode.zm.enums.ResultEnum;
import cn.nancode.zm.VO.ResultException;
import cn.nancode.zm.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);

        Integer age = girl.getAge();

        if (age < 10) {
            throw new ResultException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new ResultException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            throw new ResultException(ResultEnum.HEIGH_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
