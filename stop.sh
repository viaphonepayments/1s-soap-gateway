#!/bin/sh
PID=$(cat app.pid)
kill -9 $PID