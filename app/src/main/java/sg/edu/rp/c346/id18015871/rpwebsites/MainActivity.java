package sg.edu.rp.c346.id18015871.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCat;
    Spinner spnSubCat;
    Button btngo;
    ArrayList<String> webs;
    WebView wvMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCat=findViewById(R.id.spinnerCat);
        spnSubCat=findViewById(R.id.spinnerSubCat);
        btngo=findViewById(R.id.button);
        wvMyPage=findViewById(R.id.wv);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //code for item 1 selected
                        webs.add("https://www.rp.edu.sg/");
                        webs.add("https://www.rp.edu.sg/student-life");


                        break;
                    case 1:
                        //code for item 2 selected
                        webs.add("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                        webs.add("https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnSubCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //code for item 1 selected
                        webs.remove(0);
                        break;
                    case 1:
                        //code for item 2 selected
                        webs.remove(1);
                        break;

                case 2:
                //code for item 2 selected
                webs.remove(0);
                break;

            case 3:
                //code for item 2 selected
                    webs.remove(1);
                    break;
        }
    }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btngo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wvMyPage.setWebViewClient(new WebViewClient());

                wvMyPage.getSettings().setJavaScriptEnabled(true);
                wvMyPage.getSettings().setAllowFileAccess(false);
                wvMyPage.getSettings().setBuiltInZoomControls(true);
                String url=webs.get(0);
                wvMyPage.loadUrl(url);
            }
        });
    }

}
