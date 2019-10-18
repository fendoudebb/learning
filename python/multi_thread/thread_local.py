# -*- coding:utf-8 -*-
import threading

local_value = threading.local()


def test_put_thread(value):
    local_value.value = value
    test_read_thread()


def test_read_thread():
    print(local_value.value + " in thread: %s" % threading.current_thread().name)


t1 = threading.Thread(target=test_put_thread, args=("张三",), name='Thread-A')
t2 = threading.Thread(target=test_put_thread, args=("李四",), name='Thread-B')
t1.start()
t2.start()
t1.join()
t2.join()
