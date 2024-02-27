package PasswordCracker;

public class CrackerRunnable implements Runnable{
    char start;
    String pass;

    public CrackerRunnable(char start, String pass) {
        this.start = start;
        this.pass = pass;
    }

    @Override
    public void run() {
        // from ch+"aaaaa..." until ch+"zzzzz..."
        // example: pass = cool, ch = j
        // this thread searches jaaa to jzzz
    }
}
