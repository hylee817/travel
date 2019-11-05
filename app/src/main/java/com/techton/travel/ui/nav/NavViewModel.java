package com.techton.travel.ui.nav;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NavViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Navi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}