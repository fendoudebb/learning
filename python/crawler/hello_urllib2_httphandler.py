# -*- coding:utf-8 -*-
from http.client import HTTPResponse
from urllib import request

# 构建一个HTTPHandler处理器对象，支持处理HTTP请求
# http_handler = request.HTTPHandler()
# debuglevel=1打开Debug log模式，作调试用
http_handler = request.HTTPHandler(debuglevel=1)
# 调用builder_opener()方法构建一个自定义的opener对象，参数是创建的处理器对象
opener = request.build_opener(http_handler)

r = request.Request('http://www.baidu.com')

response = opener.open(r)  # type: HTTPResponse

print(response.read())
