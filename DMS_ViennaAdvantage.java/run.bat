set ProjectPath=D:\Workspace\DMS.java
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\Lib\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause