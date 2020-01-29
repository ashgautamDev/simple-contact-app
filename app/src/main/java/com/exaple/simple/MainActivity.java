package com.exaple.simple;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivmood,ivweb,ivcall,ivmap;
    Button btncreate;

      final int CREATE_CONTACT=1;
      String name="",web="",map="",mood="",number="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivcall=findViewById(R.id.ivcall);
        ivmap=findViewById(R.id.ivmap);
        ivweb=findViewById(R.id.ivweb);
        ivmood=findViewById(R.id.ivhappy);

        ivcall.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        ivmap.setVisibility(View.GONE);
        ivmood.setVisibility(View.GONE);

        btncreate= findViewById(R.id.btncreate);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.exaple.simple.createcontact.class);
                startActivityForResult(intent,CREATE_CONTACT);
            }
        });

        ivweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });
        ivmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?Q" + map));
                startActivity(intent);
            }
        });
        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT){
        if (resultCode == RESULT_OK)
        {
            ivcall.setVisibility(View.VISIBLE);
            ivweb.setVisibility(View.VISIBLE);
            ivmap.setVisibility(View.VISIBLE);
            ivmood.setVisibility(View.VISIBLE);

            name = data.getStringExtra("name");
            web = data.getStringExtra("web");
            map = data.getStringExtra("map");
            mood = data.getStringExtra("mood");
            number = data.getStringExtra("number");

            if (mood.equals("happy"))
            {
                ivmood.setImageResource(R.drawable.happy);
            }
            else  if (mood.equals("ok"))
            {
                ivmood.setImageResource(R.drawable.ok);
            }
            else
            {
                ivmood.setImageResource(R.drawable.sad);
            }
        }
        else{
            Toast.makeText(this,"Create Here",Toast.LENGTH_LONG).show();
        }
        }

    }
}

