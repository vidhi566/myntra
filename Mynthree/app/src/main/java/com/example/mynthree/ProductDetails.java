package com.example.mynthree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetails extends AppCompatActivity {

    Button bargainbutton,buybutton,submitbutton;
    ImageView image;
    TextView name,price,response;
    CardView cardview;
    EditText input;


    Product current_product;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        int pId=intent.getIntExtra("Product",0);

        DbHelper dbhelper = new DbHelper(this);

        current_product = dbhelper.fetchProductData(pId);

        bargainbutton = findViewById(R.id.bargain);
        image=findViewById(R.id.productimage);
        name=findViewById(R.id.productname);
        price=findViewById(R.id.price);
        buybutton=findViewById(R.id.buybutton);
        cardview=findViewById(R.id.cardview);
        input=findViewById(R.id.input);
        response=findViewById(R.id.response);
        submitbutton=findViewById(R.id.submitbutton);

        setProductData();

        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setProductData(){
        if(current_product!=null){
            image.setImageResource((int)(current_product.getImage()));
            name.setText(current_product.getName());
            price.setText(String.valueOf(current_product.getPrice()));
        }else{
            Toast.makeText(this, "Product not found", Toast.LENGTH_SHORT).show();
        }

    }

    private void init(){
        bargainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardview.setVisibility(View.VISIBLE);
            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proposedprice = input.getText().toString().trim();
                DbHelper dbhelper = new DbHelper(ProductDetails.this);
                int orders = dbhelper.getCustomer().getOrder_count();
                if(orders>=5){
                    if(Integer.parseInt(proposedprice)>=current_product.getMin_price()){
                        response.setText("Proposal Accepted");
                    }else{
                        response.setText("Try again with "+ (Integer.parseInt(proposedprice)+(0.1*Integer.parseInt(proposedprice))));
                    }

                }else{
                    response.setText("You need to be a frequent buyer to avail bargain services");
                }
            }
        });

        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbhelper = new DbHelper(ProductDetails.this);
                dbhelper.updateCustomer(dbhelper.getCustomer());
            }
        });

    }
}