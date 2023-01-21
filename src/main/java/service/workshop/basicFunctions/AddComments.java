package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Comments;
import service.workshop.CheckPoint.Mechanic;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;

import java.util.List;
import java.util.Optional;

public class AddComments implements Function {


    public AddComments() {

        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectCar = new DataAccessObject<>();
        this.dataAccessObjectMechanic = new DataAccessObject<>();
        this.dataAccessObjectComments = new DataAccessObject<>();
    }

    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Car> dataAccessObjectCar;
    private DataAccessObject<Mechanic> dataAccessObjectMechanic;

    private DataAccessObject<Comments>dataAccessObjectComments;

    @Override
    public String getFunction() {
        return "Uwagi / Komentarz";
    }

    @Override
    public String getFunctionCode() {
        return "6";
    }

    @Override
    public void functionSupport() {
        //// wyświetlanie listy pojazdów
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

        System.out.println("Jakie masz uwagi na temat tego pojazdu?");
        String Comment = Function.scanner.nextLine();


//        System.out.println("Podaj imie serwisanta");
//        String nameMechanikString = Function.scanner.nextLine();
//        String name = nameMechanikString;

        List<Mechanic> mechanicList = dataAccessObjectMechanic.findAll(Mechanic.class);
        mechanicList.forEach(System.out::println);

        System.out.println("Podaj swój numer ID");
        String idMechanicString = Function.scanner.nextLine();
        Long idMechanic = Long.parseLong(idString);



       Comments comments = Comments.builder()
               .IdMechanic(String.valueOf(idMechanic))
               .IdCar(String.valueOf(idPojazd))
               .Comments(Comment)
               .build();



//            CarComment carComment = Comment.builder()
//                    .nameMechanic(name)
//                    .car(carOptional.get())
//                    .description(description)
//                    .build();

        dataAccessObjectComments.insert(comments);
        System.out.println("Dodano Komentarz");


    }
}

