@echo off
setlocal EnableDelayedExpansion
rem use jps find the app's pid, and kill it
for /f "delims= " %%i in ('jps -l ^| find /i "${project.build.finalName}"') do (

    echo The application is going to stop running!
    tskill %%i

    for /f "delims= " %%j in ('jps -l ^| find /i "${project.build.finalName}"') do (
        rem if app still running, kill it again
        tskill %%j
    )
    echo application has been stop......
    goto end
)
echo Alarm application are not running
:end
pause