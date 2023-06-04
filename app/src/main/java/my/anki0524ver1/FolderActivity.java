package my.anki0524ver1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;


public class FolderActivity extends AppCompatActivity {

     Button checkButton;
     Button cancelButton1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
        cancelButton1 = findViewById(R.id.cancelButton1);
        cancelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FolderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFolder();
            }
        });
    }

    private void createFolder() {
        String folderName = "MyFolder";

        // 앱 내부 디렉토리 경로 가져오기
        File internalDir = getFilesDir();

        // 폴더 경로 생성
        File folder = new File(internalDir, folderName);

        // 폴더 생성
        if (!folder.exists()) {
            boolean success = folder.mkdir();
            if (success) {
                showToast("폴더가 생성되었습니다.");
            } else {
                showToast("폴더 생성에 실패했습니다.");
            }
        } else {
            showToast("이미 폴더가 존재합니다.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}