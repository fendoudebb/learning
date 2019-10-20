# -*- coding:utf-8 -*-
import socket

tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# udp_socket.sendto(str.encode("哈哈", encoding='UTF-8'), ("127.0.0.1", 8080))
# 网络调试助手是以gb2312编码
udp_socket.sendto(str.encode("哈哈", encoding='gb2312'), ("127.0.0.1", 8080))
