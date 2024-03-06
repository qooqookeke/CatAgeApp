package com.qooke.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editYear;
    Button btnAge;
    TextView txtAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editYear = findViewById(R.id.editYear);
        btnAge = findViewById(R.id.btnAge);
        txtAge = findViewById(R.id.txtAge);

        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 유저가 입력한 년도를 가져온다.
                String strYear = editYear.getText().toString().trim();

                // 빈칸인 경우 입력해주세요 라는 메시지를 보낸다.
//                if (strYear.isEmpty()) {
//                    Snackbar.make(btnAge,"연도를 입력해주세요.", Snackbar.LENGTH_LONG).show();
//                    return;
//                }

                if (strYear.isEmpty()) {
                    Toast.makeText(MainActivity.this, "연도를 입력해주세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                // 2. 나이를 계산한다.
                // 2-1. 숫자형으로 바꿔준다.
                int year = Integer.parseInt(strYear);

                // 2-2. 나이를 계산한다.
                // 현재 연도 가져오기
                int now = Calendar.getInstance().get(Calendar.YEAR);

                int age = now-year;


                // 3. 결과를 화면에 보여준다.
                txtAge.setText(age + "살 입니다.");
            }
        });
    }
}