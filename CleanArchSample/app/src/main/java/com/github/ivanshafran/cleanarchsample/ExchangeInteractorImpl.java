package com.github.ivanshafran.cleanarchsample;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ExchangeInteractorImpl implements ExchangeInteractor {

    private ExchangeRepository repository;

    public ExchangeInteractorImpl(final ExchangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public double getExchange(final double value) {
        if (value > 1000) {
            // Даём бонус при больших переводах
            return repository.getExchangeRate() * 1.01 * value;
        } else {
            return repository.getExchangeRate() * value;
        }
    }

    @Override
    public Single<Double> getExchangeSingle(final double value) {
        return repository
                .getExchangeSingle()
                .observeOn(Schedulers.computation())
                .map(aDouble -> {
                    if (value > 1000) {
                        // Даём бонус при больших переводах
                        return aDouble * 1.01 * value;
                    } else {
                        return aDouble * value;
                    }
                });
    }
}
