# Java-Multithreading
Multithreading, Concurrency &amp; Parallel programming in Java

** User Thread vs. Daemon Thread **
#### User Thread:
1. Runs in the foreground and performs important tasks.
2. JVM waits for all user threads to complete before it shuts down.
#### Daemon Thread:
1. Runs in the background.
2. JVM does not wait for daemon threads to finish. Once all user threads are done, the JVM will terminate the program, which also terminates any running daemon threads.
