package pl.wsb.students.android.introduction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import pl.wsb.students.android.introduction.api.ApiClient;
import pl.wsb.students.android.introduction.model.Content;
import pl.wsb.students.android.introduction.model.Note;

public class Delete extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Button btnLogout = findViewById(R.id.btnLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }

        Button btnDelete = findViewById(R.id.button_delete);
        if (btnDelete != null) {
            btnDelete.setOnClickListener(view -> {
                new MyTaskDelete().execute();

                Toast.makeText(this, "Usunięto", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private class MyTaskDelete extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            deleteUserApiCall();
            return null;
        }

        private void deleteUserApiCall() {
            EditText idText = (EditText)findViewById(R.id.delete_id);

            try {

                String result = ApiClient.delete(idText.getText().toString());
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
