# -*- coding:utf-8 -*-

# https://github.com/PyMySQL/PyMySQL

import pymysql

connection = pymysql.connect('192.168.3.101', 'root', '123456', 'test')

try:
    with connection.cursor() as cursor:
        # Create a new record
        sql = "INSERT INTO `users` (`name`, `password`) VALUES (%s, %s)"
        cursor.execute(sql, ('test-name', 'test-secret'))

    # 默认是不自动提交的，需手动提交修改。
    connection.commit()

    with connection.cursor() as cursor:
        sql = "SELECT VERSION()"
        cursor.execute(sql)
        result = cursor.fetchone()
        print(result)
finally:
    connection.close()
