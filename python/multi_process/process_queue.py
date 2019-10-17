# -*- coding:utf-8 -*-
from multiprocessing import Queue, Process


def write(q):
    if not q.full():
        q.put("123")


def read(q):
    if not q.empty():
        print(q.get())


if __name__ == '__main__':

    # 只能用于Process()创建的进程间通信, 不能用于Pool()创建的进程池间通信
    queue = Queue(3)
    pw = Process(target=write, args=(queue,))
    pr = Process(target=read, args=(queue,))
    pw.start()
    pw.join()
    print(queue.qsize())
    pr.start()
    pr.join()

    try:
        # if Queue is full, 直接抛异常
        queue.put_nowait("hello queue")
        # if Queue is empty, 直接抛异常
        print(queue.get_nowait())
    except Exception as e:
        print(e)
