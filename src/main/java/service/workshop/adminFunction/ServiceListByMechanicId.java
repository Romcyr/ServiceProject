package service.workshop.adminFunction;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Mechanic;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;

import java.util.List;

public class ServiceListByMechanicId implements AdminFunctionInterface {

    public ServiceListByMechanicId(){
        this.dataAccessObject = new DataAccessObject<>();

    }
    private DataAccessObject<Mechanic> dataAccessObject;

    @Override
    public String getAdminFunction() {
        return "Historia Id Mechanika";
    }

    @Override
    public String getAdminFunctionCode() {
        return "9";
    }

    @Override
    public void AdminFunctionSupport() {
        List<Mechanic> listService = dataAccessObject.findAll(Mechanic.class);
       listService.forEach(System.out::println);

    }
}
