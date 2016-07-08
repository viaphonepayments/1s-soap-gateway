#!/bin/sh
PID=$(cat pid)
kill -9 $PID
