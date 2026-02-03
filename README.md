# Krocessing

[![Compilation Status](https://github.com/kccaterworld/Krocessing/actions/workflows/main.yml/badge.svg)](https://github.com/kccaterworld/Krocessing/actions/workflows/main.yml)

This project is my own attempt at copying the Processing app. I am using only what I can see of Processing, because looking at the source code is too complicated. The name "Krocessing" is a combination of "Kemal" and "Processing". It's meant to be a learning opportunity for me to practice Java programming, and as a way to text build a 2d (and eventually 3d) rendering engine. I'm editing it on both my Windows and Linux machines, which for some reason have different Java versions installed, which is why there are two .jar files. I would suggest compiling it on your own machine if you want to run it, just to be safe.

To Compile:
```bash
jar cfe krocessing.jar krocessing.Main -C . krocessing
```

To Run:
```bash
java -jar krocessing.jar
```

I'm open to any and all suggestions, as this is for me to learn and grow as a programmer.

Repository Structure:
- `krocessing/` - The main source code for the Krocessing application.
  - `environment/` - Contains classes related to the user interface and environment setup. Currently includes a basic UI window setup.
  - `functions/` - Holds definitions for all the Processing functions, based on documentation on the Processing website, and functions for executing those functions. Currently just a placeholder function for execution.
  - `output/` - Classes related to the rendering output. Currently includes a basic canvas setup.
- `build.sh` - A shell script to compile the Java source code into a .jar file on my Arch Linux machine (I chose Arch as a joke initially but stuck with it because I'm too lazy)
- `build.bat` - A batch script to compile the Java source code into a .jar file on my Windows machine.
