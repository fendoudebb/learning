## 监控Java进程
### cron定时任务
- 优点：系统进程，不易被回收
- 缺点：频率最低为一分钟执行一次
```bash
#!/bin/bash
count=`ps aux | grep -v 'grep' | grep -c 'java'`
if [ $count -eq 0 ]; then
        now=`date +%F\ %T`
        echo "[$now] Elasticseach is offline, try to restart..." >> /elasticsearch/check_es.log
        /elasticsearch/elasticsearch-7.0.0/bin/elasticsearch -d
else
        now=`date +%F\ %T`
        echo "[$now] Elasticsearch is online, everything seems to be OK..." >> /elasticsearch/check_es.log
fi
```

### while循环
- 优点：频率可最低设置为一秒一次
- 缺点：作为用户级别的后台进程，可能被回收

脚本：
```bash
while true;
do
    count=`ps aux | grep -v 'grep' | grep -c 'java'`
    if [ $count -eq 0 ]; then
            now=`date +%F\ %T`
            echo "[$now] Elasticseach is offline, try to restart..." >> /elasticsearch/check_es.log
            /elasticsearch/elasticsearch-7.0.0/bin/elasticsearch -d
    else
            now=`date +%F\ %T`
            echo "[$now] Elasticsearch is online, everything seems to be OK..." >> /elasticsearch/check_es.log
    fi
    sleep 1
done
```

执行：
```bash
nohup ./monitor.sh >/dev/null 2>&1 & 
```