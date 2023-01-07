package service.workshop.basicFunctions;
import service.workshop.CheckPoint.Car;
import service.workshop.DataAccessObject;
import java.util.List;

public class CarList implements Function{
    private DataAccessObject<Car> dataAccessObject;

    public CarList() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getFunction() {
        return "Lista Samochodów";
    }

    @Override
    public String getFunctionCode() {
        return "3";
    }

    @Override
    public void functionSupport() {
        List<Car> service = dataAccessObject.findAll(Car.class);
        service.forEach(System.out::println);

    }
}
