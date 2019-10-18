# -*- coding:utf-8 -*-
import threading
import time
from queue import Queue


class Producer(threading.Thread):
    def run(self) -> None:
        global q
        while True:
            if q.qsize() < 5:
                q.put("123")
            else:
                break


class Consumer(threading.Thread):
    def run(self) -> None:
        global q
        while True:
            time.sleep(1)
            if not q.empty():
                print(q.get())
            else:
                break


if __name__ == '__main__':
    q = Queue()
    producer = Producer()
    producer.start()
    consumer = Consumer()
    consumer.start()
