@echo off
echo Compiling Student Management System...
javac *.java
if errorlevel 1 (
    echo.
    echo Compilation failed. Check the errors above.
    pause
    exit /b
)
echo.
echo Starting Student Management System...
echo.
java Main
pause
