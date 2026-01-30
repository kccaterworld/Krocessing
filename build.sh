#!/bin/bash

# Clean old class files
find . -name "*.class" -delete 2>/dev/null

# Find all Java files and compile them
SOURCES=$(find . -name "*.java")

javac $SOURCES

# Check if compilation succeeded
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# Create JAR with all class files
jar cfe krocessing.jar krocessing.Main -C . krocessing

echo "Build successful! Run with: java -jar krocessing.jar"
