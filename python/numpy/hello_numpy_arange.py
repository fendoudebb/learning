# -*- coding:utf-8 -*-

# pip install numpy
# Numberical Python
import numpy


# 数组相加
# arange(n) 创建0-(n-1)的数组
def sum_n(n):
    a = numpy.arange(n) ** 2
    b = numpy.arange(n) ** 4
    return a + b


if __name__ == '__main__':
    print(numpy.arange(5))  # [0 1 2 3 4]
    print(numpy.arange(5) ** 2)  # [ 0  1  4  9 16]
    print(numpy.arange(5) ** 4)  # [  0   1  16  81 256]
    print(sum_n(5))  # [  0   2  20  90 272]
    arange = numpy.arange(5)  # type: numpy.ndarray
    print(type(arange))  # <class 'numpy.ndarray'>
    # arange.dtype数组元素类型
    print(arange.dtype)  # int32
    # arange.shape数组个数, 元组类型, 一维数组第一个元素是数组长度
    print(arange.shape)  # (5,)
