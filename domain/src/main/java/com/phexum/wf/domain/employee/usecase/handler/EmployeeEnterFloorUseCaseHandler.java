package com.phexum.wf.domain.employee.usecase.handler;

import java.util.Optional;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.wf.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.employee.port.EmployeeService;
import com.phexum.wf.domain.employee.usecase.EmployeeFloorEnter;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.floor.port.FloorService;
import com.phexum.wf.domain.log.entity.PermissionLog;
import com.phexum.wf.domain.log.port.PermissionLoggingService;
import com.phexum.wf.domain.permission.PermissionChecker;
import com.phexum.wf.domain.permission.PermissionRequiredException;

@DomainComponent
public class EmployeeEnterFloorUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<EmployeeFloorEnter> {

    private final PermissionLoggingService logService;
    private final EmployeeService employeeService;
    private final FloorService floorService;

    public EmployeeEnterFloorUseCaseHandler(PermissionLoggingService logService, EmployeeService employeeService, FloorService floorService) {
        this.logService = logService;
        this.employeeService = employeeService;
        this.floorService = floorService;
        register(EmployeeFloorEnter.class,this);

    }

    private boolean check(Department department, Floor floor) {
        return PermissionChecker.isAllowedAny(department, floor.getEntrancePermissions());
    }

    private boolean check(Employee employee, Floor floor) {
        return PermissionChecker.isAllowedAny(employee, floor.getEntrancePermissions());
    }

    @Override
    public void handle(EmployeeFloorEnter usecase) {
        Optional<Floor> floorOp = floorService.findById(usecase.getFloor().getId());
        Optional<Employee> employeeOp = employeeService.findById(usecase.getEmployee().getId());

        Floor floor = floorOp.orElseThrow(() -> new RuntimeException("Floor not found"));
        Employee employee = employeeOp.orElseThrow(() -> new RuntimeException("Employee not found"));


        if (!check(employee, floor) && !check(employee.getDepartment(), floor)) {
            String message = "Employee [" + employee.getId() + ":" + employee.getName() + "] has no permission to enter floor [" + floor.getId() + ":" + floor.getLevel() + "]";

            logService.create(new PermissionLog(message));

            throw new PermissionRequiredException(message);
        }

        logService.create(new PermissionLog("Employee [" + employee.getId() + ":" + employee.getName() + "] entered successfully to floor [" + floor.getId() + ":" + floor.getLevel() + "]"));
    }

}
