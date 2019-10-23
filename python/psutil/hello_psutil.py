# -*- coding:utf-8 -*-

# pip install psutil
import datetime

import psutil

# CPU逻辑个数
print(psutil.cpu_count())
# CPU物理个数
print(psutil.cpu_count(logical=False))
# CPU使用率
print(psutil.cpu_percent())
print(psutil.cpu_percent(1))
# CPU逻辑信息
print(psutil.cpu_times())
print(psutil.cpu_times(percpu=True))
# CPU统计信息
# ctx_switches：启动后的上下问切换次数
# interrupts：自启动以来的中断次数
# soft_interrupts：启动后的软件中断数量
# syscalls：启动以来的系统调用次数，在Linux上始终为0
print(psutil.cpu_stats())

# 内存信息
memory = psutil.virtual_memory()
print(memory)
print(memory.total)
print(memory.available)
print(memory.percent)
print(memory.used)
print(memory.free)
# 磁盘信息
# 分区信息
print(psutil.disk_partitions())
# 磁盘利用率
print(psutil.disk_usage('/'))
# IO和读写数
print(psutil.disk_io_counters())
print(psutil.disk_io_counters(perdisk=True))

# 网络信息
# 网络总的IO情况
print(psutil.net_io_counters())
# 网卡的IO情况
print(psutil.net_io_counters(pernic=True))
# 网络连接信息, 可能需要root权限
print(psutil.net_connections())

# 开机时间
print(psutil.boot_time())
# 转换成自然时间格式
print(datetime.datetime.fromtimestamp(psutil.boot_time()).strftime("%Y-%m-%d %H: %M: %S"))

# 系统全部进程
print(psutil.pids())
# 获取当前脚本pid进程
process = psutil.Process()
# 获取指定pid进程
# process = psutil.Process(16660)
print(process)
# 进程状态, running
print(process.status())
# 进程名
print(process.name())
# 进程使用的CPU时间
print(process.cpu_times())
# 进程使用的内存
print(process.memory_info())
# 进程的线程数量
print(process.num_threads())
# 所有线程信息
print(process.threads())
# 进程打开的文件
print(process.open_files())
# 程相关网络连接
print(process.connections())
# 进程用户名
print(process.username())
# 进程创建时间
print(process.create_time())
# exe路径
print(process.exe())
# 工作目录
print(process.cwd())
# 进程启动的命令行
print(process.cmdline())
# 父进程ID
print(process.ppid())
# 获取父进程Process
print(process.parent())
# 进程环境变量
print(process.environ())

# 系统用户
print(psutil.users())

# Windows服务
print(list(psutil.win_service_iter()))

# 模拟ps命令
psutil.test()
