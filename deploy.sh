#!/usr/bin/env bash
#编译+部署nancode站点

#需要配置如下参数
# 项目路径, 在Execute Shell中配置项目路径, pwd 就可以获得该项目路径
# export PROJ_PATH=这个jenkins任务在部署机器上的路径

### base 函数
killpid()
{
    pid=`ps -ef|grep nancode.jar|grep -v grep|awk '{print $2}'`
    echo "last java -jar Id list :$pid"
    if [ "$pid" = "" ]
    then
      echo "no pid alive"
    else
      kill -9 $pid
    fi
}


# 打包
cd $PROJ_PATH/nancode
mvn clean package -Dmaven.test.skip=true


# 停掉服务
killpid

cd $PROJ_PATH/nancode/target

echo `pwd`
echo `ls`

echo "> > > > > > > > > > > > > > > > > 启动应用..."

# 启动
nohup java -jar -Dsentry.dsn=https://ff095de64975450b9f96368415684eed@sentry.io/1228246 -Dserver.port=8090 -Dspring.profiles.active=prod nancode.jar > /dev/null 2>&1 &
echo "nancode startup ok"