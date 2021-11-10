package com.phexum.wf.domain.firm.service;

import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.firm.port.FirmRepository;
import com.phexum.wf.domain.firm.port.FirmService;


@DomainComponent
public class FirmServiceImpl extends CrudServiceImpl<FirmRepository, Firm, Long> implements FirmService {

    public FirmServiceImpl(FirmRepository repository) {
        super(repository);
    }


}
