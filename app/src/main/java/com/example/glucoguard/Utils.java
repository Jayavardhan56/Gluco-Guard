package com.example.glucoguard;

public class Utils {
    public static String getSeverity(int fasting, int afterMeal) {
        if (fasting >= 90 && fasting <= 140 && afterMeal >= 90 && afterMeal <= 140) {
            return "Perfect";
        } else if (fasting >= 110 && fasting <= 160 && afterMeal >= 110 && afterMeal <= 160) {
            return "Moderate";
        } else if (fasting > 200 || afterMeal > 200) {
            return "Risky";
        }
        return "Unknown";
    }
}
