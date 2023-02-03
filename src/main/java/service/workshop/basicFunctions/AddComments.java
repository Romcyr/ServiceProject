package service.workshop.basicFunctions;

import jakarta.persistence.Id;
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
        this.dataAccessObjectService = new DataAccessObject<>();
    }

    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Car> dataAccessObjectCar;
    private DataAccessObject<Mechanic> dataAccessObjectMechanic;
    private DataAccessObject<Service> dataAccessObjectService;

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
        //// wyświetlanie listy serwisów
        List<Service> serviceLista = dataAccessObjectService.findAll(Service.class);
        serviceLista.forEach(System.out::println);

        System.out.println("Podaj id serwisu do którego masz uwagi");
        String idService = Function.scanner.nextLine();
        Long idContent = Long.parseLong(idService);


        Optional<Service> serviceOptional = dataAccessObjectService.find(Service.class, idContent);
        if (serviceOptional.isEmpty()) {
            System.err.println("Serwis nie istnieje, nie można dodać uwag");
            return;
        }

        System.out.println("Jakie masz uwagi na temat tego serwisu?");
        String Comment = Function.scanner.nextLine();



        List<Mechanic> mechanicList = dataAccessObjectMechanic.findAll(Mechanic.class);
        mechanicList.forEach(System.out::println);

        System.out.println("Podaj swój numer ID");

        String idMechanicString = Function.scanner.nextLine();
        Long idMechanic = Long.parseLong(idMechanicString);


        Optional<Mechanic> mechanicOptional = dataAccessObjectMechanic.find(Mechanic.class, idMechanic);
        if (mechanicOptional.isEmpty()) {
            System.err.println("Mechanik nie istnieje, nie można dodać uwag");
            return;
        }




       Comments comments = Comments.builder()
               .content(Comment)
               .mechanic(mechanicOptional.get())
               .service(serviceOptional.get())
               .build();





        dataAccessObjectComments.insert(comments);
        System.out.println("Dodano Komentarz");


    }
}

