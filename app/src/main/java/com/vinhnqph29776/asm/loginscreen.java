package com.vinhnqph29776.asm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class loginscreen extends AppCompatActivity {
    private EditText user,pass;
    private MaterialButton login_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
      user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
       login_button=findViewById(R.id.login_button);
        Intent intent=new Intent(this,MainActivity.class);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(user.getText().toString().equals("vinh")&&pass.getText().toString().equals("1")){
    startActivity(intent);
}else{
    Toast.makeText(getApplicationContext(),"sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
}

            }
        });
    }
}
