# -*- coding:utf-8 -*-

# https://docs.mongodb.com/ecosystem/drivers/pymongo
import pymongo
from bson import ObjectId
from pymongo import MongoClient
from pymongo.collection import Collection

client = MongoClient('mongodb://localhost:27017')

# client.数据库名
db = client.test_db
col = db.test_col  # type: Collection
doc = {'name': 'test-name', 'password': 'test-pwd'}
object_id = col.insert_one(doc).inserted_id  # type: ObjectId
print(object_id)
print(type(object_id))
print(object_id.generation_time.isoformat())

doc2 = col.find_one({'name': 'test-name'})
# {'_id': ObjectId('5db6d241deb2c8342de41523'), 'name': 'test-name', 'password': 'test-pwd'}
print(doc2)

update_one_result = col.update_one({'name': 'test-name'}, {'$set': {'password': 'test-pwd2'}})
print(update_one_result.matched_count)
print(update_one_result.modified_count)

delete_one_result = col.delete_one({'name': 'test-name'})
print(delete_one_result.raw_result)
print(delete_one_result.deleted_count)
print(delete_one_result.acknowledged)

# sort([(), ()]) 多自段排序
cursor = col.find({'name': 'test-name'}).sort([('_id', pymongo.DESCENDING)]).skip(1).limit(2)
for c in cursor:
    print(c)
