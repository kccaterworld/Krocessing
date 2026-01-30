@echo off
setlocal enabledelayedexpansion

:: Clean old class files
for /r %%f in (*.class) do del "%%f" 2>nul

:: Find all Java files and compile them
set "SOURCES="
for /r %%f in (*.java) do set "SOURCES=!SOURCES! "%%f""

javac %SOURCES%

:: Check if compilation succeeded
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b 1
)

:: Create JAR with all class files
jar cfe krocessing.jar krocessing.Main -C . krocessing

echo Build successful! Run with: java -jar krocessing.jar