package com.example.android.electronicsquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.android.electronicsquiz.R.id.q1CapAns;
import static com.example.android.electronicsquiz.R.id.q1IndAns;
import static com.example.android.electronicsquiz.R.id.q1PotAns;
import static com.example.android.electronicsquiz.R.id.q1ResAns;
import static com.example.android.electronicsquiz.R.id.q3Ans;
import static com.example.android.electronicsquiz.R.id.q5eq1Ans;
import static com.example.android.electronicsquiz.R.id.q5eq2Ans;
import static com.example.android.electronicsquiz.R.id.q5eq3Ans;
import static com.example.android.electronicsquiz.R.id.q5eq4Ans;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
    }

    Integer totalScore = 0;

    public void submit(View view) {
        totalScore = 0;

        // Question 1 Score Calculation:
        EditText Q1Ans1Id = (EditText) findViewById(q1IndAns);
        boolean sQ1Ans1 = TextUtils.isEmpty(Q1Ans1Id.getText());
        if (sQ1Ans1) {
            Toast.makeText(getApplicationContext(), R.string.Q1IndError, Toast.LENGTH_LONG).show();
            return;
        } // Error checking for Working Capacity entered
        Integer Q1Ans = Integer.parseInt(Q1Ans1Id.getText().toString());
        if (Q1Ans == 3) {
            totalScore += 1;
        }

        EditText Q1Ans2Id = (EditText) findViewById(q1ResAns);
        boolean sQ1Ans2 = TextUtils.isEmpty(Q1Ans2Id.getText());
        if (sQ1Ans2) {
            Toast.makeText(getApplicationContext(), R.string.Q1ResError, Toast.LENGTH_LONG).show();
            return;
        } // Error checking for Working Capacity entered
        Integer Q2Ans = Integer.parseInt(Q1Ans2Id.getText().toString());
        if (Q2Ans == 1) {
            totalScore += 1;
        }

        EditText Q1Ans3Id = (EditText) findViewById(q1CapAns);
        boolean sQ1Ans3 = TextUtils.isEmpty(Q1Ans3Id.getText());
        if (sQ1Ans3) {
            Toast.makeText(getApplicationContext(), R.string.Q1CapError, Toast.LENGTH_LONG).show();
            return;
        } // Error checking for Working Capacity entered
        Integer Q3Ans = Integer.parseInt(Q1Ans3Id.getText().toString());
        if (Q3Ans == 2) {
            totalScore += 1;
        }

        EditText Q1Ans4Id = (EditText) findViewById(q1PotAns);
        boolean sQ1Ans4 = TextUtils.isEmpty(Q1Ans4Id.getText());
        if (sQ1Ans4) {
            Toast.makeText(getApplicationContext(), R.string.Q1PotError, Toast.LENGTH_LONG).show();
            return;
        } // Error checking for Working Capacity entered
        Integer Q4Ans = Integer.parseInt(Q1Ans4Id.getText().toString());
        if (Q4Ans == 4) {
            totalScore += 1;
        }

        // Question 2 Score Calculation:
        RadioGroup IndRadioGroup = (RadioGroup) findViewById(R.id.q2RadGrp1);
        RadioButton IndAnswerId = (RadioButton) findViewById(R.id.q2RadBtnInd3);

        RadioGroup CapRadioGroup = (RadioGroup) findViewById(R.id.q2RadGrp2);
        RadioButton CapAnswerId = (RadioButton) findViewById(R.id.q2RadBtnCap2);

        RadioGroup ResRadioGroup = (RadioGroup) findViewById(R.id.q2RadGrp3);
        RadioButton ResAnswerId = (RadioButton) findViewById(R.id.q2RadBtnRes4);

        RadioGroup PotRadioGroup = (RadioGroup) findViewById(R.id.q2RadGrp4);
        RadioButton PotAnswerId = (RadioButton) findViewById(R.id.q2RadBtnPot1);

        int indSelectedId = IndRadioGroup.getCheckedRadioButtonId();
        if (indSelectedId == IndAnswerId.getId()) {
            totalScore += 1;
        }

        int capSelectedId = CapRadioGroup.getCheckedRadioButtonId();
        if (capSelectedId == CapAnswerId.getId()) {
            totalScore += 1;
        }

        int ResSelectedId = ResRadioGroup.getCheckedRadioButtonId();
        if (ResSelectedId == ResAnswerId.getId()) {
            totalScore += 1;
        }

        int PotSelectedId = PotRadioGroup.getCheckedRadioButtonId();
        if (PotSelectedId == PotAnswerId.getId()) {
            totalScore += 1;
        }

        // Question 3 Score Calculation:
        EditText Q3AnsId = (EditText) findViewById(q3Ans);
        boolean sQ3Ans = TextUtils.isEmpty(Q3AnsId.getText());
        if (sQ3Ans) {
            Toast.makeText(getApplicationContext(), R.string.Q3Error, Toast.LENGTH_LONG).show();
            return;
        } // Error checking for Working Capacity entered
        Integer Q3Answer = Integer.parseInt(Q3AnsId.getText().toString());
        if (Q3Answer == 4) {
            totalScore += 1;
        }

        // Question 4 Score Calculation:
        Spinner spinner = (Spinner) findViewById(R.id.q4Spinner);
        String q4Ans = spinner.getSelectedItem().toString();
        if (q4Ans.equals(getString(R.string.q4answer))) {
            totalScore += 1;
        }

        // Question 4 Score Calculation:
        final CheckBox q5ans1 = (CheckBox) findViewById(q5eq1Ans);
        final CheckBox q5ans2 = (CheckBox) findViewById(q5eq2Ans);
        final CheckBox q5ans3 = (CheckBox) findViewById(q5eq3Ans);
        final CheckBox q5ans4 = (CheckBox) findViewById(q5eq4Ans);

        if (q5ans1.isChecked()) {
            totalScore += 1;
        }
        if (q5ans2.isChecked()) {
            totalScore += 0;
        } else {
            totalScore += 1;
        }
        if (q5ans3.isChecked()) {
            totalScore += 0;
        } else {
            totalScore += 1;
        }
        if (q5ans4.isChecked()) {
            totalScore += 1;
        }

        // Score Toast Messages:
        String ToastMessage;
        if (totalScore == 14) {
            ToastMessage = getString(R.string.Ans10of10);
        } else if (totalScore > 10) {
            ToastMessage = getString(R.string.AnsHighof10Start) + totalScore.toString() + getString(R.string.Ansof10End);
        } else if (totalScore > 5) {
            ToastMessage = getString(R.string.AnsMidof10Start) + totalScore.toString() + getString(R.string.Ansof10End);
        } else if (totalScore > 0) {
            ToastMessage = getString(R.string.AnsLowof10Start) + totalScore.toString() + getString(R.string.Ansof10End);
        } else ToastMessage = getString(R.string.Ans0of10);

        Toast.makeText(getApplicationContext(), ToastMessage, Toast.LENGTH_LONG).show();


    }


}