@echo off
:: ================================
:: React + Spring Boot LAN Hosting
:: ================================
setlocal

:: CONFIG
set REACT_PATH=C:\Users\user\Desktop\Spare_Part_Wala\frontend
set SPRING_PATH=C:\Users\user\Desktop\Spare_Part_Wala\SpringBootBackend
set REACT_PORT=3000
set SPRING_PORT=8080

:: Detect host IP
for /f "tokens=2 delims=:" %%f in ('ipconfig ^| findstr /C:"IPv4 Address"') do (
    set ip=%%f
    goto :found
)
:found
set ip=%ip: =%

echo =======================================
echo Host IP: %ip%
echo React running on: http://%ip%:%REACT_PORT%
echo Spring Boot running on: http://%ip%:%SPRING_PORT%
echo =======================================

:: Open firewall
netsh advfirewall firewall add rule name="ReactDevServer" dir=in action=allow protocol=TCP localport=%REACT_PORT%
netsh advfirewall firewall add rule name="SpringBootAPI" dir=in action=allow protocol=TCP localport=%SPRING_PORT%

:: Start Spring Boot
echo Starting Spring Boot backend...
start cmd /k "cd /d %SPRING_PATH% && mvn spring-boot:run"

:: Start React
echo Starting React frontend...
cd /d "%REACT_PATH%"
set HOST=0.0.0.0
set PORT=%REACT_PORT%
npm start

pause