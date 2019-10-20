# -*- coding:utf-8 -*-
from socket import socket, AF_INET, SOCK_STREAM

server_socket = socket(AF_INET, SOCK_STREAM)

server_socket.bind(("", 9090))

server_socket.listen(5)
# accept()阻塞函数, 等待客户端连接
# client_info表示客户端的ip、port
client_socket, client_info = server_socket.accept()
# recv()阻塞函数, 等待客户端发送数据
recv_data = client_socket.recv(1024)

print("%s: %s" % (client_info, recv_data.decode("gb2312")))

client_socket.close()
server_socket.close()
