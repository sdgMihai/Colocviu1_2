package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ro.pub.cs.systems.eim.colocviu1_2.general.Constants;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    private int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.ALL_TERMS)) {
            String stringExtra = intent.getStringExtra(Constants.ALL_TERMS);
            List<String> newString = new ArrayList<>();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher("string1234more567string890");
            while(m.find()) {
                newString.add(m.group());
            }
            for (String element: newString) {
                sum += Integer.valueOf(element);
            }
        }
        intent.putExtra(Constants.ALL_TERMS, String.valueOf(sum));
        setResult(RESULT_OK, intent);
        finish();
    }


}