package service.workshop.function;

import java.util.Scanner;

public interface Function {
    public static final Scanner scanner = new Scanner(System.in);

    String getFunction();
    void functionSupport();
}
