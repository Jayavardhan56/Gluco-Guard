package com.example.glucoguard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private EditText editFasting, editAfterMeal;
    private TextView textResult, textRecommendation, textMedicine;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Gluco Guard");

        editFasting = findViewById(R.id.editFasting);
        editAfterMeal = findViewById(R.id.editAfterMeal);
        textResult = findViewById(R.id.textResult);
        textRecommendation = findViewById(R.id.textRecommendation);
        textMedicine = findViewById(R.id.textMedicine);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> analyzeSugarLevels());
    }

    private void analyzeSugarLevels() {
        int fasting = Integer.parseInt(editFasting.getText().toString());
        int afterMeal = Integer.parseInt(editAfterMeal.getText().toString());
        String severity = Utils.getSeverity(fasting, afterMeal);

        textResult.setText("Severity: " + severity);

        switch (severity) {
            case "Perfect":
                textRecommendation.setText("Recommended: Balanced Diet, Fruits, Vegetables.");
                textMedicine.setText("Prescribed: No medication required.");
                break;
            case "Moderate":
                textRecommendation.setText("Recommended: Low sugar intake, Whole Grains.");
                textMedicine.setText("Prescribed: Mild Sugar Regulators.");
                break;
            case "Risky":
                textRecommendation.setText("Recommended: Strict Low-Carb Diet, Exercise.");
                textMedicine.setText("Prescribed: Insulin or Stronger Medication.");
                break;
        }
    }
}
