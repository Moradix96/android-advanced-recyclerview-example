package ir.samiantec.advancedrecyclerviewexample.Model;

import androidx.annotation.NonNull;

public class NumPair {
    private final int a, b;

    public NumPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @NonNull
    @Override
    public String toString() {
        return "NumPair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
