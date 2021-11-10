package com.phexum.wf.domain.common.usecase;

import java.util.HashMap;
import java.util.Map;

public class UseCaseRegistry {


  public final static UseCaseRegistry Instance = new UseCaseRegistry();

  private final Map<Class<? extends UseCase>, UseCaseHandler<?, ? extends UseCase>> usecaseMap;
  private final Map<Class<? extends UseCase>, VoidUseCaseHandler<? extends UseCase>> voidUsecaseMap;

  private UseCaseRegistry() {
    this.usecaseMap = new HashMap<>();
    this.voidUsecaseMap = new HashMap<>();
  }


  public <R, I extends UseCase> void register(Class<I> usecase, UseCaseHandler<R, I> handler) {
    usecaseMap.put(usecase, handler);
  }

  public <I extends UseCase> void register(Class<I> usecase, VoidUseCaseHandler<I> handler) {
    voidUsecaseMap.put(usecase, handler);
  }

  public UseCaseHandler<?, ? extends UseCase> getUseCaseHandler(Class<? extends UseCase> usecase) {
    return usecaseMap.get(usecase);
  }

  public VoidUseCaseHandler<? extends UseCase> getVoidUseCaseHandler(Class<? extends UseCase> usecase) {
    return voidUsecaseMap.get(usecase);
  }

}
