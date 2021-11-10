package com.phexum.wf.domain.common.usecase;

public class ObservableUseCaseHandler {

  public <R, I extends UseCase> void register(Class<I> usecase, UseCaseHandler<R, I> handler) {
    UseCaseRegistry.Instance.register(usecase, handler);
  }

  public <I extends UseCase> void register(Class<I> usecase, VoidUseCaseHandler<I> handler) {
    UseCaseRegistry.Instance.register(usecase, handler);
  }

}
