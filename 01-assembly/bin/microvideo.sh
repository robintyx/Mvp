#!/bin/bash
#
#
#############################
# Author:  南京感动科技有限公司
# Author:  宁传伟
# Version: 1.1
# Date:    2022/11/25
#############################
#
#

# 当前目录  如果是当前目录，可以不填
HOME_DIR=
# jar名   如果当前目录只有一个jar，可以不填
APP_NAME=
# 输出文件
OUT_FILE=
# 启动脚本
START_SH=
# 生成启动脚本
gen_start_sh() {
	# 判断当前目录
	if [ "$HOME_DIR" = "" ];then
		HOME_DIR=$(cd "$(dirname -- "$0")";pwd)
	fi
	# 判断jar名
	if [ "$APP_NAME" = "" ];then
		APP_NAME=$(ls *.jar)
	fi
	# 生成启动命令 -Dspring.profiles.active=xxx
	START_SH="nohup java  -Dfile.encoding=UTF-8  -jar -Xms256M -Xmx512M -XX:PermSize=256M -XX:MaxPermSize=Xmx512M  $HOME_DIR/$APP_NAME >/dev/null 2>&1&"
}

# 检查程序是否存活   1: 存在  0: 不存在
is_run() {
	gen_start_sh
	pid=$(ps -aux | grep -v grep | grep $HOME_DIR/$APP_NAME | awk '{print $2}')
	if [ "$pid" = "" ];then
		return 0
	else
		return 1
	fi
}

# 启动程序
start() {
	# 生成启动脚本
	gen_start_sh
	# 判断程序是否在运行
	is_run
	if [ "$?" = "1" ];then
		echo "进程已经存在，请勿多次启动"
		exit 1
	fi
		echo "PATH: $START_SH "
	# 启动程序
	eval $START_SH
	sleep 2
	is_run
	if [ "$?" = "1" ];then
		echo "进程已启动成功"
	else
		echo "进程启动失败，请检查"
	fi
}

# 停止程序
stop() {
	# 生成启动脚本
	gen_start_sh
	# 判断程序是否在运行
	is_run
	if [ "$?" = "0" ];then
		echo "程序未运行"
		exit 1
	fi
	# 获取进程pid
	pid=$(ps -aux | grep -v grep | grep $HOME_DIR/$APP_NAME | awk '{print $2}')
	# 杀死程序
	eval kill -9 $pid
	sleep 1
	is_run
	if [ "$?" = "0" ];then
		echo "程序已停止"
	else
		echo "进程停止失败，请检查"
	fi
}

# 重启
restart() {
  stop
  sleep 5s
  start
}

if [ $# -eq 1 ] && [ $1 == "stop" ]; then
        stop
elif [ $# -eq 1 ] && [ $1 == "start" ]; then
        start
elif [ $# -eq 1 ] && [ $1 == "restart" ]; then
        restart
else
        echo "当前脚本只支持stop, start, restart命令"
fi