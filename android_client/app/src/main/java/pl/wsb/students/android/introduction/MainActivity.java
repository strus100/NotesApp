package pl.wsb.students.android.introduction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button goToGetAll;
    private Button goToAdd;
    private Button goToDelete;
    private Button goToEdit;
    private Button goToGetOne;

    private void initControls() {
        this.goToGetAll = findViewById(R.id.goToGetAll);
        this.goToGetOne = findViewById(R.id.goToGetOne);
        this.goToEdit = findViewById(R.id.goToEdit);
        this.goToDelete = findViewById(R.id.goToDelete);
        this.goToAdd = findViewById(R.id.goToAdd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initListeners();
    }

    private void initListeners() {
        if (this.goToGetAll != null) {
            this.goToGetAll.setOnClickListener(view -> {
                Intent intent = new Intent(this, GetAll.class);
                startActivity(intent);
                finish();
            });
        }
        if (this.goToGetOne != null) {
            this.goToGetOne.setOnClickListener(view -> {
                startActivity(new Intent(this, GetOne.class));
                finish();
            });
        }
        if (this.goToEdit != null) {
            this.goToEdit.setOnClickListener(view -> {
                Intent intent = new Intent(this, Update.class);
                startActivity(intent);
                finish();
            });
        }
        if (this.goToDelete != null) {
            this.goToDelete.setOnClickListener(view -> {
                Intent intent = new Intent(this, Delete.class);
                startActivity(intent);
                finish();
            });
        }
        if (this.goToAdd != null) {
            this.goToAdd.setOnClickListener(view -> {
                Intent intent = new Intent(this, Create.class);
                startActivity(intent);
                finish();
            });
        }

    }
}