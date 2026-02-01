#!/bin/bash
find . -name "*.class" -delete 2>/dev/null
SOURCES=$(find . -name "*.java")
javac $SOURCES
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi
jar cfe krocessing.jar krocessing.Main -C . krocessing
echo "Build successful! Run with: java -jar krocessing.jar"
find . -name "*.class" -delete 2>/dev/null