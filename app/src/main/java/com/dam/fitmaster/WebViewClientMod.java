package com.dam.fitmaster;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientMod extends WebViewClient {
    private Context mContext;
    private String video_id;

    public WebViewClientMod(Context context) {
        mContext = context;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        if (url.startsWith("fitmaster://")) {
            Log.d("WebViewClientMod","URL perteneciente a fitmaster");
            //Debemos añadir una consulta a la BBDD para que asocie al video del URL con el ID necesario
            MiBaseDatos MDB = new MiBaseDatos(mContext);
            video_id = MDB.obtenerVideoId(url);

            Intent intent = new Intent(mContext, VideosActivity.class);
            intent.putExtra("video_id", video_id);
            mContext.startActivity(intent);
            return true;
        } else {
            Log.d("WebViewClientMod","URL diferente a fitmaster");
            // Para cualquier otra URL, deja que el WebView las maneje. Aunque no existe ninguna diferente
            return false;
        }
    }
    public String getVideoId() {
        Log.d("WebViewClientMod", "Video ID " + video_id);
        return video_id;
    }
}
