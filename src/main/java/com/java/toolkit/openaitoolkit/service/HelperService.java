package com.java.toolkit.openaitoolkit.service;

import com.google.gson.Gson;
import com.java.toolkit.openaitoolkit.constants.Constants;
import com.java.toolkit.openaitoolkit.model.JsonPayload;
import com.java.toolkit.openaitoolkit.model.JsonPayloadWS;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HelperService {

    public Map<String,Object> sendRequestToOpenAI(JsonPayload jsonPayload) throws IOException {
        Gson gson = new Gson();
        Constants constants = new Constants();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, gson.toJson(jsonPayload));
        Request request = new Request.Builder()
                .url(constants.URL)
                .method("POST", body)
                .addHeader("Authorization", "Bearer "+constants.API_BEARER_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        Map<String,Object> result = gson.fromJson(responseString,Map.class);
        return result;
    }

    public Map<String,Object> sendRequestToOpenAI(JsonPayloadWS jsonPayloadWS) throws IOException {
        Gson gson = new Gson();
        Constants constants = new Constants();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, gson.toJson(jsonPayloadWS));
        Request request = new Request.Builder()
                .url(constants.URL)
                .method("POST", body)
                .addHeader("Authorization", "Bearer "+constants.API_BEARER_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        Map<String,Object> result = gson.fromJson(responseString,Map.class);
        return result;
    }
}
