package pl.wsb.students.android.introduction.api;

import retrofit2.Response;

public class ApiUtils {

    public static ApiService getApiService() {
        return ApiClient.getClient().create(ApiService.class);
    }

    public static <T> int getResponseStatusCode(Response<T> response) {
        if (response == null) {
            return 404; //zhardkodowane 404 - srednio elegancko
        }   //if
        return response.code();
    }
}
