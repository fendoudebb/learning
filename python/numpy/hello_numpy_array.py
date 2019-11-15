# -*- coding:utf-8 -*-
import numpy

if __name__ == '__main__':
    # 二维数组
    # [[0 1 2]
    #  [0 1 2]
    #  [0 1 2]]
    arr1 = numpy.array([numpy.arange(3), numpy.arange(3), numpy.arange(3)])
    print(arr1)
    # 2行3列
    print(arr1.shape)
    # 行：2
    print(arr1.shape[0])
    # 列：3
    print(arr1.shape[1])
    print("{}是{}维数组".format("arr1", len(arr1.shape)))

    print(arr1[0, 0])
    print(arr1[2, 1])

    # 分片
    # [[0 1 2]]
    print(arr1[0:1])
    # [0 1 2]
    print(arr1[0:1][0])
    print(arr1[0:2])

    print(arr1[0::2])

    arr2 = numpy.array([5, 10, 15])  # type: numpy.ndarray
    print(arr2)
    # <class 'numpy.ndarray'>
    print(type(arr2))
    print(arr2.dtype)

    t = numpy.dtype([('name', numpy.str_, 20), ('age', numpy.int8), ('salary', numpy.float32)])

    b = numpy.array([('a', 1, 2), (3, 4, 5), (6, 7, 8)], dtype=t)
    # [('a', 1, 2.) ('3', 4, 5.) ('6', 7, 8.)]
    print(b)
