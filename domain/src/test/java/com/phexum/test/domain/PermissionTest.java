package com.phexum.test.domain;

import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.permission.Permission;
import com.phexum.wf.domain.permission.PermissionChecker;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PermissionTest extends TestCase {
  public PermissionTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(PermissionTest.class);
  }

  public void testDepartmentPermission() {

    Department dep = new Department();

    dep.addPermission(Permission.ALLOWED_APARTMENT_1);
    dep.addPermission(Permission.ALLOWED_FLOOR_1);


    assertTrue(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_APARTMENT_1));
    assertTrue(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_FLOOR_1));

    assertTrue(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_1));

    assertFalse(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_APARTMENT_2));
    assertFalse(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_FLOOR_2));
    assertFalse(PermissionChecker.isAllowedAny(dep, Permission.ALLOWED_APARTMENT_2, Permission.ALLOWED_FLOOR_2));


    assertTrue(PermissionChecker.isAllowedAll(dep, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_1));
    assertFalse(PermissionChecker.isAllowedAll(dep, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_2));

  }


  public void testEmployeePermission() {

    Employee e = new Employee();

    e.addPermission(Permission.ALLOWED_APARTMENT_1);
    e.addPermission(Permission.ALLOWED_FLOOR_1);


    assertTrue(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_APARTMENT_1));
    assertTrue(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_FLOOR_1));

    assertTrue(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_1));

    assertFalse(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_APARTMENT_2));
    assertFalse(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_FLOOR_2));
    assertFalse(PermissionChecker.isAllowedAny(e, Permission.ALLOWED_APARTMENT_2, Permission.ALLOWED_FLOOR_2));


    assertTrue(PermissionChecker.isAllowedAll(e, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_1));
    assertFalse(PermissionChecker.isAllowedAll(e, Permission.ALLOWED_APARTMENT_1, Permission.ALLOWED_FLOOR_2));

  }

}
