#!/bin/bash

#time1=`date +"%s.%N"`
gitPath=c-ocs-front/c-ocs-front.git

svnTrunkPath=svn://svn.midea.com/CCS_DEV/OCS/Trunk/ccs-backend
feTrunkWorkspace=/apps/data/build/workspace/trunk/ccs-frontend
beTrunkWorkspace=/apps/data/build/workspace/trunk/ccs-backend

#压测试环境代码分支
bePerfWorkspace=/apps/data/build/workspace/trunk_perf/ccs-backend
svnPerfPath=svn://svn.midea.com/CCS_DEV/OCS/Branches/CCS_OCS_V01R00_20200331/ccs-backend


svnEcoPath=svn://svn.midea.com/CCS_DEV/OCS/Branches/CCS_OCS_ECO/ccs-backend
feEcoWorkspace=/apps/data/build/workspace/eco/ccs-frontend
beEcoWorkspace=/apps/data/build/workspace/eco/ccs-backend

logPath=/apps/data/build/logs
targetPath=/apps/data/build/target
scriptPath=/apps/data/build/script
svnBin=/usr/bin
mavenBin=/apps/data/apache-maven-3.5.3/bin

offline="";

if [[ $1 == "-offline" ]]; then
  echo -e "参数offline将会跳过从nuexs下载jar文件"
  offline=" -o";
fi

updatePkg="";
if [[ $1 == "-updatePkg" ]]; then
  echo -e "参数updatePkg将更新npm的package包"
  updatePkg="true";
fi

checkout="";
if [[ $1 == "-checkout" ]]; then
  echo -e "参数checkout将全量同步svn或git的代码"
  checkout="true";
fi

#定义必要的依赖包
declare -a commonJars=('ocs-common-core' 'ccs-common-core' 'ccs-common-api' 'ccs-common-service')

#定义所有的微服务
declare -A map=()
map["0"]="All"
map["1"]="ccs-frontend-vue"
map["2"]="ccs-service-base"
map["3"]="ccs-service-supplychain"
map["4"]="ccs-service-finance"
map["5"]="ccs-service-security"
map["6"]="spring-cloud-eureka"
map["7"]="spring-cloud-gateway"



declare -a envs=('dev' 'sit' 'uat' 'ver' 'perf' 'prod')
read -p "请输入发版的环境（dev/sit/uat/ver/perf/prod）: " input

#envName决定同步哪个环境的配置文件：/apps/data/build/config/dev
#profile决定springboot启动时加载哪个配置文件
for val in ${envs[@]}; do  
    if [[ ${input} == ${val} ]]; then
        envName=${input}
    fi    
done

if [ -z ${envName} ]; then
    echo -e "选择的发版环境有误..."
    exit 1
fi

logPath=${logPath}/${envName}
targetPath=${targetPath}/${envName}


#不同环境对应的主干分支不同
if [[ ${envName} == "ver" ]] || [[ ${envName} == "prod" ]]; then
   feWorkspace=${feEcoWorkspace}
   beWorkspace=${beEcoWorkspace}
   svnPath=${svnEcoPath}
   if [[ ${envName} == "prod" ]]; then
      gitBranch="master"
   else
      gitBranch="eco"
   fi
elif [[ ${envName} == "perf" ]]; then
   feWorkspace=${feTrunkWorkspace}
   beWorkspace=${bePerfWorkspace}
   svnPath=${svnPerfPath}
   gitBranch="trunk"
else
   feWorkspace=${feTrunkWorkspace}
   beWorkspace=${beTrunkWorkspace}
   svnPath=${svnTrunkPath}
   gitBranch="trunk"
fi

serviceWorkspace=${beWorkspace}/ccs-service-modules
springWorkspace=${beWorkspace}/spring-cloud-modules

mkdir -p ${logPath}
mkdir -p ${targetPath}
mkdir -p ${feWorkspace}
mkdir -p ${beWorkspace}

echo -e ""
for key in ${!map[@]};
do
  echo -e "\033[1;36m ${key}: ${map[$key]} \033[0m"
done

read -p "请输入需要发版的模块序号(空格隔开): " input
selectArr=(${input})

#找出选择的模块（支持多选）
i=0
declare -a servList=()
isAll="false"
isVue="false"
isMicroServ="false"
for val in ${selectArr[@]}; do
  if [[ ${val} == 0 ]]; then
      isAll="true"
      isVue="true"
      isMicroServ="true"
      break
  elif [[ ${val} == 1 ]]; then
      isVue="true"
      if [[ ${envName} == "ver" ]] || [[ ${envName} == "prod" ]] || [[ ${envName} == "uat" ]]; then
          read -p "请输入Tag或分支名，为空则拉取默认分支: " input
          if [[ -n ${input} ]]; then
             gitTag=${input}
          fi
      fi
  else
    isMicroServ="true"
    for key in ${!map[@]}; do
      if [[ ${key} == ${val} ]]; then
        servList[i]=${map[$key]}
        ((i++))
      fi
    done
  fi
done

#如果全选，则微服务列表是除了选项0和1外的所有选项
i=0
if [[ ${isAll} == "true" ]]; then
   servList=()
   for key in ${!map[@]}; do
      if [[ ${key} != 0 ]] && [[ ${key} != 1 ]]; then
        servList[i]=${map[$key]}
        ((i++))
      fi
    done
fi


if [[ ${isVue} == "true" && ${#servList[@]} == 0 ]]; then 
    echo -e "本次发版的模块：\n"
    echo -e "\033[1;6;41;33m ${map[1]} \033[0m"
    
elif [[ ${isVue} == "true" && ${#servList[@]} > 0 ]]; then
    echo -e "本次发版的模块：\n"
    echo -e "\033[1;6;41;33m ${map[1]} \033[0m"
    
    for appName in ${servList[@]}; do        
      echo -e "\033[1;6;41;33m ${appName} \033[0m"
    done
elif [[ ${isVue} == "false" && ${#servList[@]} > 0 ]]; then
    echo -e "本次发版的模块：\n"
    for appName in ${servList[@]}; do        
      echo -e "\033[1;6;41;33m ${appName} \033[0m"
    done
elif [[ ${#servList[@]} == 0 && ${isVue} == "false" ]]; then
    echo -e "输入的序号无一个正确..."
    exit 1
fi

echo -e ''
sleep 2

#删除7天前的备份
find ${targetPath}/backup/ -type d -name "*" -mtime +7 -print -exec rm -rf {} \; 2> /dev/null
bkFolder=`date +"%Y%m%d-%H%M%S"`
bkPath=${targetPath}/backup/${bkFolder}
mkdir -p ${bkPath}


function buildDist(){
    envName=$1
    
    cd ${feWorkspace}
    rm -rf dist
    npm run build:${envName}
    echo -e "前端代码已成功编译到目录：${feWorkspace}/dist"
}

#编译发版前端代码
if [[ ${isVue} == "true" ]]; then
    echo -e "开始备份上次的前端代码文件，请耐心等待..."
    cd ${feWorkspace}
    tar -zcf ${bkPath}/ccs-frontend-vue.tar.gz *
    echo -e "已备份上次的前端代码到${bkPath}\n"

    echo -e "\033[43;30m------------------------------开始同步git代码----------------------------------\033[0m"
    echo -e "--------------------- $(date) --------------------" | tee -a ${logPath}/git.log
    
    if [[ ${checkout} == "true" ]]; then
        echo -e "checkout模式将会下载全部git代码并覆盖更新"
        rm -rf ${feWorkspace}/*
        mkdir -p ${feWorkspace}
        git clone -b ${gitBranch} git@git.midea.com:${gitPath} ${feWorkspace} | tee -a ${logPath}/git.log
    elif [[ -n ${

    } ]]; then
        cd ${feWorkspace}
        git checkout ${gitTag} | tee -a ${logPath}/git.log
        if [[ ${gitTag} == "eco" ]] || [[ ${gitTag} == "trunk" ]]; then
            git pull | tee -a ${logPath}/git.log
        fi
    else
        cd ${feWorkspace}
        git checkout ${gitBranch} | tee -a ${logPath}/git.log
        git pull | tee -a ${logPath}/git.log
    fi
    
    #首次下载或更新依赖包
    if [[ ${updatePkg} == "true" || ${checkout} == "true" ]]; then        
        #切换midea镜像并打印
        npm config set registry http://npm.midea.com:7001
        npm config get registry
        
        cd ${feWorkspace}
        npm install
    fi
    
    #编译打包
    buildDist ${envName}
    
    #发版前端代码
    ${scriptPath}/_publish_vue.sh ${envName} ${feWorkspace}    
fi


function buildJar(){
    app=$1
    isService=$2
    echo -e "\033[43;30m------------------------- 开始打包：${app} ---------------------------\033[0m"
    
    if [[ ${app} =~ ^spring.* ]]; then
      srcPath=${springWorkspace}/${app}
    else
      srcPath=${serviceWorkspace}/${app}
    fi
    
    cd ${srcPath}
    
    #手工删除缓存
    rm -rf target
    ${mavenBin}/mvn -T 2C clean package install -DskipTests ${offline} | tee ${logPath}/${app}.log
    result=` grep 'BUILD SUCCESS' ${logPath}/${app}.log `
    
    sleep 1s
    if [[ -z ${result} ]]; then
      echo -e "\033[1;41;33m------------------------- 打包失败：${app} --------------------------\033[0m\n\n"
      exit 1
    else 
      echo -e "\033[1;42;33m ------------------------- 打包成功：${app} --------------------------\033[0m\n\n"
      #copy微服务JAR包到统一target目录
      if [[ ${isService} == "2" ]]; then
         cp -rf ${srcPath}/target/${app}*-exec.jar ${targetPath}
      fi
    fi    
}

#编译发版后端代码
if [[ ${isMicroServ} == "true" ]]; then
    echo -e "开始备份上次的JAR包文件，请耐心等待..."
    for appName in ${servList[@]}; do
      cp ${targetPath}/${appName}*.jar ${bkPath}
    done
    echo -e "已备份上次的JAR包到${bkPath}\n"
    
    
    echo -e "\033[43;30m------------------------------开始同步SVN代码----------------------------------\033[0m"
    echo -e "--------------------- $(date) --------------------" | tee -a ${logPath}/svn.log
    
    if [[ ${checkout} == "true" ]]; then
        echo -e "checkout模式将会下载全部svn代码并覆盖更新"
        #rm -rf ${beWorkspace}
        #mkdir -p ${beWorkspace}
        #${svnBin}/svn checkout ${svnPath} ${beWorkspace} 2>${logPath}/svn_err.log | tee -a ${logPath}/svn.log
        ${svnBin}/svn checkout ${svnPath} ${beWorkspace} | tee -a ${logPath}/svn.log
    else
        cd ${beWorkspace}
        #${svnBin}/svn update 2>${logPath}/svn_err.log | tee -a ${logPath}/svn.log
        ${svnBin}/svn update | tee -a ${logPath}/svn.log
    fi
    
    svnchk=`cat ${logPath}/svn_err.log | grep 'Authorization failed'`
    #if [ !n $svnchk ]; then
    	#echo -e "\033[1;42;33m SVN账号认证失败！\033[0m"
        #exit 1
    #fi
    

    echo -e ''
    
    #打包必要的依赖包
    isService="1"
    for jar in ${commonJars[@]}; do  
      buildJar ${jar} ${isService}
    done

    #打包微服务
    isService="2"
    for appName in ${servList[@]}; do
      buildJar ${appName} ${isService}
    done
    #发版微服务
    isBuildOk=1
    isSyncJar="true"
    if [[ ${isBuildOk} == "1" ]]; then
      for appName in ${servList[@]}; do
        ${scriptPath}/_publish_serv.sh ${isSyncJar} ${envName} ${appName}
      done  
    else
      echo -e "\033[1;42;33m发版失败，微服务未能重启\033[0m"
      exit 1;
    fi

    #检查服务器状态
    for appName in ${servList[@]}; do
        ${scriptPath}/check_ccs.sh ${envName} ${appName}
    done 

fi
