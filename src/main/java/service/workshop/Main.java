package service.workshop;
import service.workshop.adminFunction.AdminFunction;
import service.workshop.adminFunction.AdminFunctionInterface;
import service.workshop.adminFunction.ServiceListByCarId;
import service.workshop.adminFunction.ServiceListByMechanicId;
import service.workshop.basicFunctions.*;
import java.util.ArrayList;
import java.util.List;
import static service.workshop.basicFunctions.Function.scanner;

public class Main {

    public static void main(String[] args) {

        System.err.println("__________________________________________________________");
        System.err.println("Powered by RC for Plichta Castrol Serwis");
        System.err.println("__________________________________________________________");
        System.out.println("Witaj w programie do zarządania czynnościami, wybierz z poniżej listy opcję która cię interesuje");

        String function = "";
        AdminFunction admin = new AdminFunction();
        admin.setPassword(admin.getPassword());

        while (!function.equals("koniec")) {

            List<Function> functionList = new ArrayList<>( //Lista dostępnych opcji
                    List.of(

                            new AddMechanic(),
                            new AddCar(),
                            new AddServiceDescription(),
                            new MechanicList(),
                            new CarList(),
                            new AddComments()
//                            new ServiceListByCarId(),
//                            new ServiceListByMechanicId()


                    )
            );
            List<AdminFunctionInterface> adminFunctionList = new ArrayList<>(
                    List.of(
                            new ServiceListByCarId(),
                            new ServiceListByMechanicId()

                    )
            );


            System.out.println("__________________________________________________________");
            System.out.println("Dostępne funkcje");
            // Dodaj mechanika          -> 1
            functionList.forEach(fn -> System.out.printf("%-20.20s -> %-50.50s\n", fn.getFunction(), fn.getFunctionCode()));// Lista dostępnych funkcji programu
            System.out.println("__________________________________________________________");
            adminFunctionList.forEach(fn -> System.out.printf("%-20.20s -> %-50.50s\n", fn.getAdminFunction(), fn.getAdminFunctionCode()));//Lista dostępnych funkcji programu dla Admina
            System.out.println("__________________________________________________________");
            System.out.println("Co wybierasz?");
            function = scanner.nextLine();
            if ((function.equals("8") || function.equals("9"))) {
                System.out.println("Podaj hasło administratora");
                String enterPasswordUser = scanner.nextLine();
                while (!admin.getPassword().equals(enterPasswordUser)) {
                    System.out.println("Niepoprawne hasło, spróbuj ponownie");
                    enterPasswordUser = scanner.nextLine();
                }
            }

            if (function.isEmpty()) {
                System.out.println("Nie dokonałeś żadnego wyboru");
                System.out.println("Co wybierasz?");
                function = scanner.nextLine();
            }
            for (Function functionAvailable : functionList) {
                if (functionAvailable.getFunctionCode().equalsIgnoreCase(String.valueOf(function))) {
                    functionAvailable.functionSupport();
                }
            }
            for (AdminFunctionInterface functionAvailable : adminFunctionList) {
                if (functionAvailable.getAdminFunctionCode().equalsIgnoreCase(String.valueOf(function))) {
                    functionAvailable.AdminFunctionSupport();
                }



            }
        }
    }
}


