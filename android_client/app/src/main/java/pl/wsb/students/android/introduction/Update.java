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

public class Update extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Button btnLogout = findViewById(R.id.btnLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }
        Button btnUpdate = findViewById(R.id.button_update);
        if (btnUpdate != null) {
            btnUpdate.setOnClickListener(view -> {
                new MyTaskPut().execute();

                Toast.makeText(this, "Zaktualizowano", Toast.LENGTH_SHORT).show();
            });
        }
    }


    private class MyTaskPut extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            addUserApiCall();
            return null;
        }

        private void addUserApiCall() {
            EditText idText = (EditText)findViewById(R.id.update_id);
            EditText title = (EditText)findViewById(R.id.update_title);
            EditText contentText = (EditText)findViewById(R.id.update_content);
            Note note = new Note();
            note.setId(idText.getText().toString());
            note.setTitle(title.getText().toString());
            Content content = new Content();
            content.setContent(contentText.getText().toString());
            note.setContent(content);
            try {
                String result = ApiClient.put(note.toJSON());
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
