package com.github.ivanshafran.cleanarchsample;

import io.reactivex.Single;

public interface ExchangeInteractor {

    public double getExchange(double value);

    public Single<Double> getExchangeSingle(final double value);

}
