pandemic
========
##Set-up for windows machine

### Download & Install intellij Community edition

    http://www.jetbrains.com/idea/download/

### Sign up for a github account

    https://github.com/

### Install git

    http://msysgit.github.io

### Add Git and Github to Intellij
    Open Intellij and under "Quick Start" in Intellij go to
    
    Settings > Project Settings > Version Control > Git and enter the path to the git.exe that was created on step 3 (probably in user/program files/git)
    
    Then go to Settings > Project Settings > Version Control > Github and enter your credentials you created in step 2.  Now you should be able to go back to the "Quick Start" and select "check out from version control" and then clone this project into some directory on your machine.  The address you should clone is

    https://github.com/dseapy/pandemic.git

### Install Scala Intellij Plugin

    You should be prompted automatically to do this when you open an .scala file.
    Similarly you should install the markdown plugin when you open this .md file

### Install the Java JDK

    http://www.oracle.com/technetwork/java/javase/downloads/index.html
    
    Then under "Project Settings" for this project you should be able to select a location for the "Project SDK".  Now you should be able to build and run the project through intellij.