package lk.ijse.randdchallange;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeavyService {
    private static final String BASE_URL = "https://8015b5dbc0724d38882ac90397c27649.weavy.io/api/users";
    private static final String API_KEY = "wys_hMWpXdekxcn9Gc8Ioah3azOllzUZ7l3HN9yB";
    private final OkHttpClient httpClient = new OkHttpClient();


    //POST request
    public String createUser(String name, String email) throws IOException {
        String json = "{ \"name\": \"" + name + "\", \"email\": \"" + email + "\" }";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    //Get Request
    public String listUsers() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .get()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    // Patch
    public String updateUser(String userId, String newName, String newEmail) throws IOException {
        String json = "{ \"name\": \"" + newName + "\", \"email\": \"" + newEmail + "\" }";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + userId)
                .patch(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    //Delete
    public String deleteUser(String userId) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + userId)
                .delete()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
