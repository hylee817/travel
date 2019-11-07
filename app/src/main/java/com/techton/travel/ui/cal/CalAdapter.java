package com.techton.travel.ui.cal;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.techton.travel.R;

import java.util.ArrayList;
import java.util.Collections;


////////////////////////////////어댑터 코드//////////////////////////////////////
public class CalAdapter extends RecyclerView.Adapter<ViewHolder>
            implements CalItemTouchHelperCallback.ItemTouchHelperAdapter {
    private ArrayList<CalItem> items;

    /*/drag & drop
    public interface OnStartDragListener {
        void onStartDrag(ViewHolder holder);
    }
    private final Context context;
    private final OnStartDragListener startDragListener;
    public CalAdapter(Context c, OnStartDragListener o){
        context = c;
        startDragListener = o;
    }
    */
    private ItemTouchHelper touchHelper;
    public void passTouchHelper(ItemTouchHelper th) {
        touchHelper = th;
    }

    //생성자
    CalAdapter(ArrayList<CalItem> items){
        this.items = items;
    }
    //추가적인 method
    public void addItem(CalItem item){
        items.add(item);
    }
    public void deleteItem(int position){ //아이템 삭제
        items.remove(position);
        notifyItemRemoved(position);
    }
    public void setItems(ArrayList<CalItem> items){
        this.items = items;
    }
    public CalItem getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, CalItem item){
        items.set(position, item);
    }


    //drag & drop 코드
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if(fromPosition < toPosition){      //drop 시점에만 말고 drag할때도 계속 움직이도록
            for (int i=fromPosition;i<toPosition;i++)
                Collections.swap(items, i,i+1);
        } else{
            for (int i=fromPosition;i>toPosition;i--){
                Collections.swap(items,i,i-1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    //swipe delete 코드
    @Override
    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }


    //아래의 뷰홀더(class)객체를 어떻게 쓸것인지
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//뷰홀더 객체가 (새로) 만들어질 때
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.cal_item,parent,false); //item infl
        ViewHolder vh = new ViewHolder(itemView); //attach to holder

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {//뷰홀더 객체가 재사용 될때
        CalItem item = items.get(position);
        holder.setItem(item);

        holder.imageButton_move.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    touchHelper.startDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}







////////////////////뷰홀더 클래스 /////////////////////////
class ViewHolder extends RecyclerView.ViewHolder {
    TextView    textView_order;
    TextView    textView_name;
    TextView    textView_address;
    ImageButton imageButton_move;

    //생성자: 뷰홀더가 처음 만들어질 때 호출 (뷰 객체가 전달)
    public ViewHolder(View itemView) {
        super(itemView);

        textView_order      = itemView.findViewById(R.id.textView_order);   //메소드에서 참조할 수 있도록 변수에 할당
        textView_name       = itemView.findViewById(R.id.textView_name);
        textView_address    = itemView.findViewById(R.id.textView_location);
        imageButton_move    = itemView.findViewById(R.id.imageButton_move);

            /*    아이템 재배치할때 누르는 버튼
            imageButton_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }); */
    }

    //뷰홀더가 재사용될때 호출
    public void setItem(CalItem item) {
        textView_name.setText(item.getName());
        textView_address.setText(item.getAddress());
        textView_order.setText(item.getOrder());
    }
}
