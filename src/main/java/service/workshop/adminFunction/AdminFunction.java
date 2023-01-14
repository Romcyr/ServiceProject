package service.workshop.adminFunction;

import service.workshop.DataAccessObject;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class AdminFunction {

    public AdminFunction() {

    }
    List<AdminFunctionInterface> adminFunctionList = new ArrayList<>(
            List.of(
                    new ServiceListByCarId(),
                    new ServiceListByMechanicId()

            )
    );

}
