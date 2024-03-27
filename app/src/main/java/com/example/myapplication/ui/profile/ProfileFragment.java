package com.example.myapplication.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.PaymentActivity;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentProfileBinding;
import com.example.myapplication.ui.home.HomeViewModel;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    public boolean isClose = false;
    public String ans = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String e = binding.coast.getText().toString();


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
                binding.coast.setText(ans);
            }
        });
        return root;
    }
    public void clck(View v) {
        Intent intent = new Intent(getContext(), PaymentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}