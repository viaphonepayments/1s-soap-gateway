set /p pid=<app.pid
@echo %pid%
taskkill /f /PID %pid%