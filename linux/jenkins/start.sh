#!/bin/sh
#APP_NAME=dcp-server-eureka-1.0.0-SNAPSHOT-exec.jar
APP_NAME=$2
psid=0
echo "name=$APP_NAME"
array=("dcp-service-dcpmange-1.0.0-SNAPSHOT-exec.jar" " dcp-service-product-1.0.0-SNAPSHOT-exec.jar" "dcp-service-pub-1.0.0-SNAPSHOT-exec.jar" " dcp-service-security-1.0.0-SNAPSHOT-exec.jar" "dcp-server-gateway-1.0.0-SNAPSHOT-exec.jar" "dcp-job-executor-1.0.0-exec.jar")
info(){
 for i in ${array[@]};
	do     
		cd /usr/local/target
		nohup java -server -Xms512m -Xmx512m  -jar $i >/dev/null 2>&1 &
	done
}
checkpid() {
   echo "1.psid:=$psid"
   ps=`ps -ef | grep $APP_NAME | grep java  | grep -v grep`
   echo "ps -ef | grep $APP_NAME | grep java  |grep -v grep"
   if [ -n "$ps" ]; then
      psid=`echo $ps | awk '{print $2}'`
   else
      psid=0
   fi
}

start() {
 checkpid
 if [ $psid -ne 0 ]; then
    echo "================================"
    echo "warn: $APP_NAME already started! (pid=$psid)"
    echo "================================"
 else
    echo -n "Starting $APP_NAME ..."
    cd /usr/local/target
    chmod 777 $APP_NAME
    echo `pwd`
    nohup java -server -Xms512m -Xmx512m  -jar $APP_NAME >/dev/null 2>&1 &
    echo "pid=$psid==========="

 fi
}

stop() {
   checkpid
   if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_NAME ...(pid=$psid) "
      kill -9 $psid
      if [ $? -eq 0 ]; then
         echo "[OK]"
      else
         echo "[Failed]"
      fi

      checkpid
      if [ $psid -ne 0 ]; then
         stop
      fi
   else
      echo "================================"
   fi
}





case "$1" in
   'start')
      start
      ;;
   'stop')
     stop
     ;;
   'restart')
     stop
     start
     ;;
   'status')
     status
     ;;
   'info')
     info 
     ;;
  *)
     echo "Usage: $0 {start|stop|restart}"
     exit 1
esac
exit 0
