package com.phexum.wf.domain.permission;

import java.util.List;
import java.util.stream.Stream;
import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.employee.entity.Employee;

public class PermissionChecker {


  public static boolean isAllowedAny(Employee employee, Permission... permissions) {
    return Stream.of(permissions).anyMatch(permission -> employee.getPermissions().contains(permission));
  }

  public static boolean isAllowedAny(Employee employee, List<Permission> permissions) {
    return isAllowedAny(employee, permissions.toArray(new Permission[0]));
  }

  public static boolean isAllowedAll(Employee employee, Permission... permissions) {
    return Stream.of(permissions).allMatch(permission -> employee.getPermissions().contains(permission));
  }

  public static boolean isAllowedAny(Department department, Permission... permissions) {
    return Stream.of(permissions).anyMatch(permission -> department.getPermissions().contains(permission));
  }

  public static boolean isAllowedAll(Department department, Permission... permissions) {
    return Stream.of(permissions).allMatch(permission -> department.getPermissions().contains(permission));
  }

  public static boolean isAllowedAny(Department department, List<Permission> permissions) {
    return isAllowedAny(department, permissions.toArray(new Permission[0]));
  }

}
