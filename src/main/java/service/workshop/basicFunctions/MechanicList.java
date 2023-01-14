package service.workshop.basicFunctions;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Mechanic;
import service.workshop.DataAccessObject;

import java.util.List;

public class MechanicList implements Function {
    private DataAccessObject<Mechanic> dataAccessObject;

    public MechanicList() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getFunction() {
        return "Lista Mechaników";
    }

    @Override
    public String getFunctionCode() {
        return "4";
    }

    @Override
    public void functionSupport() {
        List<Mechanic> mechanicList = dataAccessObject.findAll(Mechanic.class);
        mechanicList.forEach(System.out::println);

    }
}


