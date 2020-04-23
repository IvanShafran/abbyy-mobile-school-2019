package com.github.ivanshafran.cleanarchsample;

import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ExchangeRepositoryImpl implements ExchangeRepository {

    @Override
    public double getExchangeRate() {
        // Если есть кеш и кеш не старый, то берем из кеша
        // Иначе загружаем из интернета
        // и тп
        return 60;
    }

    @Override
    public Single<Double> getExchangeSingle() {
        return Single
                .fromCallable(new Callable<Double>() {
                    @Override
                    public Double call() throws Exception {
                        Thread.sleep(1000);
                        return 60.0;
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
