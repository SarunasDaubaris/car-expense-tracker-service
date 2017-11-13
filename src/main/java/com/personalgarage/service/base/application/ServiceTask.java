package com.personalgarage.service.base.application;

import com.personalgarage.service.base.messages.TaskRequest;
import com.personalgarage.service.base.messages.TaskResponse;

import javax.transaction.Transactional;

public abstract class ServiceTask<Req extends TaskRequest, Res extends TaskResponse> {

    @Transactional(rollbackOn = Throwable.class)
    public Res processInTransaction(Req request) {
        // transactional stuff
        // try-catch, etc....
        return processDirectly(request);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = Throwable.class)
    public Res processInNewTransaction(Req request) {
        // transactional stuff
        // try-catch, etc....
        return processDirectly(request);
    }

    public abstract Res processDirectly(Req request);
}