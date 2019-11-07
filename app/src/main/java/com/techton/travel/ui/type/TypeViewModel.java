package com.techton.travel.ui.type;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TypeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TypeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Search fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}