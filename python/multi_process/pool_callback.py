# -*- coding:utf-8 -*-
import os
import time
from multiprocessing.pool import Pool


def test_func():
    print("test_func, pid=%d" % os.getpid())
    time.sleep(5)


# 必须要加args参数，否则报错
def test_callback(args):
    print("test_callback, pid=%d, args=%s" % (os.getpid(), args))


if __name__ == '__main__':
    pool = Pool(3)
    # callback在主进程中回调
    pool.apply_async(func=test_func, callback=test_callback)
    pool.close()
    pool.join()
    print("main thread, pid=%d" % os.getpid())
