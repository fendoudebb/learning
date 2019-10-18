# -*- coding:utf-8 -*-
import time
from threading import Thread


def test():
    print("thread test---")
    time.sleep(1)


thread = Thread(target=test)
print("main start")
thread.start()
print("main end")
