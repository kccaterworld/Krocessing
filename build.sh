#!/bin/bash
SOURCES=$(find . -name "*.java")

rebuildFlag=false
if [ ! -f "krocessing.jar" ]; then
  rebuildFlag=true
else 
  for source in $SOURCES
    do if [ "$source" -nt "krocessing.jar" ]; then
      javac $source
        if [ $? -ne 0 ]; then
          echo "Compilation failed!"
          exit 1
        fi
      rebuildFlag=true
    fi
  done
fi
if [ "$rebuildFlag" = false ]; then
  echo -e "\nNo changes detected. krocessing.jar is up to date.\n"
  exit 0
fi

echo -e "\nBuilding krocessing.jar"
jar cfe krocessing.jar krocessing.Main -C . krocessing
echo -e "Build successful! Run with: java -jar krocessing.jar\n"
java -jar krocessing.jar -i
