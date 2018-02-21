package tohamy.amal.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    private String name;
    public String finalResult;
    private TextView scoreResult;
    private ImageView resultImage;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        scoreResult = findViewById(R.id.score_text);
        resultImage = findViewById(R.id.result_image);
        resultText = findViewById(R.id.result_text);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        name = bundle.getString(getResources().getString(R.string.key_name));
        finalResult =  bundle.getString(getResources().getString(R.string.key_result));
        setResult();

    }

    private String setResult()
    {
        if(QuizPage.result >= 5) {
            resultImage.setImageResource(R.drawable.happy);
            String winMsg = getString(R.string.you_win) + " " + name;
            resultText.setText(winMsg);
        }
        else if (QuizPage.result < 5)
        {
            resultImage.setImageResource(R.drawable.sad);
            String loseMsg = getString(R.string.you_lose) + " " + name;
            resultText.setText(loseMsg);
        }

        String resultMsg = QuizPage.result + "/10";
        scoreResult.setText(resultMsg);

        String message;
        return message = name + " Result at Brain quiz is " + resultMsg;
        //return message;
    }

    public void exit(View view)
    {
        this.finishAffinity();
    }

    public void tryAgain(View view)
    {
        name = " ";
        QuizPage.result = 0;
        resultText.setText(" ");
        scoreResult.setText(" ");

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }


    public void shareResult(View view)
    {
        String message = setResult();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //email subject
        intent.putExtra(Intent.EXTRA_SUBJECT, "Brain quiz for " + name);
        //EXTRA_TEXT is constant for email  body
        intent.putExtra(Intent.EXTRA_TEXT, message);
        //To make sure there is an app that can handle the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
