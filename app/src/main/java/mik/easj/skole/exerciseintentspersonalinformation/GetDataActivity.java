package mik.easj.skole.exerciseintentspersonalinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetDataActivity extends AppCompatActivity {

    public static final String NAVN = "navn";
    public static final String ADRESSE = "adresse";
    public static final String SHOESIZE = "shoesize";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
    }

    public void okclick(View view){
        Intent data = new Intent();
        EditText _navnview = findViewById(R.id.NavnFelt);
        EditText _adresseview = findViewById(R.id.AdresseFelt);
        EditText _shoesizeview = findViewById(R.id.ShoesizeFelt);

        String navn = _navnview.getText().toString();
        String adresse = _adresseview.getText().toString();
        String shoesize = _shoesizeview.getText().toString();

        data.putExtra(NAVN, navn);
        data.putExtra(ADRESSE, adresse);
        data.putExtra(SHOESIZE, shoesize);
        setResult(RESULT_OK, data);

        finish();
    }
}
