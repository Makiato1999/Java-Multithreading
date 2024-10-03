# Java-Multithreading
Multithreading, Concurrency &amp; Parallel programming in Java

## User Thread vs. Daemon Thread
#### User Thread:
1. Runs in the foreground and performs important tasks.
2. JVM waits for all user threads to complete before it shuts down.
#### Daemon Thread:
1. Runs in the background.
2. JVM does not wait for daemon threads to finish. Once all user threads are done, the JVM will terminate the program, which also terminates any running daemon threads.

## InterruptedException and Thread.join()
1. The join() method can throw an InterruptedException. This happens if the thread that is waiting (i.e., the one that calls join()) is interrupted while it is waiting.
2. The reason for throwing InterruptedException is to signal that something has disrupted the thread's waiting process. Since a thread that calls join() can potentially be waiting for a long time, it’s possible that some other part of the program might want to stop this waiting thread. Such as:
    - Another thread needs this waiting thread to do something urgent.
    - Application shutdown, requiring all threads to stop as soon as possible.

## Latency and Throughput
1. Latency is about how fast a single request or action is completed, whereas Throughput is about how many requests or actions can be completed in a unit of time.
2. Trade-offs: There is often a trade-off between latency and throughput:
    - Increasing throughput might involve processing tasks in bulk, which could increase the latency for individual tasks.
    - Reducing latency often means ensuring individual tasks are executed faster, but this may reduce the overall throughput if fewer tasks are executed concurrently.