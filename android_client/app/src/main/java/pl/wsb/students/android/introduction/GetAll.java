package pl.wsb.students.android.introduction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import pl.wsb.students.android.introduction.adapter.NotesAdapter;
import pl.wsb.students.android.introduction.api.ApiUtils;
import pl.wsb.students.android.introduction.model.Note;
import retrofit2.Response;

public class GetAll extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);
        Button btnLogout = findViewById(R.id.btnLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }

        getUsersApiCall();
    }

    private void initRecyclerView(List<Note> users) {
        RecyclerView recyclerView = findViewById(R.id.rvLoggedInUsersList);
        if (recyclerView == null) {
            return;
        }   //if
        if (users == null) {
            return;
        }   //if
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NotesAdapter usersAdapter = new NotesAdapter(this, users);
        recyclerView.setAdapter(usersAdapter);
    }


    private void getUsersApiCall() {
        Log.i("TESST", "DUPA");
        ApiUtils.getApiService().getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<List<Note>>>() {

                    @Override
                    public void onNext(@NonNull Response<List<Note>> response) {
                        if (ApiUtils.getResponseStatusCode(response) == 200) {
                            initRecyclerView(response.body());
                        }   //if
                    }

                    @Override
                    public void onError(@NonNull Throwable ex) {
                        Log.e("API_CALL", ex.getMessage(), ex);
                    }

                    @Override
                    public void onComplete() {
                        //nothing here
                    }
                });
    }

}
