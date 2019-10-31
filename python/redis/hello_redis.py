# -*- coding:utf-8 -*-
import datetime
import time

import redis

r = redis.Redis()

print(r.keys())
r.set('test-key', 'test-value')
print(r.get('test-key'))
r.delete('test-key')

redis_lock_key = 'redis_single_instance_lock'
random_val = time.time()
print(type(random_val))

# set nx ex， 适用于单实例Redis。主从/分布式不适合，牺牲一定可靠性可选择。
# master拿到锁，但是加锁的key还没有同步到slave节点，master就故障了，发生故障转移，slave节点升级为master节点，导致锁丢失。
r.set(redis_lock_key, random_val, ex=10, nx=True)
# 必须判断随机值再删除，因为如果前一个锁已经超时释放了，其他线程不判断随机值直接根据是否为空删除会造成问题
r.eval(f"""if redis.call("get",KEYS[1]) == ARGV[1] then return redis.call("del",KEYS[1]) else return 0 end""", 1,
       redis_lock_key, random_val)

pipeline = r.pipeline()
pipeline.set('test-pipeline-key', 'test-pipeline-value')
pipeline.delete('test-pipeline-key')
pipeline.execute()
