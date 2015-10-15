package com.bauxite.chris.geoquiz;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button; // Allows the use of the Android Button widget
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // Create the buttons as Java objects.
    // NOTE: Once you create them, you'll need to import the Android Button widget.
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;

    // Create the TextView as an Android TextView widget.
    private TextView questionTextView;

    // This is an array that will hold all of the questions in the form of TrueFalse objects
    private TrueFalse[] questionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_africa, true),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
            new TrueFalse(R.string.question_mideast, true),
            new TrueFalse(R.string.question_oceans, true)
    };

    // Holds the current position in the array. Buggy, as explained in book.
    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Assigns the Android TextView to the Java object.
        questionTextView = (TextView) findViewById(R.id.question_text_view);

        // Grabs the question index from questionBank.
        int question = questionBank[currentIndex].getQuestion();

        // Sets the question using the index from questionBank[currentIndex] and its question number
        //NOTE: This is a really stupid way of doing this.
        questionTextView.setText(question);

        // Find the true and false buttons from the R file.
        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);

        // Make a listener for the buttons.
        trueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                currentIndex = (currentIndex + 1) % questionBank.length;
                int question = questionBank[currentIndex].getQuestion();
                questionTextView.setText(question);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
