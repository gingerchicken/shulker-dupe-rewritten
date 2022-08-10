# Shulker Dupe Rewritten
<p align="center">
    <img src="src/main/resources/assets/shulkerdupe/icon.png" alt="Gradlew Build" width="256px"/>
    <br>
    <img src="https://github.com/gingerchicken/shulker-dupe-rewritten/actions/workflows/build.yml/badge.svg" alt="Gradlew Build"/>
    <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="MIT">
    <a href="https://minecraft.net/"><img src="https://img.shields.io/badge/MC-1.18.2-brightgreen.svg" alt="Minecraft"/></a>
</p>

A more libre implementation of the original [shulker dupe mod](https://github.com/gingerchicken/shulker-dupe) built so that people can use it in whatever projects they like.

## Installation
Firstly, you must obtain the mod's jar file, this can be done two ways:

1. Download the jar file from the [Release page](https://github.com/gingerchicken/shulker-dupe-rewritten/releases)
2. [Build the mod from source](#build)

## Build
To build the mod from source you will need **OpenJDK 17** for building the mod, however I will assume you already have this installed. 

After you must complete the following steps:

### GNU/Linux

```bash
$ ./gradlew build
```

### Windows
I advise that you use PowerShell to run the build command.

```powershell
> ./gradlew build
```