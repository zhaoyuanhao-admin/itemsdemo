#!/usr/bin/env bash
APP_JAR_NAME="${project.build.finalName}.jar"
PID=`jps -l | grep ${APP_JAR_NAME} | awk '{print $1}'`

if [ -n "$PID" ];then
    echo --------------------------
    echo stop ${APP_JAR_NAME}
    echo --------------------------
    kill ${PID}
    echo ${APP_JAR_NAME} has been stoped...
fi

