package com.techton.travel.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.techton.travel.R;
import com.techton.travel.ui.home.HomeFragment;
import com.techton.travel.ui.home.HomeViewModel;

public class SearchFragment  extends Fragment {

    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        ImageButton searchButton = root.findViewById(R.id.search_back_btn);
        searchButton.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.container);
                getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        });

        EditText editText = root.findViewById(R.id.edittext_search_region);editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            // TODO : keypad 에서 enter 실행시 Listen하고 동작할 액션을 작성
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                // 텍스트 내용을 가져온다.
                String searchData = textView.getText().toString();

                // 텍스트 내용이 비어있다면...
                if (searchData.isEmpty()) {

                    // 토스트 메세지를 띄우고, 창 내용을 비운다
                    Toast.makeText(getActivity(), "검색어를 입력해주세요", Toast.LENGTH_SHORT).show();
                    textView.clearFocus();
                    textView.setFocusable(false);
                    textView.setFocusableInTouchMode(true);
                    textView.setFocusable(true);
                    return true;
                }

                // 텍스트 내용이 비어있지않다면
                switch (i) {
                    // Search 버튼일경우
                    case EditorInfo.IME_ACTION_SEARCH:
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,new SearchFragment()).addToBackStack(null).commit();
                        break;

                    // Enter 버튼일경우
                    default:
                        return false;
                }
                return true;

            }

        });

        return root;
    }
}
