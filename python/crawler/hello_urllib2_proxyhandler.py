# -*- coding:utf-8 -*-
from http.client import HTTPResponse
from urllib import request

# 构建代理HTTP处理对象
proxy_handler = request.ProxyHandler({'http': '127.0.0.1:8080'})

opener = request.build_opener(proxy_handler)

# 构建全局opener，之后所有请求都可以用urlopen()，否则必须使用opener.open()，不然不走代理
request.install_opener(opener)

headers = {
    'User-Agent':
        'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36',

}

r = request.Request('http://www.baidu.com', headers=headers)

# response = opener.open(r)

response = request.urlopen(r)  # type: HTTPResponse
print(response.read().decode('gbk'))
