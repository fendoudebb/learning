## keepalived + nginx
当`nginx`进程不存在时，`keepalived`也必须自己kill掉，因为`keepalived`只是虚拟ip的路由。

当keepalived主备间因网络原因互相访问不了，备keepalived切换为MASTER开始提供服务，则称为keepalived脑裂
## keepalived配置文件
### 主keepalived
```shell
global_defs {
   notification_email {
    test@qq.com
   }
   notification_email_from Alexandre.Cassen@firewall.loc
   smtp_server 192.168.200.1
   smtp_connect_timeout 30
   router_id LVS_01
   #vrrp_strict  # 严格遵守vvrp协议，不注释访问不了VIP
}

vrrp_script chk_nginx {
    script "/usr/local/src/check_nginx.sh"    #检测nginx是否存活脚本
    interval 2                          #检测脚本执行的间隔，单位：秒
    weight 2
}

vrrp_instance VI_1 {
    state MASTER # 指定keepalived的角色，MASTER为主，BACKUP为备
    interface eth0
    virtual_router_id 51 # 虚拟路由编号，主从要一致
    priority 150 # 优先级，数值越大，获取处理请求的优先级越高，step建议为50
    advert_int 1 # 检查间隔，默认为1s(vrrp组播周期秒数)
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    track_script {
        chk_nginx # 调用vrrp_script指定的脚本
    }
    virtual_ipaddress {
        10.0.0.17/24 # 定义虚拟ip(VIP)，可多设，每行一个
    }
}
```

### 备keepalived
```shell
global_defs {
   notification_email {
    test@qq.com
   }
   notification_email_from Alexandre.Cassen@firewall.loc
   smtp_server 192.168.200.1
   smtp_connect_timeout 30
   router_id LVS_02
}

vrrp_script chk_nginx {
    script "/usr/local/src/check_nginx.sh"    #检测nginx是否存活脚本
    interval 2                          #检测脚本执行的间隔，单位：秒
    weight 2
}

vrrp_script chk_split_brain {
    script "/usr/local/src/check_split_brain.sh"    
    interval 2                         
    weight 2
}

vrrp_instance VI_1 {
    state BACKUP # 指定keepalived的角色，MASTER为主，BACKUP为备
    interface eth0
    nopreempt # 不抢占VIP，MASTER恢复时VIP交给MASTER
    virtual_router_id 51 # 虚拟路由编号，主从要一致
    priority 100 # 优先级，数值越大，获取处理请求的优先级越高，step建议为50
    advert_int 1 # 检查间隔，默认为1s(vrrp组播周期秒数)
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    track_script {
        chk_nginx # 调用vrrp_script指定的脚本
        chk_split_brain
    }
    virtual_ipaddress {
        10.0.0.17/24 # 定义虚拟ip(VIP)，可多设，每行一个
    }
}
```

## 检测nginx脚本
```shell
#!/bin/bash
#时间变量，用于记录日志
d=`date --date today +%Y/%m/%d-%H:%M:%S`
#计算nginx进程数量
n=`ps -C nginx --no-heading|wc -l`
#如果进程为0，则启动nginx，并且再次检测nginx进程数量，
#如果还为0，说明nginx无法启动，此时需要关闭keepalived
if [ $n -eq "0" ]; then
        /etc/init.d/nginx start
        n2=`ps -C nginx --no-heading|wc -l`
        if [ $n2 -eq "0"  ]; then
                echo "$d nginx down,keepalived will stop" >> /var/log/check_ng.log
                systemctl stop keepalived # 停止keepalived
        fi
fi
```

修改脚本权限:
```shell
chmod 755 /usr/local/sbin/check_nginx.sh
```

## 检测keepalived脑裂脚本

脑裂脚本只在备keepalived机器部署

```shell
#!/bin/bash
LB_VIP=10.0.0.17
LB_MASTER_IP=10.0.0.7

ping -c 2 -W 3 $LB_VIP &>/dev/null
if [$? -eq 0 -a `ip addr|grep "LB_MASTER_IP"|wc -l` -eq 1];then
    echo "keepalived is split-brain"
fi
```