package com.vinhnqph29776.asm.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.vinhnqph29776.asm.R;
import com.vinhnqph29776.asm.data.Data;
import com.vinhnqph29776.asm.object.ObjLC;
import com.vinhnqph29776.asm.object.ObjLT;

import java.util.List;

public class LoaichiAdapter extends RecyclerView.Adapter<LoaichiAdapter.ViewHolder> {
    private Context mcontext;
    private List<ObjLC> mData;
    private LayoutInflater mInflater;
    private Data dt;

    // data is passed into the constructor
    public LoaichiAdapter(Context mcontext, List<ObjLC> data) {
        this.mInflater = LayoutInflater.from(mcontext);
        this.mData = data;
    }

    public LoaichiAdapter() {

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.loai_row, parent, false);
        mcontext=parent.getContext();
        dt=new Data(mcontext);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ObjLC obj = mData.get(position);
        holder.loai_name.setText(obj.getName());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

DialogUpdate(obj.getId());
            }
        });
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDelete(obj.getId());
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView del, edit;
        TextView loai_name;
        ViewHolder(View itemView) {
            super(itemView);

            loai_name = itemView.findViewById(R.id.loai_name);
            edit = itemView.findViewById(R.id.edit_loai);
            del = itemView.findViewById(R.id.del_loai);
        }


        @Override
        public void onClick(View view) {

        }
    }



    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id)+"";
    }
    private void DialogUpdate(int id){
        Dialog dialog=new Dialog(mInflater.getContext());

        dialog.setContentView(R.layout.update_loai);
        TextView edit_name=dialog.findViewById(R.id.loai_update_name);
        edit_name.setText("tên loại chi");
        EditText input=dialog.findViewById(R.id.input_loai);
        MaterialButton bt;
        bt=dialog.findViewById(R.id.edit);
       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dt.update(input.getText().toString(),"loaichi",id);
               Toast.makeText(mcontext, "thành công", Toast.LENGTH_SHORT).show();
               dialog.dismiss();
           }
       });
       dialog.show();
        Window window=dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    private void dialogDelete(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
        builder.setTitle("Thông Báo");
        builder.setMessage("xóa ?"

        );
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dt. delete(id,"loaichi");
                mData.clear();
                mData = dt.getAllLC();
                notifyDataSetChanged();
                Toast.makeText(mcontext, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("không ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(mcontext, "Đã hủy", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void updateData(List<ObjLC> list) {
list.clear();
list.addAll(list);
        notifyDataSetChanged();
    }


}

