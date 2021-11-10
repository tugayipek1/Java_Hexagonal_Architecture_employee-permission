package com.phexum.wf.domain.permission;

public class PermissionRequiredException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public PermissionRequiredException(String message) {
    super(message);
  }
}
