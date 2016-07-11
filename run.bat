@echo off
 setLocal EnableDelayedExpansion
 set CLASSPATH="
 for /R ./lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
 )
 set CLASSPATH=!CLASSPATH!"
 set CLASSPATH=%CLASSPATH%;VpSOAPService-0.0.1.jar
 echo !CLASSPATH!

start "VpSOAPService" /B javaw com.viaphone.soap.Application start