package com.phexum.wf.domain.log.service;

import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.log.entity.PermissionLog;
import com.phexum.wf.domain.log.port.PermissionLogRepository;
import com.phexum.wf.domain.log.port.PermissionLoggingService;


@DomainComponent
public class PermissionLoggingServiceImpl extends CrudServiceImpl<PermissionLogRepository, PermissionLog, Long> implements PermissionLoggingService {

  public PermissionLoggingServiceImpl(PermissionLogRepository repository) {
    super(repository);
  }


}
