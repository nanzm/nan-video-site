package cn.nancode.zm.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel
@Data
public class Girl {
    
    @Id
    @GeneratedValue
    @ApiModelProperty("用户ID")
    private Integer id;

    @NotNull(message = "名字不能为空")
    @ApiModelProperty("用户名字")
    private String name;

    @Min(value = 18, message = "未成年禁止入内")
    @ApiModelProperty("用户年龄")
    private Integer age;

    public Girl() {
    }

    public Girl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
