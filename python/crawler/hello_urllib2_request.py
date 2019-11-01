# -*- coding:utf-8 -*-

# python2.7 import urllib2
import random
import ssl
from urllib import request
from http.client import HTTPResponse
from urllib import parse

response1 = request.urlopen('http://www.baidu.com')  # type: HTTPResponse
html = response1.read()
print(html)

headers = {
    'User-Agent':
        'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36',

}

# 不安全的CA证书会报：urllib.error.URLError: <urlopen error [SSL: CERTIFICATE_VERIFY_FAILED] certificate verify failed:
# self signed certificate in certificate chain (_ssl.c:1076)>

# 忽略SSL安全认证
context = ssl._create_unverified_context()

# GET请求，不带data参数；POST参数携带data参数
req = request.Request('https://inv-veri.chinatax.gov.cn', headers=headers)
response2 = request.urlopen(req, context=context)  # type: HTTPResponse
print(response2.read())

# 响应码
print(response2.getcode())
# 返回数据的实际URL，防止重定向问题
print(response2.geturl())
# 返回服务器响应的HTTP报头
print(response2.info())

ua_list = [
    'ua1',
    'ua2',
    'ua3'
]

ua = random.choice(ua_list)
req = request.Request('http://www.baidu.com')

req.add_header('User-Agent', ua)
# 获取HTTP包头的值。注意：必须是第一个字母大小，其余字母小写
print(req.get_header('User-agent'))

# urlencode()，urlencode编码，接收的是字典类型
urlencode = parse.urlencode({'wd': '你好'}, encoding='utf-8')
print(urlencode)
# unquote()，urlencode解码
print(parse.unquote(urlencode))
