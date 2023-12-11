package project.attendease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button administratorButton, facultyButton, studentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        administratorButton = findViewById(R.id.button0);
        facultyButton = findViewById(R.id.button1);
        studentButton = findViewById(R.id.button2);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentIntent = new Intent(MainActivity.this, StudentMain.class);
                MainActivity.this.startActivity(studentIntent);
            }
        });
    }
}