package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Mechanic;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;
import java.util.List;
import java.util.Optional;



public class AddServiceDescription implements Function {


    public AddServiceDescription() {

        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectCar = new DataAccessObject<>();
        this.dataAccessObjectMechanic = new DataAccessObject<>();


    }

    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Car> dataAccessObjectCar;

    private DataAccessObject<Mechanic> dataAccessObjectMechanic;

    @Override
    public String getFunction(){
        return "Dodaj serwis";
    }

    @Override
    public String getFunctionCode(){
        return "3";
    }

    @Override
    public void functionSupport()  {

        //Wyświetlanie listy dodanych pojazdów
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
        //Wyświetlanie listy mechaników aby podać właściwe ID
        List<Mechanic> mechanicList = dataAccessObjectMechanic.findAll(Mechanic.class);
        mechanicList.forEach(System.out::println);

        System.out.println("Podaj swój numer ID");
        String idMechanicString = Function.scanner.nextLine();
        Long idMechanic = Long.parseLong(idString);


        System.out.println("Podaj opis wykonanego serwisu");
        String description = Function.scanner.nextLine();


//        System.out.println("Podaj imie serwisanta");
//        String nameMechanikString = Function.scanner.nextLine();
//        String name = nameMechanikString;





        Service carService = Service.builder()
                .IdMechanic(idMechanicString)
                .car(carOptional.get())
                .description(description)
                .build();

        dataAccessObject.insert(carService);
        System.out.println("Dodano serwis");









    }


}
