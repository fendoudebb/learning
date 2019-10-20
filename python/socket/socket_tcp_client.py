# -*- coding:utf-8 -*-
from socket import socket, AF_INET, SOCK_STREAM

client_socket = socket(AF_INET, SOCK_STREAM)

client_socket.connect(('127.0.0.1', 9090))

client_socket.send("你好".encode("gb2312"))

recv_data = client_socket.recv(1024)

print("receive from server: %s" % recv_data.decode("gb2312"))
client_socket.close()
