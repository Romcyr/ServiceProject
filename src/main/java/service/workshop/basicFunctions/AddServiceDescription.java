package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;

import java.util.List;
import java.util.Optional;



public class AddServiceDescription implements Function {


    public AddServiceDescription() {

        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectCar = new DataAccessObject<>();


    }

    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Car> dataAccessObjectCar;






    @Override
    public String getFunction(){

        System.out.print("Dodaj serwis:    ");
        return "4";
    }

    @Override
    public void functionSupport()  {

        ///////////////// Upewnij się że pojazd istnieje
        List<Car> carList = dataAccessObjectCar.findAll(Car.class);
        carList.forEach(System.out::println);

        System.out.println("Podaj id serwisowanego pojzadu");
        String idString = Function.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);


        Optional<Car> carOptional = dataAccessObjectCar.find(Car.class, idPojazd);
        if (carOptional.isEmpty()){
            System.err.println("Samochód nie istnieje, nie można dodać serwisu");
            return;
        }
        //////// konstrukcja obiektu SerwisPojazdu
        System.out.println("Podaj opis serwisu");
        String description = Function.scanner.nextLine();


        System.out.println("Podaj imie serwisanta");
        String nameMechanikString = Function.scanner.nextLine();
        String name = nameMechanikString;



        Service carService = Service.builder()
                .nameMechanic(name)
                .car(carOptional.get())
                .description(description)
                .build();

        dataAccessObject.insert(carService);
        System.out.println("Dodano serwis");









    }


}
