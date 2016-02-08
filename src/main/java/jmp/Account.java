package jmp;


public class Account {
    private int count;

    public Account(int count) {
        this.count = count;
    }

    public void deduct(int i) {
        count = count - i;
    }

    public void add(int i) {
        count = count + i;
    }

}
