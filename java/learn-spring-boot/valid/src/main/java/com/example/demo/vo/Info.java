package com.example.demo.vo;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class Info {

    @Range(min = 0, max = 100, message = "数值1不在正确范围")
    private int integer1;

    @Range(min = 0, max = 100, message = "数值2不在正确范围")
    private int integer2;

    @NotNull(message = "爱好不能为空")
    @Size(min = 1, max =3, message = "爱好个数不正确")
    private List<String> hobbies;

    @NotNull(message = "技能不能为空")
    @Size(min = 1, max =3, message = "技能个数不正确") // 过滤相同，必须是1~3个不同的才符合规则
    private Set<String> skills;

    @AssertTrue(message = "integer1必须小于integer2")
    public boolean isValid() {
        return this.integer1 < this.integer2;
    }

}
