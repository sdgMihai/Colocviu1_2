package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ro.pub.cs.systems.eim.colocviu1_2.general.Constants;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private Button addButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private EditText next_term;
    private TextView all_terms;

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String next_term_string = next_term.getText().toString();

            switch (view.getId()) {
                case R.id.add:
                    if (next_term_string.length() != 0)
                        all_terms.setText(all_terms.getText() + " + " + next_term_string);
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        addButton = (Button)findViewById(R.id.add);
        next_term = (EditText)findViewById(R.id.next_term);
        all_terms = (TextView)findViewById(R.id.all_terms);

        next_term.setText(String.valueOf(0));
        addButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == RESULT_OK) {

            Toast.makeText(this, "The activity returned with result " + intent.getExtras().getString(Constants.ALL_TERMS), Toast.LENGTH_LONG).show();
        }
    }
}