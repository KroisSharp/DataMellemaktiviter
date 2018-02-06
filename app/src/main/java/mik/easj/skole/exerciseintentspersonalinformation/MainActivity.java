package mik.easj.skole.exerciseintentspersonalinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int GetDataReqCode = 47;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void okclick(View view) {
        Intent myIntent = new Intent(this,GetDataActivity.class);
        startActivityForResult(myIntent, GetDataReqCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView messageView = findViewById(R.id.MinData);
        if (requestCode == GetDataReqCode) {
            if (resultCode == RESULT_CANCELED) {
                messageView.setText("You cancelled. Try again");
            } else {
                String navn = data.getStringExtra(GetDataActivity.NAVN);
                String adresse = data.getStringExtra(GetDataActivity.ADRESSE);
                String shoesize = data.getStringExtra(GetDataActivity.SHOESIZE);
                //dette står i cluster fuck men vi vil gerne se al data
                messageView.setText(navn+adresse+shoesize);
            }
        } else {
            messageView.setText("Strange requestCode !?");
        }
    }
}
