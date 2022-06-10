package pl.wsb.students.android.introduction.api;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Connection", "close")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });
        return new Retrofit.Builder()
                .baseUrl("http://192.168.2.53:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static String post(String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json); // new
        Request request = new Request.Builder()
                .url("http://192.168.2.53:8080/api/notes/addNote")
                .post(body)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        return response.body().string();
    }

    public static String put(String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json); // new
        Request request = new Request.Builder()
                .url("http://192.168.2.53:8080/api/notes/editNote")
                .put(body)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        return response.body().string();
    }

    public static String delete(String id) throws IOException {
        Request request = new Request.Builder()
                .url("http://192.168.2.53:8080/api/notes/deleteNote/"+ id)
                .delete()
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        return response.body().string();
    }

}
