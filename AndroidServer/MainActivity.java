import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button btn;
    public EditText inputext;
    public ScrollView scrolldisplay;
    public LinearLayout ll;
    AndroidRatServer rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonone);
        inputext = findViewById(R.id.inputone);
        scrolldisplay = findViewById(R.id.scrollviewone);
        ll = findViewById(R.id.scrollviewLL);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView data = new TextView(getApplicationContext());
                rs.nextToSend = inputext.getText().toString();

            }
        });

        rs = new ratServer(this);


    }
}
