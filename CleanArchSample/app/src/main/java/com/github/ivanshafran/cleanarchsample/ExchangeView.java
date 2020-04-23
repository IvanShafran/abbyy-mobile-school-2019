package com.github.ivanshafran.cleanarchsample;

public interface ExchangeView {

    void showProgress();

    void hideProgress();

    void showResult(String result);

    void showError(String result);
}
