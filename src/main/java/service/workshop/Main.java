package service.workshop;
import service.workshop.basicFunctions.*;
import java.util.ArrayList;
import java.util.List;
import static service.workshop.basicFunctions.Function.scanner;

public class Main {

    public static void main(String[] args)  {
        String end = "";
        System.err.println("__________________________________________________________");
        System.err.println("Powered by RC for Plichta Castrol Serwis");
        System.err.println("__________________________________________________________");
        System.out.println("Witaj w programie do zarządania czynnościami, wybierz z poniżej listy opcję która cię interesuje");
        while (!end.equals("koniec")) {

            List<Function> functionList = new ArrayList<>( //Lista dostępnych opcji
                    List.of(

                            new AddMechanic(),
                            new AddCar(),
                            new CarList(),
                            new AddServiceDescription()
                    )
            );


            System.out.println("__________________________________________________________");
            System.out.println("Dostępne funkcje");
            functionList.forEach(function -> System.out.println(function.getFunction()));// Lista dostępnych funkcji programu
            System.out.println("__________________________________________________________");


            System.out.println("Co wybierasz?");
            String function = scanner.nextLine();
            if (function.isEmpty()) {
                System.out.println("Nie dokonałeś żadnego wyboru");
                System.out.println("Co wybierasz?");
                function = scanner.nextLine();

            }
            for (Function functionAvailable : functionList) {
                if (functionAvailable.getFunction().equalsIgnoreCase(String.valueOf(function))) {
                    functionAvailable.functionSupport();


                }
            }

            end = scanner.nextLine();
        }

    }
}
