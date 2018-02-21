package tohamy.amal.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void startQuiz(View view) {
        //we declare Intent object to open to new Activity
        //this refers to the current activity and then we call the activity we want to open "QuizPage"
        Intent intent = new Intent(this, QuizPage.class);
        startActivity(intent);
    }
}
