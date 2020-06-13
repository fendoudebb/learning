## 相关命令
`Ctrl+C`

终止并退出前台命令的执行。

`Ctrl+Z`

暂停前台命令的执行，将该进程放入后台。

`&`

运行命令时，在命令末尾加上`&`可让命令在后台执行。

## jobs

查看当前在后台执行的命令，可查看命令进程号码。

```bash
[root@localhost ~]$ jobs
[1]-  Stopped                 tail -f /var/log/cron
[2]+  Stopped                 tail -f /usr/local/nginx/logs/access.log
```

## fg N 与 fg

`fg N`：将命令进程号码为`N`的命令进程放到前台执行，同`%N`。如：`fg 1`。

`fg`：将最近一个后台挂起的任务放到前台执行。

## bg N 与 fg

将命令进程号码为N的命令进程放到后台执行，即：添加`&`。

## disown

忽略`HUP`信号。不受用户退出、终端关闭的影响（导致任务停止），继续后台执行该任务。需配合`Ctrl+Z`和`jobs`使用。

1. `Ctrl+Z`：挂起正在执行的命令。
2. `jobs`：查看`id`。
3. `disown -h N`：忽略`id`为`N`的后台挂起任务的`HUP`信号，使其继续后台执行。