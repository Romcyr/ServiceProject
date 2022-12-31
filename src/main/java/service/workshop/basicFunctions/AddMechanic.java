package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Mechanic;
import service.workshop.DataAccessObject;

public class AddMechanic implements Function{

    public AddMechanic() {

        this.dataAccessObject = new DataAccessObject<>();

    }

    private DataAccessObject<Mechanic> dataAccessObject;


    @Override
    public String getFunction(){
        System.out.print("Dodaj Mechanika: ");

        return "1";
    }

    @Override
    public void functionSupport(){
        System.out.println("Podaj imie");
        String name = Function.scanner.nextLine();


        Mechanic mechanic = Mechanic.builder()
                .name(name)
                .build();


        dataAccessObject.insert(mechanic);
        System.out.println("Dodano mechanika");

    }
}
