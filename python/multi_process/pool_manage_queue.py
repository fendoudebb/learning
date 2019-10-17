# -*- coding:utf-8 -*-
from multiprocessing import Manager, Pool


def write(q):
    q.put("456")


def read(q):
    print(q.get())


if __name__ == '__main__':
    # Manager().Queue()适用于Pool()创建的进程间通信
    q = Manager().Queue()
    p = Pool(3)
    p.apply_async(write, (q,))
    p.apply_async(read, (q,))
    p.close()
    p.join()
