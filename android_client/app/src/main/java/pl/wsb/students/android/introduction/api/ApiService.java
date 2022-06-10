package pl.wsb.students.android.introduction.api;

import java.util.List;

import io.reactivex.Observable;
import pl.wsb.students.android.introduction.model.Note;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/notes/")
    Observable<Response<List<Note>>> getNotes();

    @GET("api/notes/{aId}")
    Observable<Response<Note>> getNote(@Path("aId") String aId);

}
