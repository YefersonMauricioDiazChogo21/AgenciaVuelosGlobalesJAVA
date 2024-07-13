package Employee.application;

import Employee.domain.Employee;
import Employee.domain.ServiceEmployee;


public class CreateEmployee {

   private ServiceEmployee serviceEmployee;

public CreateEmployee(ServiceEmployee serviceEmployee) {
    this.serviceEmployee = serviceEmployee;
}
   
 public void execute(Employee employee){
        serviceEmployee.CreateEmployee(employee);
    }

}
