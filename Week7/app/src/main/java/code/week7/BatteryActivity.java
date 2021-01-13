package code.week7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BatteryActivity extends AppCompatActivity {

    private static final String BATTER_LEVEL_KEY = "battery_level_key";

    private ImageView battery;
    private Button btnMinus;
    private Button btnPlus;

    private int currentLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        battery = findViewById(R.id.imgBattery);

        btnMinus = findViewById(R.id.minus);
        btnPlus = findViewById(R.id.plus);

        // recovering the instance state
        if (savedInstanceState != null) {
            currentLevel = savedInstanceState.getInt(BATTER_LEVEL_KEY, 1);
        }

        updateBatteryLevel(currentLevel);
        updateButtonState(currentLevel);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(BATTER_LEVEL_KEY, currentLevel);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onBatteryChangeMinus(View view) {
        --currentLevel;
        updateBatteryLevel(currentLevel);
        updateButtonState(currentLevel);
    }

    public void onBatteryChangePlus(View view) {
        ++currentLevel;
        updateBatteryLevel(currentLevel);
        updateButtonState(currentLevel);
    }

    private void updateBatteryLevel(int level) {
        battery.setImageLevel(level);
    }

    private void updateButtonState(int level) {
        btnMinus.setEnabled(level > 1);
        btnPlus.setEnabled(level < 7);
    }

}