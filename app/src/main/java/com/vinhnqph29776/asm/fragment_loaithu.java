package com.vinhnqph29776.asm;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.vinhnqph29776.asm.adapter.LoaithuAdapter;
import com.vinhnqph29776.asm.data.Data;
import com.vinhnqph29776.asm.object.ObjLT;

import java.util.List;

public class fragment_loaithu extends Fragment {
    Data dt;
    FloatingActionButton fab;
    LoaithuAdapter adapter;
    List<ObjLT> list;
    public static void main(String[] args) {

    }
    public static fragment_loaithu newInstance()
    {

        return new fragment_loaithu();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab=view.findViewById(R.id.fab_loaithu);
        TextView nulltext;
        nulltext=view.findViewById(R.id.null_text);
dt=new Data(getActivity());
//
       list=dt.getAllLT();
       if(list.size()!=0){
           nulltext.setText("");
       }
 RecyclerView rv=view.findViewById(R.id.loaithu_rv);
        adapter = new LoaithuAdapter(getActivity(),dt.getAllLT());
       rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Dialog_add();
                list.clear();
                list.addAll(dt.getAllLT());
                adapter.notifyDataSetChanged();;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_loaithu,container,false);

        return view;

    }
    public void Dialog_add(){

        Dialog dialog=new Dialog(getActivity());

        dialog.setContentView(R.layout.loaithu_add_dialog);
EditText input=dialog.findViewById(R.id.input_edittext);
TextView add,cancel;
add=dialog.findViewById(R.id.add_bt);
cancel=dialog.findViewById(R.id.cancel);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
if(input.getText().toString().equals("")){

    Toast.makeText(getActivity(),"tên k được để trống",Toast.LENGTH_SHORT).show();
}else {
    try {
        dt.createLoai(input.getText().toString(), "loaithu");
        Toast.makeText(getActivity(), "Thành công", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();

        dialog.dismiss();

    } catch (Exception ex) {
        Toast.makeText(getActivity(), "lỗi k xác định", Toast.LENGTH_SHORT).show();
    }
}
    }
});
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