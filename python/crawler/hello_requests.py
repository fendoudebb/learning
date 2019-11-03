# -*- coding:utf-8 -*-

# https://github.com/psf/requests
# pip install requests
import requests

# GET请求
get_response = requests.get('http://www.baidu.com')
print(get_response)
print("status_code: " + str(get_response.status_code))
print("ok: " + str(get_response.ok))
print("encoding: " + get_response.encoding)
print("headers: " + str(get_response.headers))
print("raw: " + str(get_response.raw))
print("text: " + get_response.text)
print("content: " + str(get_response.content))

# POST请求
data = {}
headers = {"User-Agent": 'MONI'}
post_response = requests.post('http://www.baidu.com', data=data, headers=headers)
print(post_response)


# Cookies
cookies_response = requests.get("http://www.baidu.com/")

# 7. 返回CookieJar对象:
cookiejar = cookies_response.cookies

# 8. 将CookieJar转为字典：
cookiedict = requests.utils.dict_from_cookiejar(cookiejar)
print(cookiejar)
print(cookiedict)

# 1. 创建session对象，可以保存Cookie值
session = requests.session()
session.get('http://www.baidu.com')
session.get('http://www.baidu.com')


# 根据协议类型，选择不同的代理
proxies = {
    "http": "http://12.34.56.79:9527",
    "https": "http://12.34.56.79:9527",
}

proxies_response = requests.get("http://www.baidu.com", proxies=proxies)
print(proxies_response.text)
