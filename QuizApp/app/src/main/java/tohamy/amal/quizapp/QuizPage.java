package tohamy.amal.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizPage extends AppCompatActivity {

    public static int result = 0;
    public static String name;
    private RadioButton answerOne;
    private RadioButton answerTwo;
    private RadioButton answerThree;
    private RadioButton answerFour;
    private RadioButton answerFive;
    private RadioButton answerSix;
    private RadioButton answerSeven;
    private RadioButton answerEight;
    private RadioButton answerNine;
    private CheckBox firstAnswerTen;
    private CheckBox secondAnswerTen;
    private CheckBox secondChoiceTen;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        answerOne = findViewById(R.id.question1_choice3);
        answerTwo = findViewById(R.id.question2_choice2);
        answerThree = findViewById(R.id.question3_choice2);
        answerFour = findViewById(R.id.question4_choice2);
        answerFive = findViewById(R.id.question5_choice2);
        answerSix = findViewById(R.id.question6_choice1);
        answerSeven = findViewById(R.id.question7_choice2);
        answerEight = findViewById(R.id.question8_choice3);
        answerNine = findViewById(R.id.question9_choice1);
        firstAnswerTen =  findViewById(R.id.question10_choice1);
        secondAnswerTen = findViewById(R.id.qustion10_choice3);
        secondChoiceTen = findViewById(R.id.question10_choice2);

        nameEditText = findViewById(R.id.name_edit_text);
    }



    private int answers()
    {
        if (answerOne.isChecked())
        {
            result = result + 1;
        }

        if (answerTwo.isChecked())
        {
            result = result + 1;
        }

        if (answerThree.isChecked())
        {
            result = result + 1;
        }

        if(answerFour.isChecked())
        {
            result = result + 1;
        }

        if (answerFive.isChecked())
        {
            result = result + 1;
        }

        if (answerSix.isChecked())
        {
            result = result + 1;
        }

        if(answerSeven.isChecked())
        {
            result = result + 1;
        }

        if (answerEight.isChecked())
        {
            result = result + 1;
        }

        if (answerNine.isChecked())
        {
            result = result + 1;
        }

        if ((firstAnswerTen.isChecked() && secondAnswerTen.isChecked()) && (!secondChoiceTen.isChecked()))
        {
            result = result + 1;
        }

        return result;
    }

    public void summitAnswers(View view) {
        int finalResult = answers();

        name = nameEditText.getText().toString();
        if(name.isEmpty())
        {
            Toast.makeText(this, "Please enter you name first", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Your result is " + result, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ResultPage.class);
            Resources resources = getResources();
            String key  = resources.getString(R.string.key_name);
            String keyResult = resources.getString(R.string.key_result);
            intent.putExtra(key, name);
            startActivity(intent);
            intent.putExtra(keyResult, finalResult);
            startActivity(intent);
        }
    }

}
