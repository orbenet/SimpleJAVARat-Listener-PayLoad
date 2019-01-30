########################
~~~~~~~~~~~~~~~~~~~~~~~~~~
SimpleJAVARAT-Listener-Payload 
~~~~~~~~~~~~~~~~~~~~~~~~~~
A simple reverse shell that works. 

@
Or I. Benet//
IT Specialist//
M.IS UoP - Cyber Security - Epsilon Pi Tau//
B.S. Troy - Chemistry - Mathmatics//
@
####################

~~~Included Files~~~
  RATCLIENT.java - Windows Payload that opens up a command-shell
  RATCLIENT.class - compiled

  RATSERVER.java - Simple CLI Listener
  RATSERVER.class - compiled

  ~~~~~~~~~~~~~~~~
  
Regular USAGE:
  @@@@
  1. Start the RATSERVER ON ATTACKING MACHINE (command: java RATSERVER)
  @@@@
  2. Start the RATCLIENT on VICTIM MACHINE (command: java <hostip>)
  @@@@
.............................................................................................................................

Android USAGE:
@@@@
1. Create new Android Project
@@@@
2. Create a Relative layout with scrollView , editText, and button.
@@@@
3. Copy classes
@@@@
4. add     <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    
    to manifest
@@@@
5. Start the Application on an Android Device or VM
@@@@
6. Start the RATCLIENT on VICTIM MACHINE
