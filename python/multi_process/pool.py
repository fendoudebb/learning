# -*- coding:utf-8 -*-
import os

from multiprocessing.pool import Pool


def task(param):
    print("multi process---%s, pid---%d, ppid---%d" % (param, os.getpid(), os.getppid()))


if __name__ == '__main__':

    # 3个进程
    p = Pool(3)
    for i in range(3):
        # 非阻塞添加任务至进程池
        p.apply_async(task, args=(i,))
        # 阻塞添加任务至进程池
        # p.apply(task, args=(i,))
    print('main start, PID: %s' % os.getpid())
    # 关闭进程池，不再添加新任务
    p.close()
    # 阻塞, 等待子进程结束后再执行
    p.join()
    print('main end, PID: %s' % os.getpid())
