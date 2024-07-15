package com.example.mynthree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText name,number;
    Button submit;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences("mySP",MODE_PRIVATE);
        editor = sp.edit();
        if(sp.getBoolean("Login",false)){
            goToHome();
        }
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        submit = findViewById(R.id.submit);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void init(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString().trim();
                String Number = number.getText().toString().trim();
                if(!Name.isEmpty() && !Number.isEmpty()){
                    editor.putBoolean("Login", true);
                    editor.apply();
                    Customer c = new Customer();
                    c.setName(Name);
                    c.setNumber(Number);
                    c.setOrder_count(0);
                    DbHelper dbhelper = new DbHelper(LoginActivity.this);
                    dbhelper.insertCustomer(c);
                    fillData();
                    goToHome();
                }else{
                    Toast.makeText(LoginActivity.this,"Please Enter all the details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void goToHome(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

    void fillData(){
        DbHelper dbHelper = new DbHelper(this);

        Product p1 = new Product(R.drawable.baggy_jeans,"Baggy Jeans/ 28",1799,1650);
        dbHelper.insertProdut(p1);
        Product p2 = new Product(R.drawable.blue_rugged_jeans,"Blue Rugged Jeans",2399,2200);
        dbHelper.insertProdut(p2);
        Product p3 = new Product(R.drawable.womenburgandyprintedtop,"Women Burgandy Printed A-Line Top",1299,1100);
        dbHelper.insertProdut(p3);
        Product p4 = new Product(R.drawable.women_black_printedtop,"Women Black Printed Top",799,550);
        dbHelper.insertProdut(p4);
        Product p5 = new Product(R.drawable.womenprinteddress,"Women Printed Dress",2599,2400);
        dbHelper.insertProdut(p5);
        Product p6 = new Product(R.drawable.coordsets,"Women Co-ord sets",2799,2200);
        dbHelper.insertProdut(p6);
        Product p7 = new Product(R.drawable.dress,"Pink Knee-length Dress",2290,1800);
        dbHelper.insertProdut(p7);
        Product p8 = new Product(R.drawable.funkyshirt,"Lavendar Cropped Shirt",999,700);
        dbHelper.insertProdut(p8);
        Product p9 = new Product(R.drawable.hotpinktop,"Women Hot Pink Top",799,600);
        dbHelper.insertProdut(p9);
        Product p10 = new Product(R.drawable.kurti_women,"Casual Kurti",699,400);
        dbHelper.insertProdut(p10);
        Product p11 = new Product(R.drawable.olivegreenrufflesleevetop,"Olive green Ruffle-sllves Top",899,700);
        dbHelper.insertProdut(p11);
        Product p12 = new Product(R.drawable.oneshouldertop,"Women One Shoulder Top",999,800);
        dbHelper.insertProdut(p12);


    }
}