package com.vinhnqph29776.asm.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.vinhnqph29776.asm.Khoanthu;
import com.vinhnqph29776.asm.R;
import com.vinhnqph29776.asm.data.Data;
import com.vinhnqph29776.asm.object.ObjKC;
import com.vinhnqph29776.asm.object.ObjKT;
import com.vinhnqph29776.asm.object.ObjLC;
import com.vinhnqph29776.asm.object.ObjLT;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class KhoanchiAdapter extends RecyclerView.Adapter<KhoanchiAdapter.ViewHolder> {
    private Context mcontext;
    private List<ObjKC> mData;
    private List<ObjLC> listlt;
    private LayoutInflater mInflater;
    private Data dt;

    // data is passed into the constructor
    public KhoanchiAdapter(Context mcontext, List<ObjKC> data) {
        this.mInflater = LayoutInflater.from(mcontext);
        this.mData = data;
    }

    public KhoanchiAdapter() {

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_layout, parent, false);
        mcontext=parent.getContext();
        dt=new Data(mcontext);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ObjKC obj = mData.get(position);
        holder.id_khoan.setText(obj.getKhoanthu_id());
        holder.tenkhoan.setText(obj.getTenkhoan());
        holder.ngay.setText(obj.getNgaythu());
        holder.sotien.setText(obj.getSotien());
        holder.noidung.setText(obj.getNoidung());
        holder.ten.setText(obj.getHoten());
        holder.loai.setText("loại chi: " );
        holder.loai_khoan.setText(obj.getLoaithu());
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
        TextView loai,loai_khoan,id_khoan,tenkhoan,ten,tien,ngay,sotien,noidung;
        ViewHolder(View itemView) {
            super(itemView);
            id_khoan=itemView.findViewById(R.id.id_khoan);
            tenkhoan=itemView.findViewById(R.id.ten);
            edit = itemView.findViewById(R.id.edit_khoan);
            del = itemView.findViewById(R.id.del_khoan);
            ten=itemView.findViewById(R.id.hoten_khoan);
            tien=itemView.findViewById(R.id.sotien_khoan);
            ngay=itemView.findViewById(R.id.ngay_khoan);
            sotien=itemView.findViewById(R.id.sotien_khoan);
            noidung=itemView.findViewById(R.id.noidung_khoan);
            loai=itemView.findViewById(R.id.tv_loai);
            loai_khoan=itemView.findViewById(R.id.loai_khoan);
        }


        @Override
        public void onClick(View view) {

        }
    }



    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id)+"";
    }
    private void DialogUpdate(int uid){
        Dialog dialog=new Dialog(mInflater.getContext());

        dialog.setContentView(R.layout.update_khoan);
        TextView add, cancel;
        Spinner spn;
        mData = dt.getAllKC();
        spn = dialog.findViewById(R.id.loaithu_spinner);
        listlt=dt.getAllLC();
        ArrayAdapter<ObjLC> ad
                = new ArrayAdapter<ObjLC>(
                mcontext,
                android.R.layout.simple_spinner_item, listlt
        );
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spn.setAdapter(ad);
        EditText id, tenkhoan, sotien, noidung, ten;
        DatePicker date;

        id = dialog.findViewById(R.id.id_input);
        tenkhoan = dialog.findViewById(R.id.input_khoanthu);
        sotien = dialog.findViewById(R.id.input_tienthu);
        noidung = dialog.findViewById(R.id.input_noidungthu);
        ten = dialog.findViewById(R.id.input_ten);
        date = dialog.findViewById(R.id.datepicker_value);
        EditText input=dialog.findViewById(R.id.input_loai);
        MaterialButton bt;
        cancel=dialog.findViewById(R.id.cancel_bt_khoanthu);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mcontext, "Đã hủy", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        add = dialog.findViewById(R.id.add_bt_khoanthu);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = id.getText().toString();
                String b = tenkhoan.getText().toString();
                String c = sotien.getText().toString();
                String d = noidung.getText().toString();
                String e = ten.getText().toString();
                String loaithu = spn.getSelectedItem().toString();
                int day = date.getDayOfMonth();
                int month = date.getMonth();
                int year = date.getYear();


                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                String formatedDate = sdf.format(calendar.getTime());
                if(a.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(b.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(c.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(formatedDate.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(d.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }if(e.isEmpty()){
                    Toast.makeText(mcontext, "k được để trống", Toast.LENGTH_SHORT).show();
                }else {
                    try {

                        dt.updateKhoan(uid,a, b, formatedDate, loaithu, c, d, e,"khoanchi");
                        Toast.makeText(mcontext, "ok", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } catch (Exception ex) {
                        Toast.makeText(mcontext, "fail", Toast.LENGTH_SHORT).show();
                    }
                }

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

                dt. delete(id,"khoanthu");
                mData.clear();

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



}


