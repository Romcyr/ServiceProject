package service.workshop;

import service.workshop.CheckPoint.Service;
import service.workshop.basicFunctions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.err.println("__________________________________________________________");
        System.err.println("Powered by RC for Plichta Castrol Serwis");
        System.err.println("__________________________________________________________");
        System.out.println("Witaj w programie do zarządania czynnościami, wybierz z poniżej listy opcję która cię interesuje");

        List <Function> functionList = new ArrayList<>( //Lista dostępnych opcji
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
