package com.phexum.wf.infrastructure.common;

import com.phexum.wf.domain.common.usecase.UseCase;
import com.phexum.wf.domain.common.usecase.UseCaseRegistry;
import com.phexum.wf.domain.common.usecase.VoidUseCaseHandler;

public class BaseController {

    public <T extends UseCase> void handle(T usecase) {
        VoidUseCaseHandler handler = UseCaseRegistry.Instance.getVoidUseCaseHandler(usecase.getClass());
        handler.handle(usecase);
    }
}
