package com.wmct.vote.VoteNet;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pcz on 2017/5/10.
 */

public class JsonRequest extends Request<JSONObject> {
    /**
     * @param method
     * @param url
     * @param listener
     */
    public JsonRequest(HttpMethod method, String url, RequestListener<JSONObject> listener) {
        super(method, url, listener);
    }

    @Override
    public JSONObject parseResponse(Response response) {
        String jsonString = new String(response.getRawData());

        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
