# class-cs112
 Lab sessions for cs112
 


```
 ----jGRASP wedge2: CLASSPATH is ";.;D:\git\class-cs112\cs112\lib\stdlib.jar;;C:\Program Files (x86)\jGRASP\extensions\classes".
 ----jGRASP wedge2: working directory is [D:\git\class-cs112\cs112\pset05].
 ----jGRASP wedge2: actual command sent ["C:\Program Files (x86)\jGRASP\bundled\java\bin\javac.EXE" -g Harp.java].
```


1. Set and export PATH and JAVA_HOME in bash or profile, both to the desired java file.

2. Set source with ". .profile"

3. Make sure that the javac being used is the correct one with "echo $PATH/$JAVA_HOME" or "which &PATH/  
$JAVA_HOME"

4. When setting a CLASSPATH make sure to call to the current file and then to the library wanted like so:
"./:desiredLibrary:". If a classpath for a certain file is wanted complie and run the file with ,"javac/j
ava -cp desiredLibrary yourFILE.java".  
