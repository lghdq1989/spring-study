#!/bin/sh
#18.194.33.152 security,mange,pub
#3.120.177.50 网关、web-后端管理
#18.184.3.180 ek
#3.123.142.146 job,product
array01=("dcp-service-security-1.0.0-SNAPSHOT-exec.jar" "dcp-service-dcpmange-1.0.0-SNAPSHOT-exec.jar" "dcp-service-pub-1.0.0-SNAPSHOT-exec.jar")
array02=("dcp-server-gateway-1.0.0-SNAPSHOT-exec.jar" "dcp-web.zip")
array03=("dcp-server-eureka-1.0.0-SNAPSHOT-exec.jar")
array04=("dcp-job-admin.zip" "dcp-job-executor-1.0.0-exec.jar" "dcp-service-product-1.0.0-SNAPSHOT-exec.jar")
info(){
  echo "正在发送============================================================"
  echo $2
  if [[ '01' = $1 ]]; then
     array = $array01
    fi
  if [[ '02' = $1 ]]; then

    for i in  ${array02[@]};
      do
        filescp $i "#3.120.177.50"
      done
    fi

break;
}
filescp(){
  if [ ! -f "/var/www/html/eujar/$1" ];then
  echo "文件不存在"
  else
  sudo  scp -i /home/ec2-user/eu-central1-key.pem -r /var/www/html/eujar/$1  centos@$2 /apps/data/$1
  echo $1
  fi

}



cat << end
  01.发送security,mange,pub
  02.发送job,product
  03.发送ek
  04.网关 web
end
select num  in "01" "02" "03" "04"
do
  case "$num" in
   '01')
      info 01 "18.194.33.152"
      ;;
   '02')
     info 02 "3.120.177.50"
     ;;
   '03')
     info 03 "18.184.3.180"
     ;;
   '04')
     info 04 "3.123.142.146"
     ;;

  *)
     echo "Usage: $0 {start|stop|restart}"
     exit 1
esac
done
exit 0
