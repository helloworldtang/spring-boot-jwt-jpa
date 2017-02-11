#!/bin/bash
ps -ef|grep selectdata-|grep -v grep|awk '{print $2}'|xargs kill -9 2>/dev/null
ps -ef|grep selectdata-|grep -v grep
echo "success"
