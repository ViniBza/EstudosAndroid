package alura.com.guaruja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webNavegador = (WebView) findViewById(R.id.webview);
        webNavegador.loadUrl("https://guaruja.ossbrasil.com");
        webNavegador.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webNavegador.getSettings();
        webSettings.setJavaScriptEnabled(true);}


        // Use When the user clicks a link from a web page in your WebView
        private class MyWebViewClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().equals("http://meulink.com/")) {
                    return false;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
        }
    }
