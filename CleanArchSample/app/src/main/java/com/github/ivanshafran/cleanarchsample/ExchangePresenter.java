package com.github.ivanshafran.cleanarchsample;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class ExchangePresenter {

    private final ExchangeView view;
    private final ExchangeInteractor interactor;
    private Disposable disposable;

    public ExchangePresenter(
            final ExchangeView exchangeView,
            final ExchangeInteractor interactor
    ) {
        this.view = exchangeView;
        this.interactor = interactor;
    }

    public void onButtonClick(String text) {
        try {
            double value = Double.parseDouble(text);
            disposable = interactor
                    .getExchangeSingle(value)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> view.showProgress())
                    .doFinally(view::hideProgress)
                    .subscribe(aDouble -> view.showResult(String.valueOf(aDouble)));
        } catch (NumberFormatException e) {
            view.showError("Not a number");
        }
    }

    public void onExit() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
