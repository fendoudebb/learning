# -*- coding:utf-8 -*-
import re

# s == space 空格
# w == word 单词
# d == digital 数字
# b == boundary 边界


# None
print(re.match('hello', 'ooo'))
match1 = re.match('hello', 'hello')

print(match1.group())
match2 = re.match('hello', "helloxxx")
# hello
print(match2.group())
# .匹配任一字符, 除了\n
print(re.match(".", "a").group())
print(re.match(".", "\n"))
# ..匹配任两字符
print(re.match("..", "ab").group())
# \d匹配数字，0-9
print(re.match(r'\d', "1").group())
# \D匹配非数字，除了0-9
print(re.match(r'\D', "%").group())
# \s匹配空白字符，空格( )、tab键(\t)、回车换行(\n、\r)
print(re.match(r'\s', "\r\n").group())
# \S匹配非空白字符
print(re.match(r'\S', "abc").group())
# \w匹配单词字符, a-z, A-Z, 0-9, _(下划线)
print(re.match(r'\w', "abc").group())
# \W匹配非单词字符, -
print(re.match(r'\W', "（@*&！-").group())
# \d == [0-9]
# \D == [^0-9]
# \w == [a-zA-Z0-9_]
# \W == [^a-zA-Z0-9_]
# []匹配方括号中出现的字符
print(re.match('1[358]', "186").group())
# [^]匹配方括号中没有出现的字符, 取反, 多个^效果一样
print(re.match('1[^358]', "199").group())
print(re.match("1[^3^5^8]", "199").group())
# [a-z5-9]匹配a-z中任一字母或5-9中任一数字
print(re.match('1[a-z5-9]', "1b").group())

# 表示数量
# * 表示出现0次或多次, 可有可无
print(re.match(r'\d*', '123456').group())
# + 表示出现1次或多次, 至少一次
print(re.match(r'\d+', '123456').group())
print(re.match(r'\d+\w?', '1234abcd').group())
# ? 表示出现1次或0次, 要么1次, 要么0次
print(re.match(r'\d?', '123456').group())
print(re.match(r'\d?[a-z]', 'a3456').group())
# {3} 表示出现3次
print(re.match(r'\d{3}[a-z]', '123a').group())
# {3,} 表示至少出现3次
print(re.match(r'\d{3,}[a-z]', '123456a').group())
# {3,6} 表示至少出现3次
print(re.match(r'\d{3,6}[a-z]', '123456a').group())

# 使用r''来免转义
print(re.match('\\\\n', '\\nabcd').group())
print(re.match(r'\\n', '\\nabcd').group())

# 表示边界
# ^ 匹配字符串开头
print(re.match(r'^1[358]\d{9}', '180123456789').group())
# $ 匹配字符串结尾
print(re.match(r'1[358]\d{9}', '180123456789').group())
# 以9个数字结尾
print(re.match(r'1[358]\d{9}$', '18012345678').group())

# ^, $ 可以理解为vim中^(shift+6)跳至行首、$(shift+4)跳至行尾

# \b 匹配一个单词边界(字符串结尾, 或单词结尾都可以)
print(re.match(r'^\w+ab$', 'tab').group())
print(re.match(r'^\w+ab', 'table').group())
print(re.match(r'^\w+ab\b', 'tab').group())
print(re.match(r'^\w+ab\b', 'tab table').group())
# \bab\b ab前后都是边界
print(re.match(r'^\bab\b', 'ab table').group())
# \B 匹配非单词边界
print(re.match(r'^ab\B', 'able').group())

# | 匹配左右两个任一表达式
# 匹配0-100
print(re.match(r'[1-9]\d?$|0$|100$', '100').group())
# 融合0这种情况
print(re.match(r'[1-9]?\d?$|100$', '0').group())

# () 将括号中的字符串作为一个分组
# <h1>标题</h1>
print(re.match(r'(<h1>).*(</h1>)', '<h1>标题</h1>').group(0))
# group(1) 第一个分组 <h1>
print(re.match(r'(<h1>).*(</h1>)', '<h1>标题</h1>').group(1))
# group(2) 第二个分组 </h1>
print(re.match(r'(<h1>).*(</h1>)', '<h1>标题</h1>').group(2))

# \num 取分组的值
print(re.match(r'<(.+)><(.+)>.+</\2></\1>', '<html><h1>标题</h1></html>').group())

# (?P<name>) 分组起别名
# (?P=name) 引用别名分组
print(re.match(r'<(?P<key1>.+)><(?P<key2>.+)>.+</(?P=key2)></(?P=key1)>', '<html><h1>标题</h1></html>').group())

# search 匹配到第一个就返回
print(re.search(r'\bhello$', 'python hello').group())
# findall 匹配所有
print(re.findall(r'hello', 'python hello, java hello'))
# sub 替换所有匹配的
print(re.sub(r'hello', 'HELLO', 'python hello, java hello'))
print(re.sub(r'hello', 'HELLO', 'python hello, java hello'))

# split 根据匹配切割字符串
# ['Python', 'Java', 'C++', 'PHP', 'Golang']
print(re.split(r':|-|,| ', 'Python Java:C++,PHP-Golang'))

# 贪婪模式
print(re.match(r'(.+)(\d+-\d+-\d+-\d+)', 'This is number 123-456-789-0').groups())
# 加?关闭贪婪模式
print(re.match(r'(.+?)(\d+-\d+-\d+-\d+)', 'This is number 123-456-789-0').groups())
