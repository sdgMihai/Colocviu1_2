package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
}