#!/bin/bash
dirname=/usr/local/target
shellnamefile=/usr/local/shell
vuefile=/usr/local/vuefile
echo "the dir name is $dirname"
if [ ! -d $dirname  ];then
  mkdir $dirname -p
fi
echo "the shell name is $shellnamefile"
if [ ! -d shellnamefile  ];then
  mkdir $shellnamefile -p
fi
echo "the vuefile name is $vuefile"
if [ ! -d vuefile  ];then
  mkdir $vuefile -p
fi
