package com.example.dialerapp;

import static android.content.ContentValues.TAG;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.dialerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.number1.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "1");
        });

        binding.number2.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "2");
        });

        binding.number3.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "3");
        });

        binding.number4.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "4");
        });

        binding.number5.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "5");
        });

        binding.number6.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "6");
        });

        binding.number7.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "7");
        });

        binding.number8.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "8");
        });

        binding.number9.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "9");
        });

        binding.number0.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "0");
        });

        binding.numberAsterisk.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "*");
        });

        binding.numberSharp.setOnClickListener( v -> {
            binding.phoneNumberText.setText(binding.phoneNumberText.getText().toString() + "#");
        });


        binding.callButton.setOnClickListener(v -> {
//            callPhone();
        });


        ImageButton deleteButton = binding.deleteButton;
        if(binding.phoneNumberText != null) {
            deleteButton.setOnClickListener(v -> {
                String currentText = binding.phoneNumberText.getText().toString();
                int cursorPosition = binding.phoneNumberText.getSelectionStart(); // カーソル位置を保存
                if(!currentText.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder(binding.phoneNumberText.getText());
                    stringBuilder.deleteCharAt(binding.phoneNumberText.getText().length() - 1);
                    String newString = stringBuilder.toString();
                    binding.phoneNumberText.setText(newString);

                    // カーソル位置を復元
                    if (cursorPosition > 0) {
                        binding.phoneNumberText.setSelection(cursorPosition - 1);
                    }
                }
            });
        } else {
            //もしEditTextが空の場合はなにもしないようにする
            Log.d("delete", "EditText is mull");
        }


        //Deleteボタン長押しで全削除
        binding.deleteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                binding.phoneNumberText.setText("");
                return true;
            }
        });

    }

//    private void callPhone() {
//        String phoneNumber = binding.phoneNumberText.getText().toString();
//        String dial = "tel:" + phoneNumber;
//        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
//
//        startActivity(intent);
//
//    }


}