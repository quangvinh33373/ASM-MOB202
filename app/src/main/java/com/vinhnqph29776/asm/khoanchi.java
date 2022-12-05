package com.vinhnqph29776.asm;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vinhnqph29776.asm.adapter.KhoanchiAdapter;
import com.vinhnqph29776.asm.adapter.KhoanthuAdapter;
import com.vinhnqph29776.asm.data.Data;
import com.vinhnqph29776.asm.object.ObjKC;
import com.vinhnqph29776.asm.object.ObjKT;
import com.vinhnqph29776.asm.object.ObjLC;
import com.vinhnqph29776.asm.object.ObjLT;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class khoanchi extends Fragment {
    Data dt;
    List<ObjLC> listlc;
    List<ObjKC> list;
    KhoanchiAdapter kadapter;
    public khoanchi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khoanchi, container, false);
        FloatingActionButton fab;

        TextView nulltext;
        nulltext = view.findViewById(R.id.null_text);
        dt = new Data(getActivity());
        list=dt.getAllKC();

        RecyclerView rv = view.findViewById(R.id.khoanchi_rv);
        kadapter = new KhoanchiAdapter(getActivity(), dt.getAllKC());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(kadapter);
        if (list.size()!=0) {
            nulltext.setText("");
        }else{

        }
        fab = view.findViewById(R.id.fab_khoanchi);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_add();
            }
        });
        return view;
    }
    public void Dialog_add(){
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_khoanchi);
        TextView add, cancel;
        Spinner spn;

        listlc = dt.getAllLC();
        spn = dialog.findViewById(R.id.lc_spinner);
        ArrayAdapter<ObjLC> ad
                = new ArrayAdapter<ObjLC>(
                getContext(),
                android.R.layout.simple_spinner_item,listlc
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


        add = dialog.findViewById(R.id.add_bt_khoanthu);
        cancel=dialog.findViewById(R.id.cancel_bt_khoanthu);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Đã hủy", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
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
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(b.isEmpty()){
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(c.isEmpty()){
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(formatedDate.isEmpty()){
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }
                if(d.isEmpty()){
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }if(e.isEmpty()){
                    Toast.makeText(getContext(), "k được để trống", Toast.LENGTH_SHORT).show();
                }

                else {

                    try {

                        dt.createKhoan(a, b, formatedDate, loaithu, c, d, e,"khoanchi");
                        Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } catch (Exception ex) {
                        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}