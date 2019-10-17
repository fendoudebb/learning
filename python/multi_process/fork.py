# -*- coding:utf-8 -*-
import os
import platform

system = platform.system()

print(system)

if system != 'Windows':
    # 不适用Windows系统
    # fork后父子进程同时执行，fork()函数同时会有返回值
    # 父进程fork()函数返回的是子进程的进程id
    # 子进程fork()函数返回的一定是0
    pid = os.fork()
    print(pid)
    if pid > 0:
        print("---父进程---%d" % os.getpid())
    else:
        # os.getppid()获取父进程的id
        print("---子进程---%d-%d" % (os.getpid(), os.getppid()))
