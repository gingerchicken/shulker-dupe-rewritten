# Shulker Dupe Rewritten
<p align="center">
    <img src="src/main/resources/assets/shulkerdupe/icon.png" alt="Gradlew Build" width="256px"/>
    <br>
    <img src="https://github.com/gingerchicken/shulker-dupe-rewritten/actions/workflows/build.yml/badge.svg" alt="Gradlew Build"/>
    <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="MIT">
    <a href="https://minecraft.net/"><img src="https://img.shields.io/badge/MC-1.18.2-brightgreen.svg" alt="Minecraft"/></a>
</p>

A more libre implementation of the original [shulker dupe mod](https://github.com/Coderx-Gamer/shulker-dupe) built so that people can use it in whatever projects they like.

## Disclaimer
As you may have noticed from the link above, this is a fork, **I am not the original author of the mod**, this would in fact be **[Coderx-Gamer](https://github.com/Coderx-Gamer)**

> At the time of re-writing this mod, the original author had not licensed their code, meaning that I had no write to use it, hence why I re-wrote it! For more information, please check out [issue #9](https://github.com/gingerchicken/shulker-dupe-rewritten/issues/9)

## Installation
This modification runs on [**Fabric**](https://fabricmc.net/) for **Minecraft: Java Edition**, so make sure you have Fabric installed properly before you try to install this mod. To start installing the mod, you must obtain the mod's jar file, this can be done two ways:

### Obtaining the jar file
1. Download the jar file from the [release page](https://github.com/gingerchicken/shulker-dupe-rewritten/releases).
2. [Build the mod from source](#build).

### Installing
You will need to download one dependency for the mod to work, this is the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files/all?filter-game-version=1738749986%3a73250), you simply place this in your **mods folder** next to the shulker dupe mod.

Once **both** the Fabric API and the shulker dupe mod are placed into your mods folder, you should be able to launch Minecraft and have fun duping!

## Build
To build the mod from source you will need **OpenJDK 17**, however I will assume you already have this installed. 

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