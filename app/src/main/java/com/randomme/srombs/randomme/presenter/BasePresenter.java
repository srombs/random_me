package com.randomme.srombs.randomme.presenter;

/**
 * Created by srombs on 5/11/17.
 */

public abstract class BasePresenter<T extends BaseView> {

    public abstract void onAttach(T view);
    public abstract void onDeatch();

}
