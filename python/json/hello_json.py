# -*- coding:utf-8 -*-
import json

# json.loads json字符串转为Python对象
str_list = '[1,2,3,4,5]'
print(type(json.loads(str_list)))
print(json.loads(str_list))

str_dict = '{"name":"张三","age":20,"male":true}'
print(type(json.loads(str_dict)))
print(json.loads(str_dict))

# json.dumps Python对象转为json字符串
# ensure_ascii=False 禁用ascii码
list_str = [1, 2, 3, 4, 5]
print(type(json.dumps(list_str)))
print(json.dumps(list_str))

dict_str = {"name": "张三", "age": 20, "male": True}
print(type(json.dumps(dict_str)))
# {"name": "\u5f20\u4e09", "age": 20, "male": true}
print(json.dumps(dict_str))
# {"name": "张三", "age": 20, "male": true}
print(json.dumps(dict_str, ensure_ascii=False))

# json.load/json.dump是读写json文件
