@echo off

set SRC=./src
set CLASSES=./classes
set MAINFILE=.\src\in\conceptarchitect\app\FurnitureApp.java 

md %CLASSES%

javac -cp %SRC% -d %CLASSES%  %MAINFILE%