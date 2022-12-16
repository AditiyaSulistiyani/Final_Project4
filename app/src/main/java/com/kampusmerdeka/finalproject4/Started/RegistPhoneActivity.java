package com.kampusmerdeka.finalproject4.Started;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kampusmerdeka.finalproject4.R;

import java.util.HashMap;
import java.util.Map;

public class RegistPhoneActivity extends AppCompatActivity {
    private Button btnSaveNumber,btnLogout;
    private EditText edtTxtPhone;
    private ProgressDialog progressDialog;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_phone);

        edtTxtPhone = findViewById(R.id.edtTxtPhone);
        btnLogout = findViewById(R.id.btnLogout);
        btnSaveNumber = findViewById(R.id.btnSaveNumber);

        progressDialog = new ProgressDialog(RegistPhoneActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan....");




        btnSaveNumber.setOnClickListener(view -> {
            if(edtTxtPhone.getText().length()>0) {
                saveData(edtTxtPhone.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(),"Masukan nomer handphone anda!",Toast.LENGTH_SHORT).show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(RegistPhoneActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
    private void saveData(String noHp){
        Map<String, Object> user = new HashMap<>();
        user.put("No Hp",noHp);
        progressDialog.show();

        db.collection("customer")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Berhasil memasukan nomer handphone",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                        Intent regist = new Intent(getApplicationContext(), GetStartedActivity.class);
                        startActivity(regist);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                });
    }
}