package com.phexum.wf.domain.employee.usecase.handler;

import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.apartment.port.ApartmentService;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.wf.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.employee.port.EmployeeService;
import com.phexum.wf.domain.employee.usecase.EmployeeApartmentEnter;
import com.phexum.wf.domain.log.entity.PermissionLog;
import com.phexum.wf.domain.log.port.PermissionLoggingService;
import com.phexum.wf.domain.permission.PermissionChecker;
import com.phexum.wf.domain.permission.PermissionRequiredException;

import java.util.Optional;

@DomainComponent
public class EmployeeEnterApartmentUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<EmployeeApartmentEnter> {

    private final PermissionLoggingService logService;
    private final EmployeeService employeeService;
    private final ApartmentService apartmentService;

    public EmployeeEnterApartmentUseCaseHandler(PermissionLoggingService logService, EmployeeService employeeService, ApartmentService apartmentService) {
        this.logService = logService;
        this.employeeService = employeeService;
        this.apartmentService = apartmentService;
        register(EmployeeApartmentEnter.class,this);
    }

    @Override
    public void handle(EmployeeApartmentEnter usecase) {
        Optional<Apartment> apartmentOp = apartmentService.findById(usecase.getApartment().getId());
        Optional<Employee> employeeOp = employeeService.findById(usecase.getEmployee().getId());

        Apartment apartment = apartmentOp.orElseThrow(() -> new RuntimeException("Apartment not found"));
        Employee employee = employeeOp.orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!check(employee, apartment) && !check(employee.getDepartment(), apartment)) {
            String message = "Employee [" + employee.getId() + ":" + employee.getName() + "] has no permission to enter floor [" + apartment.getId() + ":" + apartment.getNo() + "]";

            logService.create(new PermissionLog(message));

            throw new PermissionRequiredException(message);
        }

        logService.create(new PermissionLog("Employee [" + employee.getId() + ":" + employee.getName() + "] entered successfully to floor [" + apartment.getId() + ":" + apartment.getNo() + "]"));
    }


    private boolean check(Department department, Apartment apartment) {
        return PermissionChecker.isAllowedAny(department, apartment.getEntrancePermissions());
    }

    private boolean check(Employee employee, Apartment apartment) {
        return PermissionChecker.isAllowedAny(employee, apartment.getEntrancePermissions());
    }

}
