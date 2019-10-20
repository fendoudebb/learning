# -*- coding:utf-8 -*-
from socket import *

if __name__ == '__main__':
    udp = socket(AF_INET, SOCK_DGRAM)

    udp.bind(("", 9090))

    while True:
        recv_data = udp.recvfrom(1024)
        content, dest_info = recv_data
        print("content=%s" % content.decode('gb2312'))
