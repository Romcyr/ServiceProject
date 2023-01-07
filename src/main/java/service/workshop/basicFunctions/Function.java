package service.workshop.basicFunctions;

import java.sql.SQLException;
import java.util.Scanner;

public interface Function {
    public static final Scanner scanner = new Scanner(System.in);

    String getFunction();
    String getFunctionCode();
    void functionSupport();

}
