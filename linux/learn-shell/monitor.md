## 监控进程
### cron定时任务

- 优点：系统进程，不易被回收
- 缺点：频率最低为一分钟执行一次

命名为`check_es.sh`
```bash
#!/bin/bash
count=`ps aux | grep 'java' | grep -v 'grep' -c`
if [ $count -eq 0 ]; then
        now=`date +%F\ %T`
        echo "[$now] Elasticseach is offline, try to restart..." >> /elasticsearch/check_es.log
        /elasticsearch/elasticsearch-7.0.0/bin/elasticsearch -d
else
        now=`date +%F\ %T`
        echo "[$now] Elasticsearch is online, everything seems to be OK..." >> /elasticsearch/check_es.log
fi
```

### cron配置

> 注意：一些进程可能需要`root`用户才能启动，所以可能`cron`也需切换到`root`用户才能生效。

查看现有定时任务

```bash
crontab -l
```

编辑定时任务
```bash
crontab -e
```

设置每分钟执行一次脚本
```bash
* * * * * /bin/bash /elasticsearch/check_es.sh
```

查看定时任务执行日志

```bash
tail -f /var/log/cron
```

查看脚本执行日志（自定义输出的日志）

```bash
tail -f /elasticsearch/check_es.log
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