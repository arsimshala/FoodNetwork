package gr.academic.city.sdmd.foodnetwork.util;

import com.google.gson.Gson;

public abstract class GsonResponseCallback<T> implements Commons.ResponseCallback {

    private Gson gson = new Gson();
    private Class<T> classOfT;

    public GsonResponseCallback(Class<T> classOfT) {
        this.classOfT = classOfT;
    }

    @Override
    public final void onResponse(int responseCode, String responsePayload) {
        T jsonPayload = gson.fromJson(responsePayload, classOfT);
        onResponse(responseCode, jsonPayload);
    }

    protected abstract void onResponse(int responseCode, T jsonPayload);
}
