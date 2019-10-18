# -*- coding:utf-8 -*-
import threading


def test1():
    mutex.acquire()
    print("test1---1")
    print("test1---2")
    print("test1---3")
    print(threading.current_thread().name)
    mutex.release()


def test2():
    mutex.acquire()
    print("test2---4")
    print("test2---5")
    print("test2---6")
    print(threading.current_thread().name)
    mutex.release()


# 互斥锁
mutex = threading.Lock()

thread1 = threading.Thread(target=test1)
thread1.start()
thread2 = threading.Thread(target=test2)
thread2.start()
