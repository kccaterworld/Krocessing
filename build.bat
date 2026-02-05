@echo off
setlocal enabledelayedexpansion
set "SOURCES="
for /r %%f in (*.java) do set "SOURCES=!SOURCES! "%%f""
javac %SOURCES%
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b 1
)
jar cfe krocessing65.jar krocessing.Main -C . krocessing
echo Build successful! Run with: java -jar krocessing65.jar