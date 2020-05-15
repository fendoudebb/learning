package com.example.demo.vo;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Builder
public class UserVo {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 8, message = "长度不正确")
    private String name;

    @Min(value = 0, message = "年龄最小0")
    @Max(value = 120, message = "年龄最大120")
    private int age;

    @Email(message = "邮件格式不正确")
    @NotBlank(message = "邮件不能为空")
    private String email;

    @Negative(message = "只能负数")
    private int negative;

    @Positive(message = "只能正数")
    private int positive;

    @NegativeOrZero(message = "只能负数或0")
    private int negativeOrZero;

    @PositiveOrZero(message = "只能正数或0")
    private int positiveOrZero;

    // 级联对象必须不能为空和加@Vaid才能验证
    @Valid
    @NotNull(message = "信息不能为空")
    private Info info;

}
