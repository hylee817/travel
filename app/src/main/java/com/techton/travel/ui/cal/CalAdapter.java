package com.techton.travel.ui.cal;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techton.travel.R;

import java.util.ArrayList;

////////////////////////////////어댑터 코드//////////////////////////////////////
public class CalAdapter extends RecyclerView.Adapter<CalAdapter.ViewHolder> {
    private ArrayList<CalItem> items;

    CalAdapter(ArrayList<CalItem> items){   //생성자
        this.items = items;
    }
    public void addItem(CalItem item){ //하나씩 저장할때
        items.add(item);
    }
    public void deleteItem(int position){ //하나씩 삭제할때
        items.remove(position);
        notifyItemRemoved(position);
    }
     /*
    public void setItems(ArrayList<CalItem> items){
        this.items = items;
    }

    public CalItem getItem(int position){

        return items.get(position);
    }

    public void setItem(int position, CalItem item){

        items.set(position, item);
    }
     */

     //////////////////////////////어댑터 내의 뷰홀더/////////////////////////////:아이템 뷰를 저장
    @NonNull
    @Override
    public CalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//뷰홀더 객체가 (새로) 만들어질 때
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.cal_item,parent,false);
        CalAdapter.ViewHolder vh = new CalAdapter.ViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//뷰홀더 객체가 재사용 될때
        CalItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    ////////////////////뷰홀더 클래스 (inner class) ///////////////////////static 지움
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_order;
        TextView textView_name;
        TextView textView_address;
        ImageButton imageButton_move;

        public ViewHolder(View itemView) {  //생성자 (뷰 객체가 전달)
            super(itemView);    //부모 클래스의 변수에 담아둔다

            //메소드에서 참조할 수 있도록 변수에 할당
            textView_order = itemView.findViewById(R.id.textView_order);
            textView_name = itemView.findViewById(R.id.textView_name);
            textView_address = itemView.findViewById(R.id.textView_location);
            imageButton_move = itemView.findViewById(R.id.imageButton_move);

            /*    아이템 재배치할때 누르는 버튼
            imageButton_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }); */
        }

        public void setItem(CalItem item) {     //뷰홀더가 재사용될때 호출
            textView_name.setText(item.getName());
            textView_address.setText(item.getAddress());
            textView_order.setText(item.getOrder());
        }
    }
}
