package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.WalletBinding;

public class WalletActivity extends AppCompatActivity {
    public WalletBinding binding;
    public boolean isClose = false;
    public String ans = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.wallet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String e = binding.coast1.getText().toString();
        binding.visib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = "";
                if (isClose) {
                    for (int i = 0; i < e.length(); i++) {
                        ans += e.charAt(i);
                    }
                    isClose = false;
                } else {
                    for (int i = 0; i < e.length(); i++) {
                        ans += "*";
                    }
                    isClose = true;
                }
                binding.coast1.setText(ans);
            }
        });
    }
}