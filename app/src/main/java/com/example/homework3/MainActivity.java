package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSearch;
    Button bntSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.pole_search);
        bntSearch = findViewById(R.id.search_bnt);
        bntSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String find = etSearch.getText().toString();
                if (!find.equals("")) {
                    searchInternet(find);
                }
            }
        });
    }

    public void searchInternet(String inform) {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, inform);
            startActivity(intent);
        } catch (ActivityNotFoundException i) {
            i.printStackTrace();
            searchReadyInform(inform);
        }
    }

    public void searchReadyInform(String inform) {
        Uri google = Uri.parse("https://www.google.com/" + inform);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, google);
            startActivity(intent);
        } catch (ActivityNotFoundException i) {
            i.printStackTrace();
            Toast.makeText(this, "Найдено", Toast.LENGTH_SHORT).show();

        }
    }
}