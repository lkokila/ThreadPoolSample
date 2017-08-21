# ThreadPoolSample
This is a sample Client-Server application in which the server uses a fixed number of threads to serve clients by responding with the current Date/Time. Here the Server runs with a configured number of threads and client requests beyond the above mentioned number will be queued until a thread is released. 

# How to Start
1.First run the Server Program and then run the Client program by executing the main methods respectively. 
2.The window prompted via the Client program will expect the ip address of the Server program's host, and once provided it will display the current Date/Time. 

# Configurations
1.Port can be configured by changing the variable - port - in Client and Server programs. 
2.Number of threads in the Server program can be configured by changing the variable - numberOfThreads - in the Server program. 
