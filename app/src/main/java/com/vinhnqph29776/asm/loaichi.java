package com.vinhnqph29776.asm;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vinhnqph29776.asm.adapter.LoaichiAdapter;
import com.vinhnqph29776.asm.adapter.LoaithuAdapter;
import com.vinhnqph29776.asm.data.Data;
import com.vinhnqph29776.asm.object.ObjLC;
import com.vinhnqph29776.asm.object.ObjLT;

import java.util.List;

public class loaichi extends Fragment {
    Data dt;
    FloatingActionButton fab;
    LoaichiAdapter adapter;
    List<ObjLC> list;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab=view.findViewById(R.id.fab_loaichi);
        TextView nulltext;
        nulltext=view.findViewById(R.id.null_text);
        dt=new Data(getActivity());
        list=dt.getAllLC();
        if(list.size()!=0){
            nulltext.setText("");
        }
        RecyclerView rv=view.findViewById(R.id.loaichi_rv);
        adapter = new LoaichiAdapter(getActivity(),dt.getAllLC());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_add();
adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        input=container.findViewById(R.id.input_edittext);
        View view=inflater.inflate(R.layout.fragment_loaichi,container,false);

        return view;

    }
    public void Dialog_add(){
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.loaithu_add_dialog);
        EditText input=dialog.findViewById(R.id.input_edittext);
        TextView banner,text,add,cancel;
        banner=dialog.findViewById(R.id.head_title);
        banner.setText("Loại chi");
        text=dialog.findViewById(R.id.loaithu_text);
        text.setText("tên loại chi");
input.setHint("Nhập loại chi");
cancel=dialog.findViewById(R.id.cancel);
cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Toast.makeText(getContext(), "Đã hủy", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
});
        add=dialog.findViewById(R.id.add_bt);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().isEmpty()) {

                    Toast.makeText(getActivity(), "tên k được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        dt.createLoai(input.getText().toString(), "loaichi");
                        Toast.makeText(getActivity(), "Thành công", Toast.LENGTH_SHORT).show();


                        dialog.dismiss();

                    } catch (Exception ex) {
                        Toast.makeText(getActivity(), "lỗi k xác định", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cancel=dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(getActivity(),"Đã hủy",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        Window window=dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }

}