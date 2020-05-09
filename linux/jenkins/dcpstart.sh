#!/bin/sh
#APP_NAME=dcp-server-eureka-1.0.0-SNAPSHOT-exec.jar
APP_NAME=$2
APP=""
psid=0
echo "name=$APP_NAME"

array=("dcp-service-dcpmange-1.0.0-SNAPSHOT-exec.jar" "dcp-service-pub-1.0.0-SNAPSHOT-exec.jar" " dcp-service-security-1.0.0-SNAPSHOT-exec.jar")
arrays=("pub" "manage" "security" )

for i in ${array[@]};
      do
      echo $i
   if [[ $i =~  $APP_NAME ]]; then
      APP=$i
       echo  "Starting $APP_NAME ..."
   fi
      done


info(){
  for j in ${arrays[@]};
      do
        echo $j
          sudo mkdir -p  /apps/data/service/$j/logs
          cd /apps/data/service/$j/logs
          sudo touch console.log
          sudo touch dump.hprof
          sudo chmod 777  *



      done
}

checkpid() {
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
    echo "warn: $APP already started! (pid=$psid)"
    echo "================================"
 else
    echo -n "Starting $APP ..."
    cd /apps/data/service/$APP_NAME
    sudo chmod 777 $APP
    sudo nohup /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.242.b08-0.el7_7.x86_64/jre/bin/java -server -Xms2g -Xmx2g -Xss512K -XX:+DisableExplicitGC -XX:SurvivorRatio=2 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+CMSClassUnloadingEnabled -XX:LargePageSizeInBytes=128M -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/apps/data/service/$APP_NAME/logs/dump.hprof -Dio.netty.leakDetectionLevel=advanced -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 /apps/data/service/&APP_NAME/$i --server.port=8000 --spring.profiles.active=dev >/apps/data/service/$APP_NAME/logs/console.log 2>&1 &

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
    'restart')
     stop
     start
     ;;
   'info')
     info
     ;;
  *)
     echo "Usage: $0 {start|stop|restart}"
     exit 1
esac
exit 0
