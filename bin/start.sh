#!/usr/bin/env bash
APP_JAR_NAME="${project.build.finalName}.jar"
JVM_ARGS="-server -Xms1024m -Xmn512m"

check(){
    PID=`jps -l | grep ${APP_JAR_NAME} | awk '{print $1}'`
    if [ -n "$PID" ];then
        echo ${APP_JAR_NAME} has been started on pid:${PID}
        return 1
    else
        return 0
    fi
}
check
IS_RUN=$?
if [ ${IS_RUN} -eq 0 ];then
    echo ------------------------------
    echo ${APP_JAR_NAME} starting....
    echo ------------------------------
    cd ../
    nohup java ${JVM_ARGS} -jar ${APP_JAR_NAME} > /dev/null 2>&1 &
    check
    IS_RUN=$?
    if [ ${IS_RUN} -eq 0 ];then
        echo ${APP_JAR_NAME} start failure...
    fi
fi

