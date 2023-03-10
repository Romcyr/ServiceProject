package service.workshop.basicFunctions;
import service.workshop.CheckPoint.Car;
import service.workshop.DataAccessObject;

import java.time.LocalDateTime;

public class AddCar implements Function {
    public AddCar() {

        this.dataAccessObject = new DataAccessObject<>();

    }

    private DataAccessObject<Car> dataAccessObject;


    @Override
    public String getFunction() {
        return "Dodaj samochód";
    }

    @Override
    public String getFunctionCode() {
        return "2";
    }

    @Override
    public void functionSupport() {

        System.out.println("Marka:");
        String mark = Function.scanner.nextLine();

        while (true) {
            if (mark.matches("\\d+")) {
                System.out.println("To pole nie może zawierać cyfr!");
            } else if (mark.isEmpty()) {
                System.out.println("To pole nie może być puste!");
            } else {
                break;
            }
            System.out.println("Podaj Markę:");
            mark = Function.scanner.nextLine();
        }

        System.out.println("Model:");
        String model = Function.scanner.nextLine();

        while (true) {
            if (model.isEmpty()) {
                System.out.println("To pole nie może być puste!");
            } else {
                break;
            }
            System.out.println("Podaj Model:");
            model = Function.scanner.nextLine();
        }

            System.out.println("Nr rejestracyjny:");
            String registeryNumber = Function.scanner.nextLine();
        while (true) {
            if (registeryNumber.isEmpty()) {
                System.out.println("To pole nie może być puste!");
            }else {
                break;
            }
            System.out.println("Podaj numer rejestracyjny:");
            registeryNumber = Function.scanner.nextLine();
        }
        System.out.println("Usterki wskazane przed rozpoczęciem serwisu");
        String reportedDefects = Function.scanner.nextLine();



            Car samochód = Car.builder()
                    .mark(mark)
                    .model(model)
                    .registeryNumber(registeryNumber)
                    .reportedDefects(reportedDefects)
                    .timeAddCarToService(LocalDateTime.now())
                    .build();

            dataAccessObject.insert(samochód);
        System.out.println("Dodano samochód");


        }


}



