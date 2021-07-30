@echo off
title redis-server
set ENV_HOME="D:\Apps\Develop\Redis-5.0.10"
D:
color 0a
cd %ENV_HOME%
redis-server.exe redis.windows.conf
exit