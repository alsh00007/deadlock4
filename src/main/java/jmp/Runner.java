package jmp;

public class Runner {


    public static void main(String args[]) {

        final Account account1 = new Account(10);
        final Account account2 = new Account(100);
        final Account account3 = new Account(20);
        final Account account4 = new Account(40);

        Thread transfer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account1) {
                    System.out.println("Transfer 1: Holding account 1...");
                    int many = 5;
                    try {
                        account1.deduct(many);
                        //emulation delay
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Transfer 1: Waiting for account 2...");
                    synchronized (account2) {
                        System.out.println("Transfer 1: Holding account 1 & 2...");
                        account2.add(many);
                    }
                }
            }
        });
        Thread transfer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account2) {
                    int many = 7;
                    System.out.println("Transfer 2: Holding account 2...");
                    try {
                        account2.deduct(many);
                        //emulation delay
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Transfer 2: Waiting for account 3...");
                    synchronized (account3) {
                        System.out.println("Transfer 2: Holding account 1 & 2...");
                        account3.add(many);
                    }
                }
            }
        });
        Thread transfer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account3) {
                    int many = 8;
                    System.out.println("Transfer 3: Holding account 3...");
                    try {
                        account3.deduct(many);
                        //emulation delay
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Transfer 3: Waiting for account 4...");
                    synchronized (account4) {
                        System.out.println("Transfer 1: Holding account 3 & 4...");
                        account4.add(many);
                    }
                }
            }
        });
        Thread transfer4 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account4) {
                    int many = 5;
                    System.out.println("Transfer 4: Holding account 4...");
                    try {
                        account4.deduct(many);
                        //emulation delay
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Transfer 4: Waiting for account 1...");
                    synchronized (account1) {
                        System.out.println("Transfer 4: Holding account 3 & 4...");
                        account1.add(many);
                    }
                }
            }
        });

        transfer1.start();
        transfer2.start();
        transfer3.start();
        transfer4.start();
    }

}



