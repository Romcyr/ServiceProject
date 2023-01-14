package service.workshop.adminFunction;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Mechanic;
import service.workshop.DataAccessObject;

import java.util.List;

public class ServiceListByMechanicId implements AdminFunctionInterface {

    public ServiceListByMechanicId(){
        this.dataAccessObject = new DataAccessObject<>();

    }
    private DataAccessObject<Mechanic> dataAccessObject;

    @Override
    public String getAdminFunction() {
        return "Historia serwisów po Id Mechanika";
    }

    @Override
    public String getAdminFunctionCode() {
        return "]";
    }

    @Override
    public void AdminFunctionSupport() {
        List<Mechanic> ListByMechanicId = dataAccessObject.findAll(Mechanic.class);
        ListByMechanicId.forEach(System.out::println);

    }
}
