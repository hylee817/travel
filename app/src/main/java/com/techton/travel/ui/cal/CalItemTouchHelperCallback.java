package com.techton.travel.ui.cal;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;



public class CalItemTouchHelperCallback extends ItemTouchHelper.Callback {
    //인터페이스 정의
    public interface ItemTouchHelperAdapter {
        void onItemMove(int fromPosition, int toPosition); //for drag & drop
        void onItemDismiss(int position); //for swipe deletion
    }
    //변수 선언
    private final ItemTouchHelperAdapter mAdapter;
    //생성자로 CalFragment의 어댑터 받아옴
    public CalItemTouchHelperCallback(ItemTouchHelperAdapter adapter) {
        mAdapter = adapter;
    }

    //callBack의 필수 함수들
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags); //swipeFlags -> 0 : swipe 비활성화
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }


}
