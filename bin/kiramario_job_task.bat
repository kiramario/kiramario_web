@echo off

REM 要切换到class目录下
cd D:\tomcat_kiramairo\apache-tomcat-7.0.75_kiramario\webapp_kiramario\kiramario_web\WEB-INF\classes

REM web项目的类
@SET APP_CLASSES=D:\tomcat_kiramairo\apache-tomcat-7.0.75_kiramario\webapp_kiramario\kiramario_web\WEB-INF\classes
REM web项目引用的jar包
@SET JAR_PATH=D:\tomcat_kiramairo\apache-tomcat-7.0.75_kiramario\webapp_kiramario\kiramario_web\WEB-INF\lib

REM 启动变量延迟赋值 否则在循环jar包且赋值的时候 只会赋值最后一个 感知不到变化状态 
REM 因为是先进行预处理 那么JAR在运行之前就已经赋值 JAR在循环的时候即不会变化 而直到最后一次循环才被附上新值
 
setlocal enabledelayedexpansion

REM 作为classpath的时候 .表示在当前目录找class
set JAR=.;
 
REM 循环遍历jar包  delims=空表示dir出来的字段每一行就被分成了一列  token不设置表示默认第一列 遍历时顺序是 行1列1  行2列1 
for /f "delims=" %%a in ('dir /b "%JAR_PATH%\*.jar"') do (set "JAR=!JAR!%JAR_PATH%\%%a;" )


set CLASSPATH=-classpath %JAR%;%APP_CLASSES%


"D:\Application\JAVA\JDK\bin\java" %CLASSPATH% com.kiramario.webInit.JobExecute


:: 运行完后保留窗口
cmd /k