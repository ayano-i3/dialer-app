package com.example.dialerapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.dialerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final int REQUEST_CALL_PERMISSION = 1;

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
            makePhoneCall();
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
    private void makePhoneCall() {
        String phoneNumber = binding.phoneNumberText.getText().toString();
        if (phoneNumber.length() > 0) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CALL_PERMISSION);
            } else {
                callPhone();
            }
        }

    }

    private void callPhone() {
        String phoneNumber = binding.phoneNumberText.getText().toString();
        String dial = "tel:" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(dial));

        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                Toast.makeText(this, "全ての権限を拒否しました", Toast.LENGTH_SHORT).show();
            }
        }
    }

}