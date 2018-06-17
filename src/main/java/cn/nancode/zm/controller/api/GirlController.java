package cn.nancode.zm.controller.api;

import cn.nancode.zm.aspect.HttpLogAspect;
import cn.nancode.zm.dataobject.Girl;
import cn.nancode.zm.VO.Result;
import cn.nancode.zm.enums.ResultEnum;
import cn.nancode.zm.VO.ResultException;
import cn.nancode.zm.repository.GirlRepository;
import cn.nancode.zm.service.GirlService;
import cn.nancode.zm.VO.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/api/girls")
@Api(tags = "用户列表")
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(HttpLogAspect.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/{id}")
    @ApiOperation("通过ID查询")
    public Result getGirl(@PathVariable("id") Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        if (girl != null) {
            return ResultUtil.success(girl);
        }
        throw new ResultException(ResultEnum.NODATA);
    }

    @GetMapping(value = "/")
    @ApiOperation("列表查询")
    public Result girlList() {
        return ResultUtil.success(girlRepository.findAll());
    }

    @PostMapping(value = "/")
    @ApiOperation("添加")
    public Result girlAdd(@Validated Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(-1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setName(girl.getName());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("更新")
    public Result updateGirl(Girl girl) {
        girl.setId(girl.getId());
        girl.setName(girl.getName());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除")
    public Result delGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
        return ResultUtil.success();
    }

    @GetMapping(value = "/age/{age}")
    @ApiOperation("年龄查询")
    public Result findListByAge(@PathVariable("age") Integer age) {
        List<Girl> girl = girlRepository.findByAge(age);
        if (girl.size() > 0) {
            return ResultUtil.success(girl);
        }
        throw new ResultException(ResultEnum.NODATA);
    }


    //异常处理 测试
    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
