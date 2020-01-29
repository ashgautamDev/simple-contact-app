package com.exaple.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class createcontact extends AppCompatActivity implements View.OnClickListener {

    EditText etname,etweb,etmap,etnumber;
    ImageView ivhappy,ivok,ivsad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcontact);

        etname = findViewById(R.id.etname);
        etnumber = findViewById(R.id.etnumber);
        etmap = findViewById(R.id.etmap);
        etweb = findViewById(R.id.etweb);

        ivhappy = findViewById(R.id.ivhappy);
         ivok= findViewById(R.id.ivok);
         ivsad= findViewById(R.id.ivsad);

         ivsad.setOnClickListener(this);
        ivok.setOnClickListener(this);
        ivhappy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (etname.getText().toString().isEmpty() ||
        etmap.getText().toString().isEmpty() ||etnumber.getText().toString().isEmpty() ||etweb.getText().toString().isEmpty() ){

            Toast.makeText(this,"Please enter all fields",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent();
            intent.putExtra("name",etname.getText().toString().trim());
            intent.putExtra("number",etnumber.getText().toString().trim());
            intent.putExtra("map",etmap.getText().toString().trim());
            intent.putExtra("web",etweb.getText().toString().trim());

            if (view.getId() == R.id.ivhappy ){
                intent.putExtra("mood","happy");
            }
            else if (view.getId() == R.id.ivok ){
                intent.putExtra("mood","ok");
            }
            else
            { intent.putExtra("mood","sad");
            }
            setResult(RESULT_OK,intent);
            createcontact.this.finish();
        }
    }
}
