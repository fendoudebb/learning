# -*- coding:utf-8 -*-

# python2 是cookielib
from http import cookiejar
from urllib import request, parse

# 保存cookie
cookie = cookiejar.CookieJar()
# HTTPCookieProcessor处理cookie
cookie_handler = request.HTTPCookieProcessor(cookie)
opener = request.build_opener(cookie_handler)

opener.addheaders = [
    ('User-Agent',
     'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36')
]

url = "http://www.renren.com/PLogin.do"

data = {}

parse.urlencode(data)
req = request.Request(url, data=data)
# 发送第一次的post请求，生成登录后的cookie(如果登录成功的话)
response = opener.open(req)

# 第二次可以是get请求，这个请求将保存生成cookie一并发到web服务器，服务器会验证cookie通过
response_deng = opener.open("http://www.renren.com/xxxx/profile")

# 获取登录后才能访问的页面信息
print(response_deng.read())
