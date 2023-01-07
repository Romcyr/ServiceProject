package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;

import java.util.List;
import java.util.Optional;

public class CarComments implements Function {


    public CarComments() {

        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectCar = new DataAccessObject<>();
    }

    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Car> dataAccessObjectCar;

    @Override
    public String getFunction() {
        return "Uwagi";
    }

    @Override
    public String getFunctionCode() {
        return "5";
    }

    @Override
    public void functionSupport() {
        ///////////////// Upewnij się że pojazd istnieje
        List<Car> carList = dataAccessObjectCar.findAll(Car.class);
        carList.forEach(System.out::println);

        System.out.println("Podaj id pojzadu do którego masz uwagi");
        String idString = Function.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);


        Optional<Car> carOptional = dataAccessObjectCar.find(Car.class, idPojazd);
        if (carOptional.isEmpty()) {
            System.err.println("Samochód nie istnieje, nie można dodać uwag");
            return;
        }
        //////// konstrukcja obiektu SerwisPojazdu
        System.out.println("Jakie masz uwagi na temat tego pojazdu?");
        String comment = Function.scanner.nextLine();


        System.out.println("Podaj imie serwisanta");
        String nameMechanikString = Function.scanner.nextLine();
        String name = nameMechanikString;

        Service carComments = Service.builder()
                .comments(comment)
                .build();


//            CarComment carComment = Comment.builder()
//                    .nameMechanic(name)
//                    .car(carOptional.get())
//                    .description(description)
//                    .build();

        dataAccessObject.insert(carComments);
        System.out.println("Dodano Komentarz");


    }
}

