package com.github.ivanshafran.cleanarchsample;

import io.reactivex.Single;

public interface ExchangeRepository {

    public double getExchangeRate();

    public Single<Double> getExchangeSingle();

}
