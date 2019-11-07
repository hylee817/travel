package com.techton.travel.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.techton.travel.R;
import com.techton.travel.ui.home.HomeFragment;
import com.techton.travel.ui.home.HomeViewModel;
import com.techton.travel.ui.result.ResultFragment;

public class SearchFragment  extends Fragment {

    private SearchViewModel searchViewModel;
    private EditText editText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        ImageButton backButton = root.findViewById(R.id.search_back_btn);
        backButton.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.container);
                getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        });

        editText = (EditText) root.findViewById(R.id.edittext_search_region);
        editText.requestFocus();

        //키보드 보이게 하는 부분
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

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
                        //키보드 보이게 하는 부분
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);

                        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                        navController.navigate(R.id.action_navigation_search_to_navigation_result);
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
