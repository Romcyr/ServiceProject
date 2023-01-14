package service.workshop.adminFunction;

import java.util.Scanner;

public interface AdminFunctionInterface {
    public final static Scanner scanner = new Scanner(System.in);

    String getAdminFunction();

    String getAdminFunctionCode();

    void AdminFunctionSupport();

}
