package service.workshop.adminFunction;

import service.workshop.CheckPoint.Car;
import service.workshop.CheckPoint.Service;
import service.workshop.DataAccessObject;

import java.util.List;

public class ServiceListByCarId implements AdminFunctionInterface {

    public ServiceListByCarId(){
        this.dataAccessObject = new DataAccessObject<>();

    }
    private DataAccessObject<Car> dataAccessObject;

    @Override
    public String getAdminFunction() {
        return "Historia Id Samochodu";
    }

    @Override
    public String getAdminFunctionCode() {
        return "8";
    }

    @Override
    public void AdminFunctionSupport() {
        List<Car> listByCarId = dataAccessObject.findAll(Car.class);
        listByCarId.forEach(System.out::println);

    }
}
