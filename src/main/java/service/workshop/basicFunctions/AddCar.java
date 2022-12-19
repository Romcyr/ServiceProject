package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.DataAccessObject;

public class AddCar implements Function {
    public AddCar() {

        this.dataAccessObject = new DataAccessObject<>();

    }

    private DataAccessObject<Car> dataAccessObject;


    @Override
    public String getFunction() {
        System.out.print("Dodaj Samochód: ");

        return "1";
    }

    @Override
    public void functionSupport() {

        System.out.println("Marka:");
        String mark = Function.scanner.nextLine();
        if (mark.matches("\\d+")) {
            System.out.println("To pole nie może zawierać cyfr!");
            System.out.println("Marka:");
            mark = Function.scanner.nextLine();
        } else if (mark.isEmpty()) {
            System.out.println("To pole nie może być puste!");
            System.out.println("Marka:");
            mark = Function.scanner.nextLine();
//        } else{
//            System.out.println("Marka:");
//            mark = Function.scanner.nextLine();
//        }


            System.out.println("Model:");
            String model = Function.scanner.nextLine();

            System.out.println("Nr rejestracyjny:");
            String registeryNumber = Function.scanner.nextLine();

            Car samochód = Car.builder()
                    .mark(mark)
                    .model(model)
                    .registeryNumber(registeryNumber)
                    .build();

            dataAccessObject.insert(samochód);


        }
    }
}

