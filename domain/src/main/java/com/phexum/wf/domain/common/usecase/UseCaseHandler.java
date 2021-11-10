package com.phexum.wf.domain.common.usecase;

public interface UseCaseHandler<R, I extends UseCase> {

  R handle(I useCase);

}
