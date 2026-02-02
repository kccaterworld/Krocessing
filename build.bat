@echo off
setlocal enabledelayedexpansion
for /r %%f in (*.class) do del "%%f" 2>nul
set "SOURCES="
for /r %%f in (*.java) do set "SOURCES=!SOURCES! "%%f""
javac %SOURCES%
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b 1
)
jar cfe krocessingWindows.jar krocessing.Main -C . krocessing
echo Build successful! Run with: java -jar krocessingWindows.jar
for /r %%f in (*.class) do del "%%f" 2>nul