package com.techton.travel.ui.cal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Calendar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}