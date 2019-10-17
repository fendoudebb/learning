# -*- coding:utf-8 -*-
import os
import time
from multiprocessing import Process


def test(param):
    for i in range(5):
        print("multi process---%d---%s, pid---%d, ppid---%d" % (i, param, os.getpid(), os.getppid()))
        time.sleep(1)


# Windows平台必须要添加if __name__ == '__main__':
# 否则会报:
'''
RuntimeError: 
        An attempt has been made to start a new process before the
        current process has finished its bootstrapping phase.

        This probably means that you are not using fork to start your
        child processes and you have forgotten to use the proper idiom
        in the main module:

            if __name__ == '__main__':
                freeze_support()
                ...

        The "freeze_support()" line can be omitted if the program
        is not going to be frozen to produce an executable.
'''
if __name__ == '__main__':
    # 跨平台
    process = Process(target=test, args=('test-param',))
    process.start()
    # 阻塞, 等待子进程结束后再执行
    process.join()
    print("main process---%d" % os.getpid())
