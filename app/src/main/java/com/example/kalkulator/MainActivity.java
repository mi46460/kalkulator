package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView results;
    String workings = "";
    String formula = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextViews();
    }

    private void initTextViews()
    {
        results = (TextView)findViewById(R.id.tampilan);
    }

    private void updateView(String givenValue)
    {
        workings = workings + givenValue;
        results.setText(workings);
    }

    public void klikTombolSamaDengan(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(workings);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            results.setText(String.valueOf(result.doubleValue()));
    }

    public void klikBagi(View view) {
        updateView("/");
    }

    public void klikNomorTujuh(View view) {
        updateView("7");
    }

    public void klikTombolC(View view) {
        results.setText("");
        workings = "";
    }

    public void klikNomor8(View view) {
        updateView("8");
    }

    public void klikNomor9(View view) {
        updateView("9");
    }

    public void klikTombolKali(View view) {
        updateView("*");
    }

    public void klikNomor4(View view) {
        updateView("4");
    }

    public void klikNomor5(View view) {
        updateView("5");
    }

    public void klikNomor6(View view) {
        updateView("6");
    }

    public void klikTombolMinus(View view) {
        updateView("-");
    }

    public void klikNomor1(View view) {
        updateView("1");
    }

    public void klikNomor2(View view) {
        updateView("2");
    }

    public void klikNomor3(View view) {
        updateView("3");
    }

    public void klikTombolTambah(View view) {
        updateView("+");
    }

    public void klikNomorNol(View view) {
        updateView("0");
    }

    public void klikTombolTitik(View view) {
        updateView(".");
    }

    public void klikBackspace(View view) {
        StringBuffer sb= new StringBuffer(workings);
        workings = "";
        sb.deleteCharAt(sb.length()-1);
        workings = String.valueOf(sb);
        results.setText(workings);
    }
}