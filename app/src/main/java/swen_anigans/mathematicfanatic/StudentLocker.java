package swen_anigans.mathematicfanatic;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentLocker extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTheme(R.style.LockerTheme);
        setContentView(R.layout.activity_student_locker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Lockertoolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) findViewById(R.id.LockerTitle);

        String titleText;
        if(DataManager.getInstance().curStudent.name.toUpperCase().endsWith("S"))
        {
            titleText = DataManager.getInstance().curStudent.name + "' Locker";
        }
        else
        {
            titleText = DataManager.getInstance().curStudent.name + "'s Locker";
        }

        title.setText(titleText);

        if(DataManager.getInstance().questionsContent == null)
        {
            DataManager.getInstance().questionsContent = new QuestionContent(20);
        }

        // Clear the submitted answers
        DataManager.getInstance().questionsContent.ClearAnswers();

        // Shuffle them up!
        DataManager.getInstance().questionsContent.ShuffleQuestions();

        //set the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set recess to be enabled or disabled, depending on if they did anything yet.
        Button recess = (Button) findViewById(R.id.recessButton);
        recess.setEnabled(DataManager.getInstance().curStudent.canRecess);

    }

    public void toQuiz(View view){
        Intent intent = new Intent(this, QuizStartActivity.class);
        startActivity(intent);
    }

    public void toClassroom(View view){
        Intent intent = new Intent(this, ClassroomActivity.class);
        startActivity(intent);
    }

    public void toRecess(View view){
        Intent intent = new Intent(this, RecessActivity.class);
        startActivity(intent);
    }

}
