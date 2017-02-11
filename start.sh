#!/bin/bash
nohup java -jar -Dspring.profiles.active=prod  selectdata-0.0.1-SNAPSHOT.jar 2>error.log 1>/dev/null &



