package service.workshop.function;

import service.workshop.CheckPoint.Car;

public class AddCar implements Function {

    @Override
    public String getFunction() {
        return "Dodaj samochód";
    }

    @Override
    public void functionSupport() {
        System.out.println("Marka");›
        String mark = Function.scanner.nextLine();

        System.out.println("Model");
        String model = Function.scanner.nextLine();

        System.out.println("Nr rejestracyjny");
        String registeryNumber = Function.scanner.nextLine();

        Car samochód = Car.builder()
                .mark(mark)
                .model(model)
                .registeryNumber(registeryNumber)
                .build();
›
    }
}
