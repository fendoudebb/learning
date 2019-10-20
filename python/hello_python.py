# -*- coding:utf-8 -*-
# 6个双引号是多行注释
"""
Python 国内镜像 http://npm.taobao.org/mirrors/python
"""

# 多个占位符
# %.2f保留浮点数后两位，默认保留小数点后6位

print("%s, %d, %.2f" % ("张三", 19, 178.5))

# input()接收键盘输入
input_data = input("请输入:")

# type()打印变量类型
input_data_type = type(input_data)

# print()打印
print(input_data_type)

# int()转换变量为int类型
transfer_2_int = int(input_data)

# str()转换变量为str类型
transfer_2_str = str(transfer_2_int)

# len()取字符串长度
transfer_2_str_len = len(transfer_2_str)

print(transfer_2_str_len)

# if elif else判断条件，and逻辑与，or逻辑或
if transfer_2_int > 0 and transfer_2_int > 10:
    # %d格式化int类型
    print("[%d] > 0 and > 10" % transfer_2_int)
elif transfer_2_str == '10' or transfer_2_str == '100':
    # %s格式化str类型
    print("[%s] == 10 or == 100" % transfer_2_str)
# not取反
elif not transfer_2_int > 10:
    print("[%d] not > 10" % transfer_2_int)
else:
    print("default else")

# while循环
while 0 < transfer_2_int < 10:
    transfer_2_int = transfer_2_int + 1
    print("current [%d]" % transfer_2_int)

b = bool(transfer_2_int)
print(b)

import keyword

kwlist = keyword.kwlist
print(kwlist)

a = 5
b = 2

print("a - b = %d" % (a - b))
print("a + b = %d" % (a + b))
print("a * b = %d" % (a * b))
print("a / b = %f" % (a / b))
# //取a除b的商
print("a 除 b 的商 = %d" % (a // b))
# %%字符串中打印%
print("a %% b = %d" % (a % b))
# **a的b次幂
print("a ^ b = %d" % (a ** b))

x = "abcdefghijk"
# 拼接10次
print(x * 10)

# 取字符串第一个
print(x[0])
print(x[2])
# 取字符串最后一个
print(x[len(x) - 1])
# 取字符串倒数第一个
print(x[-1])
# 取字符串倒数第二个
print(x[-2])

# 切片
# 取第二个到第三个，左开右闭，第四个不取
print(x[1:3])

# 取第二个到最后
print(x[1:])

# 取第二个到最后第二个，左开右闭
print(x[1:-1])

# 取第二个到最后第二个，步长为2，如：第一次取第1个，则第二次加步长2，取第3个
print(x[0:-1:3])

# 最后一个到最后
print(x[-1:])

# 取最后一个到第二个，左开右闭，并且逆序
print(x[-1:0:-1])

# 取最后一个到第一个，并且逆序
print(x[-1::-1])

# 字符串倒序输出
print(x[::-1])

my_str = "hello WORLD, hello python!"

# find()查找hello出现的索引位置，没有找到返回-1
print(my_str.find("hello"))
# rfind()倒序查找hello出现的索引位置，没有找到返回-1
print(my_str.rfind("hello"))

# index()查找hello出现的索引位置，没有找到报错
print(my_str.index("hello"))
# rindex()倒序查找hello出现的索引位置，没有找到报错
print(my_str.rindex("hello"))

# replace()替换字符串中所有的
print(my_str.replace("hello", "test"))
# 等价于替换所有
print(my_str.replace("hello", "test", my_str.count("hello")))

# replace(,,2)替换字符串中两处
print(my_str.replace("hello", "test", 1))

# count()统计o出现的次数
print(my_str.count("o"))
# capitalize()第一个单词首字母大写，有大写的单词都会被转为小写
print(my_str.capitalize())
# title()每个单词首字母都大写，有大写的单词都会被转为小写
print(my_str.title())
# split()按指定字符串切割成list
print(my_str.split(" "))
# join()将list按空格连接
print(" ".join(my_str.split(" ")))
# startswith()判断是否以hello开头
print(my_str.startswith("hello"))
# endswith()判断是否以hello结尾
print(my_str.endswith("hello"))
# lower()转化字符串为小写
print(my_str.lower())
# upper()转化字符串为大写
print(my_str.upper())

# 列表
names = ["张三", "李四", "王五"]
names2 = ["Python", "Java", "Rust"]
print(names)
print(names2)
# reverse()列表元素反转
names.reverse()
print("reverse={names}".format(names=names))
sort = [3, 2, 6, 3, 2, 1]
# sort()列表正序排序
sort.sort()
print(sort)
# sort(reverse=True)列表倒序排序
sort.sort(reverse=True)
print(sort)
# append()列表添加元素
names.append("赵六")
print(names)
# insert()指定位置插入元素
names.insert(0, "二狗子")
print(names)
# 两列表相加得到新列表
names3 = names + names2
print(names3)
# extend()将name2添加到names中
names.extend(names2)
print(names)
# pop()从尾部删除一个元素
names.pop()
print(names)
# remove()删除匹配的元素，只删一个
names.remove("Java")
print(names)
# del 删除列表第一个元素
del names[0]
print(names)
# 修改第一个元素的值
names[0] = "New Value"
print(names)
# in 判断元素是否在列表中
if "Python" in names:
    print("Hello Python!")
# not in 判断元素是否不在列表中
if "Java" not in names:
    print("No Java")

# for in 遍历; else 最后输出, 若for中执行到了break, 则不执行else
for name in names:
    print(name)
else:
    print("-" * 20)

for name in names:
    if name == '李四':
        break
else:
    print("+" * 20)

# 字典
person = {"name": "张三"}
print(person)
# dict
print(type(person))
# 给字典添加或覆盖键值
person['age'] = 18
print(person)
# keys()获取字典所有键
keys = person.keys()
print(keys)
print(type(keys))
# values()获取字典所有值
values = person.values()
print(values)

for m, n in person.items():
    print("m=%s, n=%s" % (m, n))

# 删除键，删除不存在的键会导致异常
del person['age']
print(person)
# 根据键获取，若不存在会报错
# print(person["aaa"])
# get()根据键获取值
print(person.get("name"))

# 元组
a = (1, 2, 3, 4, 5, 3)
print("type: %s" % type(a))
# index()元素在元组中的位置，不存在会报ValueError: tuple.index(x): x not in tuple
print(a.index(1, 0, len(a)))
# count()统计元素在元组中的个数
print(a.count(3))
a = (1, 2)
c, d = a
print("c=%d, d=%d" % (c, d))
x = a[0]
y = a[1]
print("x=%d, y=%d" % (x, y))


# 定义函数
def say_hello_world():
    print("hello world")


say_hello_world()


# 带参数函数、默认值参数、可变参数、有返回值函数
def sum_two_num(num1, num2, num3=-10, *args, **kwargs):
    # '{value}'.format(value="aaa")打印
    print('*args={value}'.format(value=args))
    print('**kwargs={kwargs}'.format(kwargs=kwargs))
    return num1 + num2 + num3


test_a = (100, 200)
test_b = {'subject': 'Python', "gradle": 'A'}
print("num1+num2=%d" % sum_two_num(10, 20))
print("num1+num2+num3=%d" % sum_two_num(10, 20, 1, 2, 3, 4, 5, *test_a, **test_b, finish=True, time="2019-10-09"))


# 返回多个值，返回的是元组类型
def return_two_value():
    return 10, 20, 30


print(return_two_value())
print(type(return_two_value()))

temp = 0


# global修改全局变量
def modify_temp():
    global temp
    temp = 100


def get_temp():
    print("temp=%d" % temp)


print(temp)
modify_temp()
get_temp()

temp2 = temp
print(id(temp))
print(id(temp2))

# 匿名函数lambda, 冒号前面是遍历后的单个元素，冒号后是对元素进行操作
infos = [{'name': "张三", 'age': 19}, {'name': "李四", 'age': 20}, {'name': "王五", 'age': 30}, {'age': 30}]
infos.sort(key=lambda info: info['age'], reverse=True)
print("infos sort = {infos}".format(infos=infos))

exchange_a = 100
exchange_b = 200
# 两个数交换
exchange_a, exchange_b = exchange_b, exchange_a
print("exchange a=%d, b=%d" % (exchange_a, exchange_b))

# open()以写模式打开文件，不存在会创建
file = open("1.txt", "w")
# write()将内容写入
file.write("aaa")
# close()关闭文件
file.close()

# open()以读模式打开文件
file = open("1.txt", "r")
# read()读取文件中的所有内容
print(file.read())
# readline()读取文件中的一行
print(file.readline())
# readlines()读取文件中的所有行并且存在列表中
print(file.readlines())

file.close()

import os

# 打印os模块文件所在位置
print(os.__file__)

# os.getcwd()打印当前目录绝对路径
print(os.getcwd())

# os.listdir()打印目录列表
file_names = os.listdir("./")
print(file_names)

# os.rename()重命名
os.rename("1.txt", "2.txt")

# os.remove()删除文件
os.remove("2.txt")

# os.mkdir()创建文件夹
os.mkdir("test")
# os.rmdir()删除文件夹
os.rmdir("test")

# 批量改名
for i in range(1, 10):
    file_name = str(i) + ".txt"
    t = open(file_name, "w")
    t.close()
    final_name = file_name.replace(".txt", "-fendoudebb.txt")
    os.rename(file_name, final_name)
    os.remove(final_name)


# 定义类
class Computer:

    # 初始化方法、构造方法
    def __init__(self):
        print("Computer init now!")

    # 定义类中方法
    def boot(self):
        print("Computer boot now!")

    def shutdown(self):
        print("Computer shutdown now!")


# 初始化类
cup1 = Computer()
# 调用类方法
cup1.boot()

# 给对象添加属性
cup1.os = "Windows XP"
cup1.cup = 1


class Base:
    def base(self):
        print("base")


# 继承、多继承（使用逗号隔开）
class SuperComputer(Computer, Base):
    # 类属性是各实例共享的
    num = 0

    # 有参数构造函数
    def __init__(self, os, cpu):
        super().__init__()
        # 实例属性是，实例私有，各实例间不共享
        self.os = os
        self.cpu = cpu
        # 类.类属性，来访问类属性
        SuperComputer.num += 1

    # del 删除所有引用时调用，类似析构方法
    def __del__(self):
        print("SuperComputer del now!")

    # 重写__str__方法，可以在print时看到重写后的信息
    def __str__(self):
        return "SuperComputer __str__: " + self.os + "-" + str(self.cpu)

    # __两个下划线表示私有方法，不可调用
    def __desc(self):
        print(self.os, self.cpu)

    # 类方法
    @classmethod
    def add_num(cls):
        cls.num = 100

    @staticmethod
    def static_method():
        print("this is static method!")


super_computer = SuperComputer("Windows 10", 8)
# super_computer.desc()
print(super_computer)
# 类.__mro__ 类的解析顺序
print(SuperComputer.__mro__)

super_computer.boot()

# 类方法可以用类直接调用，也可以用实例对象调用
SuperComputer.add_num()
super_computer.add_num()

# 类直接调用静态方法
SuperComputer.static_method()

import sys

# 打印执行时给程序传入的参数
print(sys.argv)

# sys.getrefcount()获取对象引用次数，需减1（getrefcount()方法本身也调用了）
print(sys.getrefcount(super_computer))

# del 后调用__del__，只有一处引用的情况下
del super_computer


class XPComputer:

    def say_hello(self):
        print("hello")

    # 初始化对象，init不等价于构造方法，构造方法是完成创建和初始化两件事情
    def __init__(self):
        print("xp computer init")

    # 创建对象
    def __new__(cls, *args, **kwargs):
        print(id(cls))
        return object.__new__(cls)


print(id(XPComputer))

# 1. 调用__new__
# 2. 调用__init__
# 3. 返回实例对象
xp_computer = XPComputer()


# 单例
class Win7Computer:
    __instance = None

    def __new__(cls, *args, **kwargs):
        if cls.__instance is None:
            cls.__instance = object.__new__(cls)
            return cls.__instance
        else:
            return cls.__instance


# try except 捕获异常，Python3多个异常捕获使用元组
try:
    1 / 0
    open("aaa.txt")
    print(num)
except NameError:
    print("except name error")
except (SyntaxError, FileNotFoundError):
    print("多个异常捕获")
except Exception as exception:
    print("没有捕获到的异常在这里: " + str(exception))
else:
    print("没有异常才会执行这里")
finally:
    print("最后一定执行")

# 列表推导式
# [1, 2, 3, 4, 5, 6, 7, 8, 9]
range_value = [r for r in range(1, 10)]
print(range_value)

# [0, 2, 4, 6, 8]
print([x for x in range(10) if x % 2 == 0])

# [0, 0, 1, 1, 2, 2]
print([x for x in range(3) for y in range(2)])

# [(0, 0), (0, 1), (1, 0), (1, 1), (2, 0), (2, 1)]
print([(x, y) for x in range(3) for y in range(2)])

# 集合类型，set
z = {11, 22, 33}
print(type(z))

# DeprecationWarning: Using or importing the ABCs from 'collections' instead of from 'collections.abc' is deprecated, and in 3.8 it will stop working
# from collections import Iterable
from collections.abc import Iterable

# 判断是否可迭代对象
print(isinstance("abc", Iterable))


# 闭包, 应用：数学函数y=ax+b
def test(a, b):
    def test_in(x):
        # 保存外部变量的值
        print("y=ax+b, y={}*{}+{}, y={}".format(a, x, b, a * x + b))

    return test_in


print(test(1, 5))
f = test(1, 5)
# 输出200
f(2)


# 装饰器
def warp_func1(func):
    # 传入*args, **kwargs，装饰有参函数、无参函数皆可
    def inner(*args, **kwargs):
        print("begin warp1")
        func(*args, **kwargs)
        print("end warp1")
    return inner


def warp_func2(func):
    def inner(*args, **kwargs):
        print("begin warp2")
        func(*args, **kwargs)
        print("end warp2")
    return inner


# Python解析器解释到了这句语句，就开始自动进行装饰，而不是等到调用的时候才装饰的。
# 相当于f = warp_func1(warp_func2(func1)), fun()
@warp_func1
@warp_func2
def func1():
    print("normal func")


# 调用func1()函数前，已经装饰好了。
func1()


class TestMethodType:
    # __slots__限制只能添加的属性或方法
    __slots__ = ("num", "test_method_type1", "test_method_type2")

    def __init__(self):
        print("test method type init")


def test_method_type1():
    print("test_method_type1")


def test_method_type2(self):
    print("test_method_type2")


tmt = TestMethodType()
# 动态添加类属性
tmt.num = 100
print(tmt.num)
# 动态添加类方法
tmt.test_method_type1 = test_method_type1
tmt.test_method_type1()

import types

# types.MethodType()动态添加类方法
tmt.test_method_type2 = types.MethodType(test_method_type2, tmt)
tmt.test_method_type2()

try:
    tmt.name = "aaa"
except Exception as exception:
    print(exception)

# dir()打印对象拥有的方法，list
print(dir(tmt))


# yield生成器，斐波那契数列
def fib(count):
    a, b = 0, 1
    for i in range(count):
        # yield 生成的生成器可用next()迭代
        yield b
        a, b = b, a + b


for num in fib(5):
    print(num)


class WarpClass:
    def __init__(self, func):
        print("init, func name is %s" % func.__name__)
        self.__func = func

    def __call__(self, *args, **kwargs):
        print("类装饰器")
        self.__func()


@WarpClass
def test_class_warp():
    print("test class warp")


test_class_warp()


class GetAttr:
    def __init__(self):
        self.private_attr = "private_attr"

    # 属性访问时拦截器，此方法内使用self.会有坑
    def __getattribute__(self, item):
        if item == 'private_attr':
            return "public_attr"
        else:
            return item.__getattribute__


ga = GetAttr()
print(ga.private_attr)

for m in map(lambda x: x * x, [1, 2, 3]):
    print(m)

print("-" * 20)

for m in map(lambda x, y: x + y, [1, 2, 3], [4, 5, 6]):
    print(m)

print("-" * 20)

# [1, 3], 1%2=1, lambda返回为True的值
for f in filter(lambda x: x % 2, [1, 2, 3, 4]):
    print(f)

print("-" * 20)

for f in filter(None, "abcdefg"):
    print(f)

print("-" * 20)

from functools import reduce

# 10
print(reduce(lambda x, y: x + y, [1, 2, 3, 4]))
# 15
print(reduce(lambda x, y: x + y, [1, 2, 3, 4], 5))
# ddaabbcc
print(reduce(lambda x, y: x + y, ['aa', 'bb', 'cc'], 'dd'))

print(sorted([1, 5, 3, 2]))

print(sorted([1, 5, 3, 2], reverse=True))

# set集合，不存放重复值
set_a = {1, 2, 3, 3, 4, 6}
print(set_a)

set_b = {1, 2, 3, 100, 200, 300}
# & 取交集
print(set_a & set_b)
# | 取并集
print(set_a | set_b)
# - 取差集, a对b的差集, {4, 6}
print(set_a - set_b)
# - 取差集, b对a的差集, {200, 100, 300}
print(set_b - set_a)
# ^ 取对称差集, 在a或b中, 但不会同时出现在二者中
print(set_b ^ set_a)

import hashlib

md5 = hashlib.md5()
md5.update(b'123')
print(md5.hexdigest())
str = "123".encode("UTF-8")
print(str, md5.hexdigest())

# python -m http.server 8888

# 使用python执行此文件时，__name__的值就等于__main__
if __name__ == '__main__':
    print(__name__)
