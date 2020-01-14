# -*- coding:utf-8 -*-

# pip install psycopg2
import psycopg2

# cat /etc/services | grep 5432
# 5432端口，已经在IANA(The Internet Assigned Numbers Authority，互联网数字分配机构)注册，并把该端口唯一分配给PostgreSQL
if __name__ == '__main__':
    conn = psycopg2.connect(database="test-db", user="test-user", password="123456", host="127.0.0.1", port="5432")
    print("Opened database successfully")
    cur = conn.cursor()

    info = "SELECT id, mobile  from test_user where mobile = '18688888888'"
    print(info)
    cur.execute(info)
    rows = cur.fetchall()
    for row in rows:
        print(row[0])
        print(row[1])
    # print(rows)
    print("Operation done successfully")
    conn.close()
