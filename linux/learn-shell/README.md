
## 位置变量
运算符|解释
:-:|:-:
$1|获取第一个参数
$2|获取第二个参数
$n|获取第n个参数（n为数字）
${1}|获取第一个参数

## 预定义变量
运算符|解释
:-:|:-:
$0|获取脚本名称
$*|获取所有参数
$@|获取所有参数
$#|获取参数个数
$$|获取当前进程的pid
$!|获取上一个后台进程的pid
$?|获取上一个命令的执行结果，0表示成功

## 逻辑运算符
运算符|解释
:-:|:-:
-a|逻辑与，and
-o|逻辑或，or
!|非

## 文件比较运算符
运算符|解释|举例
:-:|:-:|:-:
-e|是否存在，exist|[ -e /var/log/messages ]
-f|是否是文件，file|[ -f /var/log/messages ]
-d|是否是文件夹，dir|[ -d /var/log ]
-r|是否可读，read|[ -r /var/log/messages ]
-w|是否可写，write|[ -w /var/log/messages ]
-x|是否可执行，execute|[ -x /var/log/messages ]
-nt|是否新于，new than|[ /usr/local/nginx/nginx.conf -nt /etc/nginx/nginx.conf ]
-ot|是否旧于，old than|[ /usr/local/nginx/nginx.conf -ot /etc/nginx/nginx.conf ]

## 算术比较运算符
运算符|解释|举例
:-:|:-:|:-:
-eq|相等，equal|[ "$var" -eq 0 ]
-ne|不相等，not equal|[ "$var" -ne 0 ]
-gt|大于，great than|[ "$var" -gt 0 ]
-ge|大于等于，great equal|[ "$var" -ge 0 ]
-lt|小于，less than|[ "$var" -lt 0 ]
-le|小于等于，less equal|[ "$var" -le 0 ]

## 字符串比较运算符
运算符|解释|举例
:-:|:-:|:-:
-z|判断字符串长度是否为0，zero|[ -z "$var" ]
-n|判断字符串长度是否不为0，nonzero|[ -n "$var" ]
=|判断两字符串是否相等|[ "$var" = "abc" ]
!=|判断两字符串是否不等|[ "$var" != "abc" ]

## 获取长度

- #var

定义`var=www.sina.com.cn`

命令|解释|输出
:-:|:-:|:-:
${#var}|获取变量长度|15

## 变量内容删除
键盘上`#`在`$`左边，`%`在`$`右边，所以`#`从左往右删除，`%`从右往左删除。

定义`var=www.sina.com.cn`

### `#`从左往右删除

- #ww
- #*c
- ##*.

命令|解释|输出
:-:|:-:|:-:
${var#ww}|删除`ww`开头的<br>若删除`sina`则还是`www.sina.com.cn`|w.sina.com.cn
${var#*c}|删除到第一个`c`为止，包括c<br>最短匹配|om.cn
${var##*.}|删除到最后一个`.`为止，包括.<br>最长匹配，贪婪匹配|cn


### `%`从右往左删除

- %.*
- %%.*

命令|解释|输出
:-:|:-:|:-:
${var%.*}|删除右边起第一个`.`及其右边（注意：`*`在后）|www.sina.com
${var%%.*}|删除到右边起最后一个`.`及其右边|www

### 按索引和切牌你删除

- :0:5
- :5

命令|解释|输出
:-:|:-:|:-:
${var:0:5}|从第0个字符开始截取，取5位|www.s
${var:5}|去除前5位|ina.com.cn

## 变量内容替换

- /w/x
- //./#

定义`var=www.sina.com.cn`

命令|解释|输出
:-:|:-:|:-:
${var/w/x}|替换一个`w`为`x`|xww.sin.com.cn
${var//./#}|替换所有`.`为`#`|www#sina#com#cn

## 变量赋值

- var-aaa
- var:-aaa

不定义var1

定义`var2=222`

定义`var3=`

命令|解释|输出
:-:|:-:|:-:
${var1-aaa}|设置`var1`默认值为`aaa`<br>`var1`没有初始化，所以赋值为`aaa`|aaa
${var2-bbb}|设置`var2`默认值为`bbb`<br>`var2`有初始化值`222`，所以不再赋值|222
${var3-ccc}|设置`var3`默认值为`ccc`<br>`var3`有初始化值为空，所以不再赋值|空值
${var3:-ccc}|设置`var3`默认值为`ccc`<br>`var3`有初始化值为空，所以赋值为`ccc`|ccc


## case语法
```bash
case 变量 in
可能值1)
    命令1
    ;;
可能值2)
   命令2
   ;; 
可能值n)
   命令n
   ;; 
*)
    无匹配
esac
```

## if语法
```bash
if 条件
then 命令
elif 条件
then 命令
else 命令
fi
```

可格式化为
```bash
if 条件 ; then
    命令
elif 条件; then
    命令
else
    命令
fi
```

## for语法
```bash
for i in `seq 10`
do
    echo $i
done
```

## while语法
```bash
#!/bin/bash
i=0
while [ $i < 10 ]
do
    echo $i
    let i++
done
```

从test.txt文件中读取
```bash
#!/bin/bash
while read aaa
do
    echo $aaa
done < test.txt
```

## until语法
与while想反，条件不成立则进入
```bash
#!/bin/bash
i=0
until [ $i > 10 ]
do
    echo $i
    let i++
done
```

## 语法
### 清空1.txt文件
```bash
>1.txt
```

### 取一组数
```bash
#!/bin/bash
for i in {1..10}
do
    echo $i
done
```
或着
```bash
seq 1 10
```

### 等待键盘输入
```bash
read -p "请输入："
```

### 放入后台执行
```bash
#!/bin/bash
{
    echo
}&
wait
```