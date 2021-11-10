package com.phexum.wf.domain.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {

  void handle(I useCase);

}
