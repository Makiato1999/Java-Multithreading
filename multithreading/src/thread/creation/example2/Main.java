package thread.creation.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        for (Thread thread:
             threads) {
            thread.start();
        }
    }

    private static class Vault {
        private int password;
        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread "+this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName()+" guessed the password "+guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess >0; guess--) {
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName()+" guessed the password "+guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        public PoliceThread() {
            this.setName(this.getClass().getSimpleName());
        }

        /**
         *  The start() method is responsible for starting a new thread of execution.
         *  When you call start(), it creates a new thread in the Java Virtual Machine (JVM)
         *  and runs the code in that new thread, allowing the concurrent execution of tasks.
         */
        @Override
        public void start() {
            System.out.println("Starting thread "+this.getName());
            super.start();
        }

        /**
         *  The run() method can be called directly just like a normal method.
         *  However, if you call run() directly without using start(),
         *  it will not create a new thread—instead, it will execute in the current thread,
         *  just like any other method call.
         */
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println(i);
            }

            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }
}
