package service.workshop;

import service.workshop.basicFunctions.AddCar;
import service.workshop.basicFunctions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.err.println("__________________________________________________________");
        System.err.println("Powered by RC for Plichta Castrol Serwis");
        System.err.println("__________________________________________________________");
        System.out.println("Witaj w programie do zarządania czynnościami, wybierz z poniżej listy opcję która cię interesuje");

        List <Function> functionList = new ArrayList<>(
                List.of(

                        new AddCar()
                )
        );



        System.out.println("__________________________________________________________");
        System.out.println("Dostępne funkcje");
        functionList.forEach(function -> System.out.println(function.getFunction()));
        System.out.println("__________________________________________________________");


        System.out.println("Co wybierasz?");
        String function = Function.scanner.nextLine();
        if (function.isEmpty()){
            System.out.println("Nie dokonałeś żadnego wyboru");
            System.out.println("Co wybierasz?");
            function = Function.scanner.nextLine();
        }


                for (Function functionAvailable : functionList) {
                    if (functionAvailable.getFunction().equalsIgnoreCase(String.valueOf(function))) {
                        functionAvailable.functionSupport();
                    }
                }



    }
}
