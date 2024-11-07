package com.duyle.lab1md19304.lap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.duyle.lab1md19304.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Khởi tạo FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            // Đăng xuất
            mAuth.signOut();
            Toast.makeText(MainActivity.this, "Đăng xuất thành công!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
