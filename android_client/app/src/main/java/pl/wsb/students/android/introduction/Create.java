package pl.wsb.students.android.introduction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import pl.wsb.students.android.introduction.api.ApiClient;
import pl.wsb.students.android.introduction.model.Content;
import pl.wsb.students.android.introduction.model.Note;

public class Create extends AppCompatActivity {
    private static String lastAddedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Button btnLogout = findViewById(R.id.btnLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }

        Button btnCreate = findViewById(R.id.button_create);
        if (btnCreate != null) {
            btnCreate.setOnClickListener(view -> {
                new MyTaskPost().execute();
                Toast.makeText(this, "Dodano", Toast.LENGTH_SHORT).show();
            });
        }
    }

    public static String getLastAddedId() {
        return lastAddedId;
    }


    private class MyTaskPost extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            addUserApiCall();
            return null;
        }

        private void addUserApiCall() {
            EditText title = (EditText)findViewById(R.id.create_title);
            EditText contentText = (EditText)findViewById(R.id.create_content);

            Note note = new Note();
            note.setTitle(title.getText().toString());
            Content content = new Content();
            content.setContent(contentText.getText().toString());
            note.setContent(content);
            try {
                lastAddedId = ApiClient.post(note.toJSON());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
